package com.blhx.book_managers.interceptor;

import com.blhx.book_managers.model.Ticket;
import com.blhx.book_managers.model.User;
import com.blhx.book_managers.service.TicketService;
import com.blhx.book_managers.service.UserService;
import com.blhx.book_managers.utils.ConcurrentUtils;
import com.blhx.book_managers.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class HostInfoInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    /**
     * 为注入host信息
     *
     */
    @Override
    public boolean preHandle ( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception{
        String t=CookieUtils.getCookie("t", request);
        if (!StringUtils.isEmpty(t)){
            Ticket ticket=ticketService.getTicket(t);
            if (ticket!=null && ticket.getExpiredAt().after(new Date())){
                User host=userService.getUser(ticket.getId());
                ConcurrentUtils.setHost(host);
            }
        }
        return true;
    }
}
