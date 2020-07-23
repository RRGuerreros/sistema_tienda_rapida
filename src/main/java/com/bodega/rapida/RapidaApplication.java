package com.bodega.rapida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bodega.rapida.dao.PedidoDao;
import com.bodega.rapida.dao.UsuarioDao;
import com.bodega.rapida.entity.Usuario;

@SpringBootApplication
public class RapidaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RapidaApplication.class, args);
	}
	
	@Autowired
	private PedidoDao dao;
	@Autowired
	private UsuarioDao daoUsu;
	
	@Override
	public void run(String... args) throws Exception {
	
		// TODO Auto-generated method stub
		/*
		Producto prod1= new Producto(3,"prod6", "", 200.00, 10, "", "");
		Producto prod2= new Producto(4,"prod7", "", 300.00, 5, "", "");
		
		Pedido pedido = new Pedido(2, "transferencia", "2020-01-01", "BBVA", "6566", "Activo", 200, 200, 200);
		
		DetallePedido det1 = new DetallePedido(pedido, prod1, 2, 100);
		DetallePedido det2 = new DetallePedido(pedido, prod2, 5, 50);
				
		pedido.addDetallePedido(det1);
		pedido.addDetallePedido(det2);
		pedido.setUsuario(usuario);
		
		dao.save(pedido);
		
		
		Usuario usuario = new Usuario("Stefany", "Ponce", "989898989", "123", "");
		
		
		
			
				
		
		System.out.println(usu);*/
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
}
