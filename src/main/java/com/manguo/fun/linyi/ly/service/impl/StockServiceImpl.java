package com.manguo.fun.linyi.ly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manguo.fun.linyi.ly.entity.Stock;
import com.manguo.fun.linyi.ly.mapper.StockMapper;
import com.manguo.fun.linyi.ly.service.StockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author linyi
 * @since 2019-04-17
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Override
    public void updateStock(Long id) {
        baseMapper.updateStock(id);
    }
}
