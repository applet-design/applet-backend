package icu.shishc.applet.config;

import icu.shishc.applet.config.shiro.JwtToken;
import icu.shishc.applet.config.shiro.TokenRealm;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtTest {

    @Resource
    JwtUtil jwtUtil;
    @Resource
    TokenRealm tokenRealm;

    @Test
    public void tokenTest() {
        User user = new User(
                131232L,
                "shishc",
                "shishc",
                "shishc",
                "xingpingshi",
                "137...",
                1,
                1
        );

        String token = jwtUtil.genTokenByWXAccount(user);
        JwtToken jwtToken = new JwtToken(token);
        AuthenticationInfo authenticationInfo = tokenRealm.getAuthenticationInfo(jwtToken);
        System.out.println(authenticationInfo.toString());
    }
}
