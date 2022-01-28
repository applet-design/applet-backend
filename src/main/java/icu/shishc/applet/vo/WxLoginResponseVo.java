package icu.shishc.applet.vo;

import lombok.Data;

@Data
public class WxLoginResponseVo {
    private String openid;
    private String session_key;
    private String unionid;
    private String errcode = "0";
    private String errmsg;
}
