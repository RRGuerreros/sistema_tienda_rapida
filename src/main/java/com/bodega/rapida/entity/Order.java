package com.bodega.rapida.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "`order`")
public class Order {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "order_id")
	private int id;
	@Column( name = "paymentType", length = 50 )
	private String paymentType;
	@Column( name = "dateEmision" )
	private String dateEmision;
	@Column( name = "nameBanco", length = 50 )
	private String nameBanco;
	@Column( name = "codeVoucher", length = 50 )
	private String codeVoucher;
	@Column( name = "state", length = 50 )
	private String state;
	@Column( name = "total" )
	private double total;
	@Column( name = "subtotal" )
	private double subtotal;
	@Column( name = "igv" )
	private double igv;
	
	@Transient
	private String numberGenerated;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn( name = "user_id", nullable = false, updatable = false)
	private User user;
	
	@OneToMany( mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<OrderDetail> details = new ArrayList<>();
		
	public Order(String paymentType, String dateEmision, String nameBanco, String codeVoucher, String state,
			double total, double subtotal, double igv, String numberGenerated) {
		this.paymentType = paymentType;
		this.dateEmision = dateEmision;
		this.nameBanco = nameBanco;
		this.codeVoucher = codeVoucher;
		this.state = state;
		this.total = total;
		this.subtotal = subtotal;
		this.igv = igv;
		this.numberGenerated = numberGenerated;
	}

	public Order(int id, String paymentType, String dateEmision, String nameBanco, String codeVoucher, String state,
			double total, double subtotal, double igv) {
		this.id = id;
		this.paymentType = paymentType;
		this.dateEmision = dateEmision;
		this.nameBanco = nameBanco;
		this.codeVoucher = codeVoucher;
		this.state = state;
		this.total = total;
		this.subtotal = subtotal;
		this.igv = igv;
	}

	public Order(int id, String paymentType, String dateEmision, String nameBanco, String codeVoucher, String state,
			double total, double subtotal, double igv, String numberGenerated) {
		this.id = id;
		this.paymentType = paymentType;
		this.dateEmision = dateEmision;
		this.nameBanco = nameBanco;
		this.codeVoucher = codeVoucher;
		this.state = state;
		this.total = total;
		this.subtotal = subtotal;
		this.igv = igv;
		this.numberGenerated = numberGenerated;
	}
	
	public Order(String paymentType, String dateEmision, String nameBanco, String codeVoucher, String state,
			double total, double subtotal, double igv) {
		super();
		this.paymentType = paymentType;
		this.dateEmision = dateEmision;
		this.nameBanco = nameBanco;
		this.codeVoucher = codeVoucher;
		this.state = state;
		this.total = total;
		this.subtotal = subtotal;
		this.igv = igv;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNumberGenerated() {
		return numberGenerated;
	}
	public void setNumberGenerated(String numberGenerated) {
		this.numberGenerated = numberGenerated;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDateEmision() {
		return dateEmision;
	}

	public void setDateEmision(String dateEmision) {
		this.dateEmision = dateEmision;
	}

	public String getNameBanco() {
		return nameBanco;
	}

	public void setNameBanco(String nameBanco) {
		this.nameBanco = nameBanco;
	}

	public String getCodeVoucher() {
		return codeVoucher;
	}

	public void setCodeVoucher(String codeVoucher) {
		this.codeVoucher = codeVoucher;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
		for (OrderDetail orderDetail : details) {
			orderDetail.setOrder(this);
		}
	}

	public void addOrderDetailt( OrderDetail orderDetail ) {
		this.details.add(orderDetail);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", paymentType=" + paymentType + ", dateEmision=" + dateEmision + ", nameBanco="
				+ nameBanco + ", codeVoucher=" + codeVoucher + ", state=" + state + ", total=" + total + ", subtotal="
				+ subtotal + ", igv=" + igv + ", numberGenerated=" + numberGenerated + "]";
	}

}
