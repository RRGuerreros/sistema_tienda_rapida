package com.bodega.rapida.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer>{

	@Query( value="SELECT p FROM Producto p WHERE p.stock <= :numberMin")
	List<Producto> listProductsWithLowQuantity( @Param("numberMin") int numberMin ) throws Exception;
	
	List<Producto> findByCategoria( String categoria );
	
	
	
}
