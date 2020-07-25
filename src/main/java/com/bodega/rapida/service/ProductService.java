package com.bodega.rapida.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bodega.rapida.entity.Product;

public interface ProductService {

	List<Product> listProductsWithLowQuantity( int numberMin ) throws Exception;
	
	List<Product> findByCategory( String category ) throws Exception;
	
	Product findById( int id ) throws Exception;
}
