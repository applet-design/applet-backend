package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.entity.User;

public interface UserService {

    User updateUserInfo(UserUpdateParam userInfo);

}
