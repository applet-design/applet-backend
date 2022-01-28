package icu.shishc.applet.service;

import com.alibaba.fastjson.JSONObject;
import icu.shishc.applet.exception.CustomException;
import icu.shishc.applet.vo.WxLoginResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxServiceTest {

    private static final String LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String grantType = "authorization_code";
    private static final String appId = "wxc734369caf37fe10";
    private static final String secret = "c0918a593b9420a6e6acd4b6da29695c";

    @Resource
    RestTemplate restTemplate;

    @Test
    public void wxApiTest() throws CustomException {
        String code = "";
        String resultJson = this.analysisUserInfo(code);
        WxLoginResponseVo loginResponse = JSONObject.toJavaObject(JSONObject.parseObject(resultJson), WxLoginResponseVo.class);
        System.out.println(loginResponse.toString());
    }

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

    private URI getURIWithParams(String url, MultiValueMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        return builder.build().encode().toUri();
    }

}
