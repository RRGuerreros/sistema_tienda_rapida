package com.bodega.rapida.entity;

public class Respuesta {
	
	private String mensaje;
	private boolean correcto;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isCorrecto() {
		return correcto;
	}
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	public void setParametrosRespuesta( String mensaje, boolean correcto ) {
		this.mensaje=mensaje;
		this.correcto=correcto;
	}
	@Override
	public String toString() {
		return "Helper [mensaje=" + mensaje + ", correcto=" + correcto + "]";
	}

}
