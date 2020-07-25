package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.ProductDao;
import com.bodega.rapida.entity.Product;
import com.bodega.rapida.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> listProductsWithLowQuantity(int numberMin) throws Exception {
		return dao.listProductsWithLowQuantity(numberMin);
	}

	@Override
	public List<Product> findByCategory(String category) throws Exception {
		return dao.findByCategory(category);
	}

	@Override
	public Product findById(int id) throws Exception {
		return dao.findById(id).orElse(new Product());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
