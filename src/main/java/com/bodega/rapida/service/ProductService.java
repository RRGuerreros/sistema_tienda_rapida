package com.bodega.rapida.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bodega.rapida.entity.Producto;

public interface ProductService {

	List<Producto> listProductsWithLowQuantity( int numberMin ) throws Exception;
	
	List<Producto> findByCategoria( String categoria ) throws Exception;
	
	Producto findById( int id ) throws Exception;
}
