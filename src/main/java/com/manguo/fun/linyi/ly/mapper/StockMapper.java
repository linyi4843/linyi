package com.manguo.fun.linyi.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manguo.fun.linyi.ly.entity.Stock;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author linyi
 * @since 2019-04-17
 */
public interface StockMapper extends BaseMapper<Stock> {

    void updateStock(Long id);
}
