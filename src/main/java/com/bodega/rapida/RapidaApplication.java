package com.bodega.rapida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bodega.rapida.dao.OrderDao;
import com.bodega.rapida.dao.ProductDao;
import com.bodega.rapida.dao.UserDao;
import com.bodega.rapida.entity.OrderDetail;
import com.bodega.rapida.entity.Order;
import com.bodega.rapida.entity.Product;
import com.bodega.rapida.entity.User;
import com.bodega.rapida.http.ResponseAjax;
import com.bodega.rapida.service.OrderService;
import com.bodega.rapida.service.ProductService;
import com.bodega.rapida.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
public class RapidaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RapidaApplication.class, args);
	}
	
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*
		List<Product> products = productService.listProductsWithLowQuantity(5);
		
		for (Product product : products) {
			
			System.out.println(product);
		}
		
		*/
		
		
		List<Order> orders = orderService.findByStateOrderByDateEmisionAsc("Pendiente");
		
		for (Order order : orders) {
			System.out.println(order);
		}
	
		
		
		/*
		
		ResponseAjax<User> rs = devolver();
		
		System.out.println("user: " + rs.getObject().getName());
				
		*/
	}
	
	public static ResponseAjax<User> devolver(){
		
		Gson gson = new Gson();
		
		String json = "{message: 'Se registro', requestSuccess: true, object: { id: 1, name : 'Raphael'} }";
		
		JsonElement jsonElement = JsonParser.parseString(json);
		
		System.out.println("jsonElement: " + jsonElement);
	
		ResponseAjax<User> rs = gson.fromJson(jsonElement, new TypeToken<ResponseAjax<User>>(){}.getType() );
		
		System.out.println("object: "+rs.getObject());
		
		if( rs.getObject() instanceof User ) {
			System.out.println("Es un usuario");
		} else {
			System.out.println("No es un usuario");
		}
		
		return rs;
	}
	
}
