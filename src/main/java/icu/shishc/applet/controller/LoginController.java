package icu.shishc.applet.controller;

import icu.shishc.applet.controller.dto.LoginDTO;
import icu.shishc.applet.controller.param.LoginParam;
import icu.shishc.applet.exception.CustomException;
import icu.shishc.applet.service.WxService;
import icu.shishc.applet.util.JwtUtil;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    WxService wxService;
    @Resource
    JwtUtil jwtUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultJson login(@RequestBody LoginParam loginParam) throws CustomException {
        String token = wxService.login(loginParam.getCode());
        Long userId = jwtUtil.getUserIdByToken(token);
        LoginDTO loginDTO = new LoginDTO(token, userId);
        return ResultJson.ok(loginDTO);
    }

}
