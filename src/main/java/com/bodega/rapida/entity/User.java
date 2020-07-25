package com.bodega.rapida.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name= "userResultV1", classes = {
	    @ConstructorResult(targetClass = User.class,
	        columns = {
	            @ColumnResult(name="user_id",type = Integer.class),
	            @ColumnResult(name="name",type = String.class),
	            @ColumnResult(name="lastname",type = String.class),
	            @ColumnResult(name="phone",type = String.class),
	            @ColumnResult(name="address",type = String.class),
	            @ColumnResult(name="typeUser", type = String.class)
	        }
	    ),
	    
	})
	@NamedNativeQuery( 
		name = "existUser", 
		query = "SELECT u.user_id, u.name, u.lastname, u.phone, u.address, u.typeUser FROM User u where u.phone = ?1 and BINARY u.password = ?2",
		resultClass = User.class, 
		resultSetMapping = "userResultV1")
@Entity
@Table( name = "`user`" )
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "lastname", length = 100)
	private String lastname;
	@Column(name = "phone", length = 9)
	private String phone;
	@Column(name = "password", length = 50)
	private String password;
	@Column(name = "address", length = 200)
	private String address;
	@Column(name = "typeUser")
	private String typeUser;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String lastname, String phone, String password, String address, String typeUser) {
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.typeUser = typeUser;
	}
	public User(Integer id, String name, String lastname, String phone, String address, String typeUser) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.typeUser = typeUser;
	}

	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
		for (Order order : orders) {
			order.setUser(this);
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", address="
				+ address + ", typeUser=" + typeUser + "]";
	}
}
