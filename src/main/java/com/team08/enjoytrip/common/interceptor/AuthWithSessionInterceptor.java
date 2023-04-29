package com.team08.enjoytrip.common.interceptor;

import com.team08.enjoytrip.user.model.dto.UserDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Deprecated
//@Component
public class AuthWithSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userinfo");
        if(userDto == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }

}
