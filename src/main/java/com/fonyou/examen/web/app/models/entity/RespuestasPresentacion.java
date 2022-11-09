package com.fonyou.examen.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="respuestasPresentacion")
public class RespuestasPresentacion implements Serializable{
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idPresentacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private PresentacionExamen idPresentacion;
	
	@JoinColumn(name = "idPregunta", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Pregunta idPregunta;
	
	@JoinColumn(name = "idRespuesta", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Respuestas idRespuesta;
	
	// Métodosde acceso
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PresentacionExamen getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(PresentacionExamen idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	public Pregunta getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}
	public Respuestas getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(Respuestas idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	// Default serial ID
		private static final long serialVersionUID = 1L;	
}
