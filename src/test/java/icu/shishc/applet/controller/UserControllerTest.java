package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.UserUpdateParam;
import icu.shishc.applet.util.ResultJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Resource
    UserController userController;

    @Test
    public void test01() {
        UserUpdateParam updateParam = new UserUpdateParam(1L,
                "shishc",
                null,
                "ShiShc",
                "China",
                "13772183081",
                22,
                null
                );
        ResultJson resultJson = userController.updateUserInfo(updateParam);
        System.out.println(resultJson);
    }

}
