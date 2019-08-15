package com.manguo.fun.linyi.ly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manguo.fun.linyi.ly.entity.Order;
import com.manguo.fun.linyi.ly.mapper.OrderMapper;
import com.manguo.fun.linyi.ly.service.OrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
