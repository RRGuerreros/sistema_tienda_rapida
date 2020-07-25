package com.bodega.rapida.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Order;
import com.bodega.rapida.entity.OrderDetail;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer>{
	
	@Query("SELECT NEW OrderDetail(od.id, p.name, p.category, p.imageLink, od.cant, od.cost) "
			+ " FROM OrderDetail od inner join Product p on p.id = od.product.id WHERE od.order.id = ?1")
	List<OrderDetail> getOrderDetails( int idOrder ) throws Exception;
		
	List<Order> findByStateOrderByDateEmisionAsc( String state );

	
	
	
}
