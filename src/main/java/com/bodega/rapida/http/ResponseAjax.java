package com.bodega.rapida.http;

public class ResponseAjax<T> {
	
	private String message;
	private boolean requestSuccess;

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
