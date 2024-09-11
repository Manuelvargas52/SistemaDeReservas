package com.example.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
@Entity
@Table (name = "Cliente")
public class Cliente {
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String nombre;
	    private String email;
	    private String telefono;
	    private String direccion;

	
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String email, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
    
    
 
}
