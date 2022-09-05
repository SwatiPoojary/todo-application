package com.springboot.todoapp.util;

import org.springframework.security.core.context.SecurityContextHolder;import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TodoUtil {

	public String getUserDetails() {
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(obj instanceof UserDetails) {
			return ((UserDetails) obj).getUsername();
		}
		
		return obj.toString();
	}
}
