package icu.shishc.applet.service.impl;

import com.alibaba.fastjson.JSONObject;
import icu.shishc.applet.config.shiro.JwtToken;
import icu.shishc.applet.controller.dto.LoginDTO;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.exception.CustomException;
import icu.shishc.applet.mapper.UserMapper;
import icu.shishc.applet.service.WxService;
import icu.shishc.applet.util.JwtUtil;
import icu.shishc.applet.vo.WxLoginResponseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;

@Service
public class WxServiceImpl implements WxService {

    private static final String LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String grantType = "authorization_code";

    private static final String appId = "wxc734369caf37fe10";
    private static final String secret = "c0918a593b9420a6e6acd4b6da29695c";

    @Resource
    RestTemplate restTemplate;
    @Resource
    UserMapper userMapper;
    @Resource
    JwtUtil jwtUtil;

    /**
     * wx用户登录
     * @param code 前端传来的 code
     * @throws CustomException 微信服务可能请求失败
     */
    @Override
    public LoginDTO login(String code) throws CustomException {
        String resultJson = this.analysisUserInfo(code);
        WxLoginResponseVo loginResponse = JSONObject.toJavaObject(JSONObject.parseObject(resultJson), WxLoginResponseVo.class);
        System.out.println("loginResponse: " + loginResponse);
        if (!loginResponse.getErrcode().equals("0")) {
            throw new CustomException("wxApi.login=> bad request.", HttpStatus.OK);
        }
        User userInfo = userMapper.getUserByOpenId(loginResponse.getOpenid());
        if (userInfo == null) {
            userInfo = new User();
            userInfo.setOpenId(loginResponse.getOpenid());
            userMapper.insertUser(userInfo);
        }
        String token = jwtUtil.genTokenByWXAccount(userInfo);
        System.out.println("WxService.login()=> userId:[" + userInfo.getUserId() +"], identity[" + userInfo.getUserIdentity() +"]");
        return new LoginDTO(token, userInfo.getUserId(), userInfo.getUserIdentity());
    }

    /**
     * code - 从前端传来的code
     * 请求wxApi, 获取用户信息json.
     */
    private String analysisUserInfo(String code) {
        // GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("appid", appId);
        paramsMap.add("secret", secret);
        paramsMap.add("js_code", code);
        paramsMap.add("grant_type", grantType);
        URI code2session = this.getURIWithParams(LOGIN_URL, paramsMap);
        return restTemplate.exchange(code2session, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class).getBody();
    }

    /**
     * URI 工具类.
     * url - 请求的url地址
     * params - 请求参数.
     */
    private URI getURIWithParams(String url, MultiValueMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        return builder.build().encode().toUri();
    }
}
