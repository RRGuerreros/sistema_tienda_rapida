package com.bodega.rapida.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name= "usuarioResultV1", classes = {
    @ConstructorResult(targetClass = Usuario.class,
        columns = {
            @ColumnResult(name="usuario_id",type = Integer.class),
            @ColumnResult(name="nombres",type = String.class),
            @ColumnResult(name="apellidos",type = String.class),
            @ColumnResult(name="celular",type = String.class),
            @ColumnResult(name="direccion",type = String.class)
        }
    )
})
@NamedNativeQuery( 
	name = "existeUsuario", 
	query = "SELECT u.usuario_id, u.nombres, u.apellidos, u.celular, u.direccion FROM Usuario u where u.celular = ?1 and BINARY u.clave = ?2",
	resultClass = Usuario.class, 
	resultSetMapping = "usuarioResultV1")
@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer id;
	@Column(name = "nombres", length = 100 )
	private String nombres;
	@Column(name = "apellidos", length = 100 )
	private String apellidos;
	@Column(name = "celular", length = 9 )
	private String celular;
	@Column(name = "clave", length = 50 )
	private String clave;
	@Column(name = "direccion", length = 200 )
	private String direccion;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombres, String apellidos, String celular, String clave, String direccion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.celular = celular;
		this.clave = clave;
		this.direccion = direccion;
	}


	public Usuario(Integer id, String nombres, String apellidos, String celular, String direccion) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.celular = celular;
		this.direccion = direccion;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
		for (Pedido pedido : pedidos) {
			pedido.setUsuario(this);
		}
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", celular=" + celular
				+ ", clave=" + clave + ", direccion=" + direccion + "]";
	}

}
