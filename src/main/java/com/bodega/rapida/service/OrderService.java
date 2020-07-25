package com.bodega.rapida.service;

import java.util.List;

import com.bodega.rapida.entity.Order;
import com.bodega.rapida.entity.OrderDetail;

public interface OrderService {

	Order saveAndReturnOrder( Order order ) throws Exception;
	
	List<Order> findByStateOrderByDateEmisionAsc( String state ) throws Exception;
	
	Order findById( int idOrder ) throws Exception;
	
}
