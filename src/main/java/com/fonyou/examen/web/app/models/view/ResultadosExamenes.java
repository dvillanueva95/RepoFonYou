package com.fonyou.examen.web.app.models.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resultadosExamenes")
public class ResultadosExamenes implements Serializable{
	
	@Id
	private String id; 
	
	@Column(name="idExamen")
	private int idExamen;
	
	@Column(name="idEstudiante")
	private int idEstudiante;
	
	@Column(name="idPregunta")
	private int idPregunta;
	
	@Column(name="pregunta")
	private String pregunta;
	
	@Column(name="idRespuesta")
	private int idRespuesta;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="puntaje")
	private int puntaje;
	
	@Column(name="nombreExamen")
	private String nombreExamen;
	
	@Column(name="nombreEstudiante")
	private String nombreEstudiante;
	
	@Column(name="nombreCiudad")
	private String nombreCiudad;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public String getNombreExamen() {
		return nombreExamen;
	}
	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}



	// Default serial ID
	private static final long serialVersionUID = 1L;

}
