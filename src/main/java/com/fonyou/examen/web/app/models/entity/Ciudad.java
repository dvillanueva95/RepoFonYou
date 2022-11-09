package com.fonyou.examen.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad implements Serializable {
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idPais", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Pais idPais;
	
	@Column(name="nombre")
	private String nombre;
	
	// Métodosde acceso
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pais getIdPais() {
		return idPais;
	}
	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Default serial ID
	private static final long serialVersionUID = 1L;
}
