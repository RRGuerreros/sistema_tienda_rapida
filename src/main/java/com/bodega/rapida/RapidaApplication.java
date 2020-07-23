package com.bodega.rapida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bodega.rapida.dao.PedidoDao;
import com.bodega.rapida.dao.ProductoDao;
import com.bodega.rapida.dao.UsuarioDao;
import com.bodega.rapida.entity.DetallePedido;
import com.bodega.rapida.entity.Pedido;
import com.bodega.rapida.entity.Producto;
import com.bodega.rapida.entity.Usuario;
import com.bodega.rapida.service.ProductService;

@SpringBootApplication
public class RapidaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RapidaApplication.class, args);
	}
	
	@Autowired
	private PedidoDao dao;
	@Autowired
	private UsuarioDao daoUsu;
	@Autowired
	private ProductoDao daoProd;
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService serviceProd;
	
	@Override
	public void run(String... args) throws Exception {
	
		// TODO Auto-generated method stub
		/*
		Producto prod1= new Producto(3,"prod6", "", 200.00, 10, "", "");
		Producto prod2= new Producto(4,"prod7", "", 300.00, 5, "", "");
		
		Pedido pedido = new Pedido("CREDIO", "2020-01-01", "BCP", "VOU-235565", "PENDIENTE", 200, 200, 200);
		
		DetallePedido det1 = new DetallePedido(pedido, prod1, 2, 100);
		DetallePedido det2 = new DetallePedido(pedido, prod2, 5, 50);

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		pedido.addDetallePedido(det1);
		pedido.addDetallePedido(det2);
		pedido.setUsuario(usuario);
		
		dao.save(pedido);
		
		System.out.println(pedido);
		
		/*
		
		Usuario usuario = new Usuario("Stefany", "Ponce", "989898989", "123", "");
		
		
		
			
				
		
		System.out.println(usu);*/
		
		int n = 100000;
		
		Integer num = new Integer(n);
		
		String numero = "00000"+n;
		
		if( numero.length() < num.toString().length() ) {
			System.out.println("Ya no se puede generar mas números de pedidos");
		} else {
			
			numero.concat(num.toString());
			
			System.out.println("numero concatenado: " + numero );
			
			System.out.println("Numero: "+ numero.substring(num.toString().length()-1) );
		}
		
		
		
		
		
		         
		
	}

	
	
	
	
	
}
