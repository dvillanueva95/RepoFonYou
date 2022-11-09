package com.fonyou.examen.web.app.models.services;

import java.util.List;

import com.fonyou.examen.web.app.models.entity.Estudiante;
import com.fonyou.examen.web.app.models.entity.Examen;
import com.fonyou.examen.web.app.models.entity.PresentacionExamen;
import com.fonyou.examen.web.app.util.RespuestaServicio;
import com.fonyou.examen.web.app.util.dto.EstudianteExamenDto;

public interface IGestionExamenService {

	// Crear exámen
	public RespuestaServicio crearExamen(Examen examen);
	
	// Crear asignación exámen
	public RespuestaServicio crearAsignacionExamen(PresentacionExamen presentacionExamen);
	
	// Consultar fecha presentación por estudiante y exámen
	public RespuestaServicio consultarFechaPresentacionExamen(EstudianteExamenDto estudianteExamenDto);
	

}
