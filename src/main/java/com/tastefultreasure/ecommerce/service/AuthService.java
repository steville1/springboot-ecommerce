package com.tastefultreasure.ecommerce.service;

import com.tastefultreasure.ecommerce.payload.LoginDto;
import com.tastefultreasure.ecommerce.payload.RegisterDto;

public interface AuthService {
	
	String login(LoginDto loginDto);

    String register(RegisterDto registerDto);

}
