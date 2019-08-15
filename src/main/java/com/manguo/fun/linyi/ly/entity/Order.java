package com.manguo.fun.linyi.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Created with IDEA
 *
 * @author: linyi
 * @Email: linyi4843@gmail.com
 */

@Data
@Builder
@TableName("ly_order")
public class Order {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("stock_id")
    private Long stockId;
}
