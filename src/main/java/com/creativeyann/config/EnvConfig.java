package com.creativeyann.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvConfig {
	
	@Autowired
	private Environment environment;
	
	public  boolean isActiveProfile(String profile) {
		for (String p : environment.getActiveProfiles()) {
			if (p != null && p.trim().equalsIgnoreCase(profile.trim())) {
				return true;
			}
		}
		return false;
	}


}
