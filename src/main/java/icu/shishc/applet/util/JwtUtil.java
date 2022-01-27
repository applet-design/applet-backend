package icu.shishc.applet.util;

import com.auth0.jwt.JWTVerifier;
import icu.shishc.applet.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    // jwt 过期时间. 7200s <-> 2h
    private static final int EXPIRE_TIME = 7200;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 微信用户登录创建token, token会二次缓存在redis中
     * @param userinfo 用户
     * @return token
     */
    public String genTokenByWXAccount(User userinfo) {
        // 随机生成 jwtId 用于验证
        String jwtId = UUID.randomUUID().toString();
        // 签名算法
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        // token
        String token = JWT.create()
                .withClaim("userId", userinfo.getUserId())
                .withClaim("unionId", userinfo.getUnionId())
                .withClaim("jwtId", jwtId)
                // 过期时间. 单位是 ms 所以 *1000.
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000))
                .sign(algorithm);
        stringRedisTemplate.opsForValue().set("jwtId-" + jwtId, token, EXPIRE_TIME, TimeUnit.SECONDS);
        return token;
    }

    /**
     * 验证token是否正确
     * 1. 根据token解密，找出jwtId，查找redis中对比是否相同
     * 2. 若相同进行key更新
     * @param token jwtToken
     * @return 更新是否成功. 若其中有一处失败，则抛出异常
     */
    public boolean verifyToken(String token) {
        try {
            String jwtId = getJwtIdByToken(token);
            String redisToken = stringRedisTemplate.opsForValue().get("jwtId-" + jwtId);
            if (!token.equals(redisToken)) {
                return false;
            }
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userId", getUserIdByToken(token))
                    .withClaim("unionId", getUnionIdByToken(token))
                    .withClaim("jwtId", jwtId)
                    .acceptExpiresAt(System.currentTimeMillis() + EXPIRE_TIME * 1000)
                    .build();
            verifier.verify(redisToken);
            stringRedisTemplate.opsForValue().set("jwtId-" + jwtId, redisToken, EXPIRE_TIME, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据token获取payload字段, 下同.
     * 这里不对jwt本身安全性正确性进行检查.
     * 所以有可能token错误但还能解析出id.
     */
    //  getUserIdByToken() 方法. 进行判断建议使用 String.valueOf() 进行转化.
    public Long getUserIdByToken(String token) {
        return JWT.decode(token).getClaim("userId").asLong();
    }

    public String getUnionIdByToken(String token) {
        return JWT.decode(token).getClaim("unionId").asString();
    }

    public String getJwtIdByToken(String token) {
        return JWT.decode(token).getClaim("jwtId").asString();
    }

}
