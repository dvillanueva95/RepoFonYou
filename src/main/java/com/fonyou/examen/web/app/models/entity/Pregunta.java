package com.fonyou.examen.web.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pregunta")
public class Pregunta implements Serializable{
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "idExamen", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Examen idExamen;
	
	@Column(name="pregunta")
	private String pregunta;
	
	@OneToMany(mappedBy = "idPregunta")
	private List<Respuestas> respuestas;
	
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
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
		
	public List<Respuestas> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Respuestas> respuestas) {
		this.respuestas = respuestas;
	}
		// Default serial ID
		private static final long serialVersionUID = 1L;
}
