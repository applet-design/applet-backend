package icu.shishc.applet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @desc: 测试接口，不对外开放.
 * @author ShiShc
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/index")
    public String testIndex() {
        return "index. -- icu.shishc.applet.controller.TestController.testIndex()";
    }
}
