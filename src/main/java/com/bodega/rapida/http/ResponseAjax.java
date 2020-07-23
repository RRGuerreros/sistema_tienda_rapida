package com.bodega.rapida.http;

import java.util.List;

public class ResponseAjax<T> {
	
	private String message;
	private boolean requestSuccess;
	private T object;
	private List<T> list;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
	public ResponseAjax() {
		// TODO Auto-generated constructor stub
	}

	public void setParametersResponse( String message, boolean requestSuccess ) {
		
		this.message = message;
		this.requestSuccess = requestSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRequestSuccess() {
		return requestSuccess;
	}

	public void setRequestSuccess(boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
	}

	@Override
	public String toString() {
		return "ResponseAjax [message=" + message + ", requestSuccess=" + requestSuccess + "]";
	}
	
}
