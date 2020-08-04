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
	
	@Query("SELECT new com.bodega.rapida.entity.OrderDetail(od.id, p.name, p.category, p.imageLink, od.cant, od.cost) "
			+ " FROM OrderDetail od inner join Product p on p.id = od.product.id WHERE od.order.id = ?1")
	List<OrderDetail> getOrderDetails( int idOrder ) throws Exception;
		
	@Query("SELECT new com.bodega.rapida.entity.Order( o.id, o.paymentType, o.dateEmision, o.nameBanco, o.codeVoucher, o.state, o.total, o.subtotal, o.igv, u.name, u.id )"
			+ " FROM Order o inner join User u on u.id = o.user.id WHERE o.state = ?1 order by o.dateEmision desc")
	List<Order> findByStateOrderByDateEmisionAsc( String state ) throws Exception;

	@Query("SELECT new com.bodega.rapida.entity.Order( o.id, o.paymentType, o.dateEmision, o.nameBanco, o.codeVoucher, o.state, o.total, o.subtotal, o.igv)"
			+ " FROM Order o WHERE o.id = ?1")
	Order findById( int idOrder ) throws Exception;
	
}
