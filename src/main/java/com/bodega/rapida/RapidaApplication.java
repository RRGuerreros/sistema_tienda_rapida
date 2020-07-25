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
import com.bodega.rapida.service.OrderService;
import com.bodega.rapida.service.ProductService;
import com.bodega.rapida.service.UserService;

@SpringBootApplication
public class RapidaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RapidaApplication.class, args);
	}
	
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*
		List<Product> products = productService.listProductsWithLowQuantity(5);
		
		for (Product product : products) {
			
			System.out.println(product);
		}
		
		
		*//*
		
		List<Order> orders = orderService.findByStateOrderByDateEmisionAsc("Pendiente");
		
		for (Order order : orders) {
			System.out.println(order);
		}
		*/
	}
	
}
