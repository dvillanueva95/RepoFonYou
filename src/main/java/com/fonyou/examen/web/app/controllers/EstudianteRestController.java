package com.fonyou.examen.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.examen.web.app.models.entity.Estudiante;
import com.fonyou.examen.web.app.models.services.IGestionEstudianteService;
import com.fonyou.examen.web.app.util.RespuestaServicio;

@RestController
@RequestMapping("/api/estudianteRest")
public class EstudianteRestController {
	
	@Autowired
	private IGestionEstudianteService estudianteService;
	
	// Método para crear estudiante
	@PostMapping("/crearEstudiante")
	public RespuestaServicio crearEstudiante(@RequestBody Estudiante estudiante) {
		RespuestaServicio respuesta = estudianteService.crearEstudiante(estudiante);
		return respuesta;
	}
	

}          
