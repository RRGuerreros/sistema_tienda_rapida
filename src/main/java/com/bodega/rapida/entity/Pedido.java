package com.bodega.rapida.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "pedido_id")
	private int id;
	@Column( name = "tipoPago", length = 50 )
	private String tipoPago;
	@Column( name = "fechaEmision" )
	private String fechaEmision;
	@Column( name = "nombreBanco", length = 50 )
	private String nombreBanco;
	@Column( name = "codigoVoucher", length = 50 )
	private String codigoVoucher;
	@Column( name = "estado", length = 50 )
	private String estado;
	@Column( name = "total" )
	private double total;
	@Column( name = "subtotal" )
	private double subtotal;
	@Column( name = "igv" )
	private double igv;
	
	@Transient
	private String numberGenerated;
	
	@ManyToOne
	@JoinColumn( name = "usuario_id", nullable = false, updatable = false)
	private Usuario usuario;
	
	@OneToMany( mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<DetallePedido> detalles = new ArrayList<>();
	
	public Pedido(String tipoPago, String fechaEmision, String nombreBanco, String codigoVoucher,
			String estado, double total, double subtotal, double igv) {
	
		this.tipoPago = tipoPago;
		this.fechaEmision = fechaEmision;
		this.nombreBanco = nombreBanco;
		this.codigoVoucher = codigoVoucher;
		this.estado = estado;
		this.total = total;
		this.subtotal = subtotal;
		this.igv = igv;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNumberGenerated() {
		return numberGenerated;
	}
	public void setNumberGenerated(String numberGenerated) {
		this.numberGenerated = numberGenerated;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getCodigoVoucher() {
		return codigoVoucher;
	}

	public void setCodigoVoucher(String codigoVoucher) {
		this.codigoVoucher = codigoVoucher;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}
	
	public void addDetallePedido( DetallePedido detallePedido ) {
		this.detalles.add(detallePedido);		
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tipoPago=" + tipoPago + ", fechaEmision=" + fechaEmision + ", nombreBanco="
				+ nombreBanco + ", codigoVoucher=" + codigoVoucher + ", estado=" + estado + ", total=" + total
				+ ", subtotal=" + subtotal + ", igv=" + igv + ", numberGenerated=" + numberGenerated + "]";
	}
	
}
