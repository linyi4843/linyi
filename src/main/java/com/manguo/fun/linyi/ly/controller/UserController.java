package com.manguo.fun.linyi.ly.controller;


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

        return service.getById(1);
    }

}
