package com.fulln.security.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {

        String f = request.getParameter("f");
        String ru = (String) request.getSession().getAttribute("preUrl");
        request.getSession().removeAttribute("preUrl");

        if (StringUtils.isNotEmpty(ru)) {
           //要返回json格式的时候
                response.setCharacterEncoding("UTF-8");
                response.sendRedirect(ru);
        } else {
                response.sendRedirect("/TaskWeb/home/index");//转到默认登录页面
        }
    }

}  