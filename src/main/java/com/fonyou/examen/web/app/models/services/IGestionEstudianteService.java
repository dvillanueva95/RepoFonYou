package com.fonyou.examen.web.app.models.services;

import com.fonyou.examen.web.app.models.entity.Estudiante;
import com.fonyou.examen.web.app.util.RespuestaServicio;

public interface IGestionEstudianteService {
	
	// Crear estudiante
	public RespuestaServicio crearEstudiante(Estudiante estudiante);

}
