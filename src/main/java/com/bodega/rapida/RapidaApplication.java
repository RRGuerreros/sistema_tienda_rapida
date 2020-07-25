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

@SpringBootApplication
public class RapidaApplication{

	public static void main(String[] args) {
		SpringApplication.run(RapidaApplication.class, args);
	}
}
