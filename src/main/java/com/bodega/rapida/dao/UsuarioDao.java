package com.bodega.rapida.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer>{

	@Query( nativeQuery = true, name = "existeUsuario" )	
	Usuario existeUsuario( String celular, String clave );
	
	Usuario findByCelular( String celular );
	

}
