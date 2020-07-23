package com.bodega.rapida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.rapida.entity.Producto;
import com.bodega.rapida.http.ResponseAjax;
import com.bodega.rapida.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productoService;
	
	
	@GetMapping("/stock_low")
	@ResponseBody
	public ResponseAjax<Producto> listProductsWithLowQuatity(
			@RequestParam("numberMin") int numberMin ){
		
		ResponseAjax<Producto> result=new ResponseAjax<>();
		
		try {			
			result.setList( productoService.listProductsWithLowQuantity(numberMin) );
			result.setParametersResponse("", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: "+e.getMessage(), false);
		}
		return result;
	}
	
	

	@GetMapping("/detail")
	@ResponseBody
	public ResponseAjax<Producto> findById( @RequestParam("id") int id ){
		
		ResponseAjax<Producto> result=new ResponseAjax<>();
	
		try {
			result.setObject( productoService.findById(id) );
			result.setParametersResponse("", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: "+e.getMessage(), false);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
