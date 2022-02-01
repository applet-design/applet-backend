package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.service.UserService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/u", method = RequestMethod.PUT)
    public ResultJson updateUserInfo(@RequestBody UserUpdateParam updateParam) {
        User user = userService.updateUserInfo(updateParam);
        return ResultJson.ok(user);
    }

}
