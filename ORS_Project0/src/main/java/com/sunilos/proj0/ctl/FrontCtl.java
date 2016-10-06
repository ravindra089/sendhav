package com.sunilos.proj0.ctl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FrontCtl extends HandlerInterceptorAdapter{

	 @Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {

	        System.out.println("Front Ctl Called");

	        HttpSession session = request.getSession();
	        if (session.getAttribute("user") == null) {
	            request.setAttribute("error", "OOPS! Your session has been expired");
	            RequestDispatcher rd = request.getRequestDispatcher("/Login");
	            rd.forward(request, response);
	            return false;
	        }
	        return true;
	    }
}
