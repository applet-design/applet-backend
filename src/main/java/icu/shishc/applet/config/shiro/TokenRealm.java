package icu.shishc.applet.config.shiro;

import icu.shishc.applet.exception.TokenException;
import icu.shishc.applet.util.JwtUtil;
import icu.shishc.applet.util.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TokenRealm extends AuthorizingRealm {

    @Resource
    private JwtUtil jwtUtil;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String unionId = jwtUtil.getUnionIdByToken(token);
        String userId = String.valueOf(jwtUtil.getUserIdByToken(token));
        if (StringUtils.isEmpty(unionId)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> unionId null.");
        }
        if (StringUtils.isEmpty(userId)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> userId null.");
        }
        if (!jwtUtil.verifyToken(token)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> token wrong.");
        }
        return new SimpleAuthenticationInfo(userId, token, getName());
    }
}
