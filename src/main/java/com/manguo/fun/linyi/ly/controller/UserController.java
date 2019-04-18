package com.manguo.fun.linyi.ly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.manguo.fun.linyi.ly.entity.User;
import com.manguo.fun.linyi.ly.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ly/user")
public class UserController {

    private final IUserService service;

    @RequestMapping("/hello")
    public Object getHello(){
        String logg = "555";
        log.debug("我是一只小小小小草 -> {}",logg);
        log.info("我是一只小小小小鸟 ->{}" ,logg);
        log.error("我是一只小小小小猪 -> {}" , logg);
        return service.getOne(new QueryWrapper<>(User.builder().id(1).build()));
    }

}
