package icu.shishc.applet.filter;

import icu.shishc.applet.config.shiro.JwtToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends BasicHttpAuthenticationFilter {

    /**
     * 登录逻辑.
     * 拿到 request.token 字段后登录
     * 若 token 错误可能会抛出异常 这个不确定...
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            JwtToken token = new JwtToken(getAuthzHeader(request));
            getSubject(request, response).login(token);
        }
        return true;
    }

    /**
     * 需要登陆才能访问的接口，请求头里必须有 token 字段.
     */
    @Override
    protected String getAuthzHeader(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        return httpServletRequest.getHeader("token");
    }

    /**
     * isLoginAttempt(request, response) 会调用，先返回true.
     */
    @Override
    protected boolean isLoginAttempt(String authzHeader) {
        return true;
    }
}
