package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.entity.Perms;
import icu.shishc.applet.entity.User;

import java.util.List;

public interface UserService {

    // 更新用户信息
    User updateUserInfo(UserUpdateParam userInfo);

    // 获取用户信息
    User getUserInfo(Long userId);

    // 获取用户权限list
    List<Perms> getUserPerms(Integer userIdentity);
}
