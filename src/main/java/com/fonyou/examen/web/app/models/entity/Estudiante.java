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
@Table(name="estudiante")
public class Estudiante implements Serializable{
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@JoinColumn(name = "idCiudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Ciudad idCiudad;
	
	@JoinColumn(name = "idZonaHoraria", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private ZonaHoraria idZonaHoraria;
	
	// Métodosde acceso
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Ciudad getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Ciudad idCiudad) {
		this.idCiudad = idCiudad;
	}
	public ZonaHoraria getIdZonaHoraria() {
		return idZonaHoraria;
	}
	public void setIdZonaHoraria(ZonaHoraria idZonaHoraria) {
		this.idZonaHoraria = idZonaHoraria;
	}
	
	// Default serial ID
		private static final long serialVersionUID = 1L;	
}
