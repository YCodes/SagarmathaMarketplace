/*package com.sagarmatha.interceptor;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;

public class RoleInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		Principal principal = request.getUserPrincipal();
		if(principal != null && principal instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
			Collection<GrantedAuthority> authorities = token.getAuthorities();
			if(authorities.size() >0) {
				String roleValue = authorities.iterator().next().getAuthority();
				Role role = Role.valueOf(roleValue);
				User user = new User();
				user.setUserName(token.getName());
				user.setRole(role);
				request.setAttribute("currentUser",user);
			}
		}
		
		return super.preHandle(request, response, handler);
		
	}

}
*/