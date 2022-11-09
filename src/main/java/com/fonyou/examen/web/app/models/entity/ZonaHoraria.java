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
@Table(name="zonaHoraria")
public class ZonaHoraria implements Serializable{
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idCiudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Ciudad idCiudad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="horaDiferencia")
	private int horaDiferencia;
	
	// Métodosde acceso
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ciudad getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Ciudad idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getHoraDiferencia() {
		return horaDiferencia;
	}
	public void setHoraDiferencia(int horaDiferencia) {
		this.horaDiferencia = horaDiferencia;
	}
	
	// Default serial ID
	private static final long serialVersionUID = 1L;

}
