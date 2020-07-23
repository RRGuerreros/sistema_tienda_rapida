package com.bodega.rapida.service;

import com.bodega.rapida.entity.Pedido;

public interface OrderService {

	Pedido saveAndReturnOrder( Pedido order ) throws Exception;
}
