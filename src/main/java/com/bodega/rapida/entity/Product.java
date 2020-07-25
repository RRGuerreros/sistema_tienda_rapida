package com.bodega.rapida.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "category", length = 100)
	private String category;
	@Column(name = "unitCost")
	private double unitCost;
	@Column(name = "stock")
	private int stock;
	@Column(name = "description", length = 500)
	private String description;
	@Column(name = "imageLink", length = 200)
	private String imageLink;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY )
	private List<OrderDetail> details = new ArrayList<>();

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String category, double unitCost, int stock, String description, String imageLink) {
		this.name = name;
		this.category = category;
		this.unitCost = unitCost;
		this.stock = stock;
		this.description = description;
		this.imageLink = imageLink;
	}
	public Product(int id, String name, String category, double unitCost, int stock, String description,String imageLink) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.unitCost = unitCost;
		this.stock = stock;
		this.description = description;
		this.imageLink = imageLink;
	}

	public Product(String name, String category, String imageLink) {
		this.name = name;
		this.category = category;
		this.imageLink = imageLink;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", unitCost=" + unitCost + ", stock="
				+ stock + ", description=" + description + ", imageLink=" + imageLink + "]";
	}
}
