package com.bodega.rapida.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "order_detail" )
public class OrderDetail {

	@Id
	@Column(name = "id", nullable = false )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name =  "order_id", nullable = false )
	@JsonIgnore
	private Order order;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "product_id", nullable = false )
	private Product product;
	
	@Column( name = "cant" )
	private int cant;
	@Column( name = "cost" )
	private double cost;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(int id, String name, String category, String imageLink, int cant, double cost) {
		this.id = id;
		this.product = new Product(name, category, imageLink);
		this.cant = cant;
		this.cost = cost;
	}

	public OrderDetail(Order order, Product product, int cant, double cost) {
		this.order = order;
		this.product = product;
		this.cant = cant;
		this.cost = cost;
	}

	public OrderDetail(int id, Order order, Product product, int cant, double cost) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.cant = cant;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", product=" + product + ", cant=" + cant + ", cost="
				+ cost + "]";
	}
	
}
