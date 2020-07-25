package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.OrderDao;
import com.bodega.rapida.entity.Order;
import com.bodega.rapida.entity.OrderDetail;
import com.bodega.rapida.service.CrudService;
import com.bodega.rapida.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService, CrudService<Order> {

	@Autowired
	private OrderDao dao;
	
	@Override
	public Order saveAndReturnOrder(Order order) throws Exception {
		
		dao.save(order);
		
		int number_generate = order.getId();
		
		Integer num = new Integer(number_generate);
		
		String number_default = "0000000000";
		
		if( number_default.length() > num.toString().length() ) {
			
			number_default = number_default.concat(num.toString());
						
			order.setNumberGenerated( "NRO-OR-" + number_default.substring(num.toString().length()) );
		} 
		
		return order;
	}

	@Override
	public void save(Order objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Order objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order consult(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByStateOrderByDateEmisionAsc(String State) throws Exception {
		return dao.findByStateOrderByDateEmisionAsc(State);
	}

	@Override
	public Order findById(int idOrder) throws Exception {
		
		Order order = dao.findById(idOrder).orElse(null);
		
		if( order != null ) {
			order.setDetails( dao.getOrderDetails(idOrder) );
		}
		
		return order;
	}

	
	
	

	
	
	
	
}
