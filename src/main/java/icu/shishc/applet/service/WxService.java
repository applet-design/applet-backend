package icu.shishc.applet.service;

import icu.shishc.applet.controller.dto.LoginDTO;
import icu.shishc.applet.exception.CustomException;

public interface WxService {
    LoginDTO login(String code) throws CustomException;
}
