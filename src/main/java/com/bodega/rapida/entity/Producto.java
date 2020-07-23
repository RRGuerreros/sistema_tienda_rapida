package com.bodega.rapida.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private int id;
	@Column(name = "nombre", length = 100)
	private String nombre;
	@Column(name = "categoria", length = 100)
	private String categoria;
	@Column(name = "costoUnitario")
	private double costoUnitario;
	@Column(name = "stock")
	private int stock;
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	@Column(name = "enlaceImagen", length = 200)
	private String enlaceImagen;

	@OneToMany(mappedBy = "producto" )
	private List<DetallePedido> detalles = new ArrayList<>();

	public Producto(String nombre, String categoria, double costoUnitario, int stock, String descripcion,
			String enlaceImagen) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.costoUnitario = costoUnitario;
		this.stock = stock;
		this.descripcion = descripcion;
		this.enlaceImagen = enlaceImagen;
	}
	public Producto(int id, String nombre, String categoria, double costoUnitario, int stock, String descripcion,
			String enlaceImagen) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.costoUnitario = costoUnitario;
		this.stock = stock;
		this.descripcion = descripcion;
		this.enlaceImagen = enlaceImagen;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlaceImagen() {
		return enlaceImagen;
	}

	public void setEnlaceImagen(String enlaceImagen) {
		this.enlaceImagen = enlaceImagen;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", costoUnitario="
				+ costoUnitario + ", stock=" + stock + ", descripcion=" + descripcion + ", enlaceImagen=" + enlaceImagen
				+ "]";
	}

}
