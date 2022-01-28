package icu.shishc.applet.service;

import icu.shishc.applet.exception.CustomException;

public interface WxService {
    String login(String code) throws CustomException;
}
