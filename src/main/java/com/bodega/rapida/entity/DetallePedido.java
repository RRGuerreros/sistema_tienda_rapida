package com.bodega.rapida.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "detalle_pedido" )
public class DetallePedido {

	@Id
	@Column(name = "id", nullable = false )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn( name =  "pedido_id", nullable = false )
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn( name = "producto_id", nullable = false )
	private Producto producto;
	
	@Column( name = "cantidad" )
	private int cantidad;
	@Column( name = "costo" )
	private double costo;
	
	public DetallePedido() {
		// TODO Auto-generated constructor stub
	}
	
	public DetallePedido(Pedido pedido, Producto producto, int cantidad, double costo) {
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.costo = costo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", costo=" + costo + "]";
	}
}
