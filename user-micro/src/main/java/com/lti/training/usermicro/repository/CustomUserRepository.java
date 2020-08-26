package com.lti.training.usermicro.repository;

import com.lti.training.usermicro.entity.User;

public interface CustomUserRepository {
	// add your custom methods
	User someComplexDbRequirement(String param);
}
