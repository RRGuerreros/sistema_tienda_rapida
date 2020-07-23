package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.ProductoDao;
import com.bodega.rapida.entity.Producto;
import com.bodega.rapida.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductoDao dao;
	
	@Override
	public List<Producto> listProductsWithLowQuantity(int numberMin) throws Exception {
		return dao.listProductsWithLowQuantity(numberMin);
	}

	@Override
	public List<Producto> findByCategoria(String categoria) throws Exception {
		return dao.findByCategoria(categoria);
	}

	@Override
	public Producto findById(int id) throws Exception {
		return dao.findById(id).orElse(new Producto());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
