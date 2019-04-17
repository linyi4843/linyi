package com.manguo.fun.linyi.ly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manguo.fun.linyi.ly.entity.User;
import com.manguo.fun.linyi.ly.mapper.UserMapper;
import com.manguo.fun.linyi.ly.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linyi
 * @since 2019-04-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
