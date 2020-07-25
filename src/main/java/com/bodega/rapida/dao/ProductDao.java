package com.bodega.rapida.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

	@Query( value="SELECT p FROM Product p WHERE p.stock <= :numberMin")
	List<Product> listProductsWithLowQuantity( @Param("numberMin") int numberMin ) throws Exception;
	
	List<Product> findByCategory( String category );
	
	
	
}
