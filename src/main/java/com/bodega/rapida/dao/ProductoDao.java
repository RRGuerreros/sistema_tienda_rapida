package com.bodega.rapida.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer>{

	
}
