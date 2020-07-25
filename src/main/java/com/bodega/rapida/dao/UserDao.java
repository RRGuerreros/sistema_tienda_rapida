package com.bodega.rapida.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.rapida.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{

	@Query( nativeQuery = true, name = "existUser" )	
	User userExists( String phone, String password );
	
	User findByPhone( String phone );
	

}
