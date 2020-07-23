package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.UsuarioDao;
import com.bodega.rapida.entity.Usuario;
import com.bodega.rapida.service.CrudService;
import com.bodega.rapida.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements CrudService<Usuario>, UsuarioService{

	@Autowired
	private UsuarioDao dao;
	
	@Override
	public void save(Usuario objeto) throws Exception {
		dao.save(objeto);
	}

	@Override
	public void update(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByCelular(String celular) {
		return dao.findByCelular(celular);
	}

	
}
