package com.bodega.rapida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.rapida.entity.Pedido;
import com.bodega.rapida.http.MessageCode;
import com.bodega.rapida.http.ResponseAjax;
import com.bodega.rapida.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;
	
	@PostMapping
	@ResponseBody
	public ResponseAjax<Pedido> saveAndReturnOrder( @RequestBody Pedido order ){
		
		ResponseAjax<Pedido> result=new ResponseAjax<>();
		
		try {
			
			orderService.saveAndReturnOrder(order);
			
			result.setObject(order);
			result.setParametersResponse(MessageCode.SAVE_SUCCESS, true);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: " + e.getMessage(), false);
		}
		
		return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
