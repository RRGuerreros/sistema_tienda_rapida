package com.bodega.rapida.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.rapida.dao.UserDao;
import com.bodega.rapida.entity.User;
import com.bodega.rapida.service.CrudService;
import com.bodega.rapida.service.UserService;

@Service
public class UserServiceImpl implements CrudService<User>, UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public void save(User objeto) throws Exception {
		dao.save(objeto);
	}

	@Override
	public void update(User objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User consult(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByPhone(String phone) {
		return dao.findByPhone(phone);
	}

	@Override
	public User userExists(String phone, String password) throws Exception {
		return dao.userExists(phone, password);
	}

	
}
