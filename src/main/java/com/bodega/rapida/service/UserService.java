package com.bodega.rapida.service;

import com.bodega.rapida.entity.User;

public interface UserService {

	User findByPhone( String phone );
	
	User userExists( String phone, String password ) throws Exception;
	
	
}
