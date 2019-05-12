package com.manguo.fun.linyi.ly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.manguo.fun.linyi.ly.common.Result;
import com.manguo.fun.linyi.ly.common.exception.LinYiException;
import com.manguo.fun.linyi.ly.entity.User;
import com.manguo.fun.linyi.ly.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Result getHello(String id) {
        return Result.success(service.getOne(new QueryWrapper<>(User.builder().id(Integer.parseInt(id)).build())));
    }

    @RequestMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result update(String id) {
        service.save(User.builder().name("rou").build());
        service.updateById(User.builder().id(Integer.parseInt(id)).name("765353454").build());
        return Result.success();
    }

    @GetMapping("/error")
    public Result error() throws LinYiException {
        throw new LinYiException("天黑了");
    }

}
