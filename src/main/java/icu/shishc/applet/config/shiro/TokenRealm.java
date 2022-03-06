package icu.shishc.applet.config.shiro;

import icu.shishc.applet.entity.User;
import icu.shishc.applet.exception.TokenException;
import icu.shishc.applet.util.JwtUtil;
import icu.shishc.applet.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = ((User) SecurityUtils.getSubject().getPrincipal());
        String role = "";
        switch (user.getUserIdentity()) {
            case 0: {
                role = "user";
                break;
            }
            case 1: {
                role = "admin";
                break;
            }
            case 2: {
                role = "administration";
                break;
            }
            default: {
                break;
            }
        }
        info.addRole(role);
        System.out.println("doGetAuthorizationInfo=> userId:[" + user.getUserId() + "], role:[" + role + "].");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String userId = String.valueOf(jwtUtil.getUserIdByToken(token));
        if (StringUtils.isEmpty(userId)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> userId null.");
        }
        if (!jwtUtil.verifyToken(token)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> token wrong.");
        }
        System.out.println("doGetAuthenticationInfo=> userId:[" + userId + "]");
        return new SimpleAuthenticationInfo(userId, token, getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
}
