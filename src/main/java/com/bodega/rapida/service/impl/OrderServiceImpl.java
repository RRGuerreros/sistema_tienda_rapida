package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.PedidoDao;
import com.bodega.rapida.entity.Pedido;
import com.bodega.rapida.service.CrudService;
import com.bodega.rapida.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService, CrudService<Pedido> {

	@Autowired
	private PedidoDao dao;
	
	@Override
	public Pedido saveAndReturnOrder(Pedido order) throws Exception {
		return dao.save(order);
	}

	@Override
	public void save(Pedido objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pedido objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
}
