package com.bodega.rapida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.rapida.entity.Order;
import com.bodega.rapida.entity.OrderDetail;
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
	public ResponseAjax<Order> saveAndReturnOrder( @RequestBody Order order ){
		
		ResponseAjax<Order> result=new ResponseAjax<>();
		
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
	
	@GetMapping("/find")
	@ResponseBody
	public ResponseAjax<Order> findByStateOrderByDateEmisionAsc(
			@RequestParam("state") String state ){
		
		ResponseAjax<Order> result=new ResponseAjax<Order>();
		
		try {
			result.setList( orderService.findByStateOrderByDateEmisionAsc(state) );
			result.setParametersResponse("", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: " + e.getMessage(), false);
		}
		
		return result;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseAjax<Order> findByStatesOrderByDateEmisionAsc(
			@PathVariable("id") int idOrder ){
		
		ResponseAjax<Order> result=new ResponseAjax<>();
		
		try {
			result.setObject( orderService.findById(idOrder) );
			result.setParametersResponse("", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: " + e.getMessage(), false);
		}

		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
