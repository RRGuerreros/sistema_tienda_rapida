package com.bodega.rapida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.rapida.entity.User;
import com.bodega.rapida.http.MessageCode;
import com.bodega.rapida.http.ResponseAjax;
import com.bodega.rapida.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userService;

	@PostMapping
	@ResponseBody
	public ResponseAjax<String> save( @RequestBody User user ){
		
		ResponseAjax<String> result = new ResponseAjax<>();
		
		try {
			
			User find_user = userService.findByPhone(user.getPhone());
			
			if( find_user == null ) {
				userService.save(user);
				result.setParametersResponse( MessageCode.SAVE_SUCCESS, true);
			} else {
				result.setParametersResponse("El celular del usuario ingresado ya existe, no se pudo registrar.", false);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: " +e.getMessage(), false);
		}
		return result;
	}
	
	
	@GetMapping("/login")
	@ResponseBody
	public ResponseAjax<User> findByCelular( 
			@RequestParam("phone") String phone,
			@RequestParam("password") String password ){
		
		ResponseAjax<User> result=new ResponseAjax<User>();
		
		try {
			
			User find_user = userService.userExists(phone, password);
			
			result.setObject(find_user);
			result.setParametersResponse("", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: "+e.getMessage(), false);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
