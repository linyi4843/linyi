package com.manguo.fun.linyi.ly.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.manguo.fun.linyi.ly.common.redis.RedisLock;
import com.manguo.fun.linyi.ly.entity.Order;
import com.manguo.fun.linyi.ly.entity.Stock;
import com.manguo.fun.linyi.ly.service.OrderService;
import com.manguo.fun.linyi.ly.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IDEA
 *
 * @author: linyi
 * @Email: linyi4843@gmail.com
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {


    private final RedisLock lock;

    private final StringRedisTemplate redisTemplate;

    private final StockService stockService;

    private final OrderService orderService;

    private static final String STOCK = "stock:";

    private static ConcurrentHashMap<Long, Boolean> concurrentHashMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void redis() {
        List<Stock> list = stockService.list();

        for (Stock stock : list) {
            redisTemplate.opsForValue().set(STOCK + stock.getId(), stock.getStock().toString());
        }
    }


    @PostMapping("/order/{id}")
    public R order(@PathVariable("id") Long id) {

        if (concurrentHashMap.get(id) != null) {
            return R.failed("卖完了");
        }

        Long s = redisTemplate.opsForValue().decrement(STOCK + id);
        log.info("redis -1 -> {} ", s);

        if (s == null) {
            return R.failed("商品不存在");
        }

        if (s < 0) {
            concurrentHashMap.put(id, true);
            Long increment = redisTemplate.opsForValue().increment(STOCK + id);
            log.info("redis +1 -> {}", increment);
            return R.failed("卖完了");
        }

        try {
            orderService.save(Order.builder().stockId(id).build());
        } catch (Exception e) {
            redisTemplate.opsForValue().increment(STOCK + id);
            concurrentHashMap.remove(id);
            return R.failed("创建订单失败");
        }

        //不减数据库库存,效率更高
        //stockService.updateStock(id);

        return R.ok(6);
    }

    @GetMapping("/t1")
    public Object t1() {
        boolean b = this.lock.lock("1", "2");
        return b;
    }

    @GetMapping("/t2")
    public Object t2() {
        boolean b = this.lock.unlock("1", "2");

        String s = redisTemplate.opsForValue().get("test : linyi");

        return s + b;
    }


}
