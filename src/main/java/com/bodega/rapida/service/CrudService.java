package com.bodega.rapida.service;

import java.util.List;

public interface CrudService<T> {
	
	void save( T objeto ) throws Exception;
	
	void update( T objeto );
	
	void delete( int id );
	
	T consult( int id );
	
	List<T> list();
	
	

}
