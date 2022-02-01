package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.mapper.UserMapper;
import icu.shishc.applet.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User updateUserInfo(UserUpdateParam userInfo) {
        Long userId = userInfo.getUserId();
        User user = userMapper.getUserByUserId(userId);
        if (user == null) {
            return null;
        }
        user.setRealName(userInfo.getRealName());
        user.setWxName(userInfo.getWxName());
        user.setAvatar(userInfo.getAvatar());
        user.setAddress(userInfo.getAddress());
        user.setPhone(userInfo.getPhone());
        user.setAge(userInfo.getAge());
        user.setGender(userInfo.getGender());
        userMapper.updateUserInfo(user);
        return user;
    }

}
