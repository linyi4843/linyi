package com.manguo.fun.linyi.ly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.manguo.fun.linyi.ly.entity.User;
import com.manguo.fun.linyi.ly.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linyi
 * @since 2019-04-17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ly/user")
public class UserController {

    private final IUserService service;

    @RequestMapping("/hello")
    public Object getHello(){

        return service.getOne(new QueryWrapper<>(User.builder().id(1).build()));
    }

}
