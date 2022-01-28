package icu.shishc.applet.filter;

import icu.shishc.applet.config.shiro.JwtToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * 跨域请求
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
