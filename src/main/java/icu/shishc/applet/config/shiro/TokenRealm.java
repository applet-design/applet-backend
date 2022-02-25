package icu.shishc.applet.config.shiro;

import icu.shishc.applet.entity.Perms;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.exception.TokenException;
import icu.shishc.applet.service.UserService;
import icu.shishc.applet.util.JwtUtil;
import icu.shishc.applet.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TokenRealm extends AuthorizingRealm {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private UserService userservice;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = ((User) SecurityUtils.getSubject().getPrincipal());
        List<Perms> permsList = userservice.getUserPerms(user.getUserIdentity());
        for (Perms perm : permsList) {
            info.addStringPermission(perm.getEntity().toUpperCase() + ":" + perm.getPerm().toUpperCase());
        }
        System.out.println("TokenRealm[doGetAuthorizationInfo]: userId:" + user.getUserId() + " => info:" + info.getStringPermissions());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String openId = jwtUtil.getOpenIdByToken(token);
        String userId = String.valueOf(jwtUtil.getUserIdByToken(token));
        if (StringUtils.isEmpty(openId)) {
            throw new TokenException("TokenRealm.doGetAuthenticationInfo=> openId null.");
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
