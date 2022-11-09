package com.fonyou.examen.web.app.util.dto;

import java.io.Serializable;

public class EstudianteExamenDto implements Serializable{
	
	private int idEstudiante;
	private int idExamen;
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

}
