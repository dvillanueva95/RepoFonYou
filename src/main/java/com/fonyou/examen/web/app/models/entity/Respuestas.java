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
@Table(name="respuestas")
public class Respuestas implements Serializable{
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idPregunta", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Pregunta idPregunta;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="puntaje")
	private int puntaje;
	
	@Column(name="esCorrecta")
	private boolean esCorrecta;
	
	// Métodosde acceso
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pregunta getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
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
	public boolean isEsCorrecta() {
		return esCorrecta;
	}
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}
	
	// Default serial ID
		private static final long serialVersionUID = 1L;
}
