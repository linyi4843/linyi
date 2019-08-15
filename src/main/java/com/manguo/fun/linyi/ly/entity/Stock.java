package com.manguo.fun.linyi.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IDEA
 *
 * @author: linyi
 * @Email: linyi4843@gmail.com
 */

@Data
@TableName("ly_stock")
public class Stock {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("stock")
    private Long stock;

    @TableField("title")
    private String title;

}
