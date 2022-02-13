package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.entity.MaterialApplication;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.service.UserService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    ApplicationService applicationService;

    @RequestMapping(value = "/u", method = RequestMethod.PUT)
    public ResultJson updateUserInfo(@RequestBody UserUpdateParam updateParam) {
        User user = userService.updateUserInfo(updateParam);
        return ResultJson.ok(user);
    }

    @RequestMapping(value = "/u", method = RequestMethod.GET)
    public ResultJson getUserInfo(@RequestParam Long userId) {
        return ResultJson.ok(userService.getUserInfo(userId));
    }

    @RequestMapping(value = "/u/material", method = RequestMethod.GET)
    public ResultJson getUserMaterialApplication(@RequestParam Long userId) {
        List<MaterialApplication> userMaterialApplication = applicationService.getUserMaterialApplication(userId);
        return ResultJson.ok(userMaterialApplication);
    }

}
