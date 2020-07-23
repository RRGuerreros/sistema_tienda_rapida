package com.bodega.rapida.service;

import com.bodega.rapida.entity.Usuario;

public interface UsuarioService {

	Usuario findByCelular( String celular );
	
	Usuario existUser( String celular, String clave ) throws Exception;
	
	
}
