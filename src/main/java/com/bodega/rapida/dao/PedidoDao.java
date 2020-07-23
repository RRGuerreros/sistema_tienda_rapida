package com.bodega.rapida.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Pedido;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Integer>{

	
}
