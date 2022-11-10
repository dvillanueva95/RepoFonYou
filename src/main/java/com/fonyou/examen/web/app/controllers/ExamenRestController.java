package com.fonyou.examen.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.examen.web.app.models.entity.Estudiante;
import com.fonyou.examen.web.app.models.entity.Examen;
import com.fonyou.examen.web.app.models.entity.PresentacionExamen;
import com.fonyou.examen.web.app.models.entity.RespuestasPresentacion;
import com.fonyou.examen.web.app.models.services.IGestionExamenService;
import com.fonyou.examen.web.app.util.RespuestaServicio;
import com.fonyou.examen.web.app.util.dto.EstudianteExamenDto;

@RestController
@RequestMapping("/api/examenRest")
public class ExamenRestController {

	@Autowired
	private IGestionExamenService examenService;
	
	// Método para crear examen
	@PostMapping("/crearExamen")
	public RespuestaServicio crearExamen(@RequestBody Examen examen) {
		RespuestaServicio respuesta = examenService.crearExamen(examen);
		return respuesta;
	}
	
	// Método para crear asignación examen por estudiante
	@PostMapping("/crearAsignacionExamen")
	public RespuestaServicio crearAsignacionExamen(@RequestBody PresentacionExamen presentacionExamen) {
		RespuestaServicio respuesta = examenService.crearAsignacionExamen(presentacionExamen);
		return respuesta;
	}
	
	// Método para crear asignación examen por estudiante
	@GetMapping("/obtenerFechaPresentacionExamen")
	public RespuestaServicio obtenerFechaPresentacionExamen(@RequestBody EstudianteExamenDto estudianteExamenDto) {
		RespuestaServicio respuesta = examenService.consultarFechaPresentacionExamen(estudianteExamenDto);
		return respuesta;
	}
	
	// Método para guardar respuestas
	@PostMapping("/guardarRespuestasPresentacion")
	public RespuestaServicio guardarRespuestasPresentacion(@RequestBody RespuestasPresentacion respuestasPresentacion) {
		RespuestaServicio respuesta = examenService.guardarRespuestasPresentacion(respuestasPresentacion);
		return respuesta;
		
	}
	
	// Método para crear asignación examen por estudiante
		@GetMapping("/obtenerCalificacionEstudiante")
		public RespuestaServicio obtenerCalificacionEstudiante(@RequestBody EstudianteExamenDto estudianteExamenDto) {
			RespuestaServicio respuesta = examenService.obtenerCalificacionPorEstudiante(estudianteExamenDto);
			return respuesta;
		}
	
}
