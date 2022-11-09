package com.fonyou.examen.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="presentacionExamen")
public class PresentacionExamen implements Serializable{
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idExamen", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Examen idExamen;
	
	@JoinColumn(name = "idEstudiante", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Estudiante idEstudiante;
	
	@Column(name="fechaPresentacion")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaPresentacion;
	
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
	public Examen getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Examen idExamen) {
		this.idExamen = idExamen;
	}
	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public Date getFechaPresentacion() {
		return fechaPresentacion;
	}
	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
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
