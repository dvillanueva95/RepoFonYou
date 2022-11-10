package com.fonyou.examen.web.app.models.services;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fonyou.examen.web.app.models.dao.IExamenDao;
import com.fonyou.examen.web.app.models.dao.IPreguntaDao;
import com.fonyou.examen.web.app.models.dao.IPresentacionExamenDao;
import com.fonyou.examen.web.app.models.dao.IRespuestasDao;
import com.fonyou.examen.web.app.models.dao.IRespuestasPresentacionDao;
import com.fonyou.examen.web.app.models.dao.IZonaHorariaDao;
import com.fonyou.examen.web.app.models.dao.IresultadosExamenesDao;
import com.fonyou.examen.web.app.models.entity.Examen;
import com.fonyou.examen.web.app.models.entity.Pregunta;
import com.fonyou.examen.web.app.models.entity.PresentacionExamen;
import com.fonyou.examen.web.app.models.entity.Respuestas;
import com.fonyou.examen.web.app.models.entity.RespuestasPresentacion;
import com.fonyou.examen.web.app.models.entity.ZonaHoraria;
import com.fonyou.examen.web.app.models.view.ResultadosExamenes;
import com.fonyou.examen.web.app.util.ConstantesFonYou;
import com.fonyou.examen.web.app.util.RespuestaServicio;
import com.fonyou.examen.web.app.util.dto.EstudianteExamenDto;

@Service
public class GestionExamenServiceImpl implements IGestionExamenService{

	@Autowired
	private IExamenDao examenDao;
	@Autowired
	private IPreguntaDao preguntaDao;
	@Autowired
	private IRespuestasDao respuestaDao;
	@Autowired
	private IPresentacionExamenDao presentacionExamenDao;
	@Autowired
	private IZonaHorariaDao zonaHorariaDao;
	@Autowired
	private IRespuestasPresentacionDao respuestasPresentacionDao;
	@Autowired
	private IresultadosExamenesDao resultadosExamenesDao;
	
	
	@Override
	public RespuestaServicio crearExamen(Examen examen) {
		
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		
		if (validaPuntajeTotalExamen(examen.getPreguntas())) {
			try {
				// Se persiste en base de datos un nuevo exámen
				Examen examenNuevo = examenDao.save(examen);
				// Recorre las preguntas que va a persistir en base de datos
				for (Pregunta itemPregunta : examen.getPreguntas()) {
					itemPregunta.setIdExamen(examenNuevo);				
					Pregunta preguntaNueva = preguntaDao.save(itemPregunta);
					// Recorre las respuestas por pregunta que va a persistir en base de datos
					for (Respuestas itemRespuesta : itemPregunta.getRespuestas()) {
						itemRespuesta.setIdPregunta(preguntaNueva);
						respuestaDao.save(itemRespuesta);
					}
				}
				// Se asigna código de éxito
				respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_EXITO_OPERACION);
				// Se asigna mensaje de éxito
				respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_EXITO_OPERACION);
				
				// Retorna el resultado de la operación
				return respuestaServicio;			
				
			} catch(Exception e){
				// Se asigna código de error
				respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
				// Se asigna mensaje de error
				respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_OPERACION);
				// Retorna el resultado de la operación
				return respuestaServicio;			
			}
			
		}else {
			// Se asigna código de error
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
			// Se asigna mensaje de error
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_PUNTAJE);
			// Retorna el resultado de la operación
			return respuestaServicio;	
		}

	}
	
	// Método que valida el puntaje total del exámen
	private boolean validaPuntajeTotalExamen(List<Pregunta> preguntas) {
		
		boolean puntajeValido = false;
		
		int sumatoriaPuntaje = 0;
		
		// Recorre preguntas
		for (Pregunta item: preguntas) {
			// Recorre respuestas por pregunta
			for(Respuestas itemRes : item.getRespuestas()) {
				sumatoriaPuntaje = sumatoriaPuntaje + itemRes.getPuntaje();
			}
		}
		
		if (sumatoriaPuntaje == 100) {
			puntajeValido = true;
		}else {
			puntajeValido = false;
		}
		
		return puntajeValido;		
	}

	// Método para crear la asignación del exámen a un estudiante
	@Override
	public RespuestaServicio crearAsignacionExamen(PresentacionExamen presentacionExamen) {
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try {
			// Obtener zona horaria por ciudad
			ZonaHoraria zonaHoraria = zonaHorariaDao.obtenerZonaHorariaPorIdCiudad(presentacionExamen.getIdCiudad().getId());
			
			// Se calcula la fecha con respecto a la zona horaria de Bogotá
			Calendar calendarPresentacion = Calendar.getInstance();
			calendarPresentacion.setTime(presentacionExamen.getFechaPresentacion()); // Configuramos la fecha que se recibe
			calendarPresentacion.add(Calendar.HOUR, 5);  // numero de horas a añadir, o restar en caso de horas<0
			presentacionExamen.setFechaPresentacion(calendarPresentacion.getTime());	
			
			// Guarda la asignación del examen en base de datos
			presentacionExamenDao.save(presentacionExamen);
			
			// Se calcula la fecha según la zona horaria del estudiante
			Calendar calendarPresentacionReal = Calendar.getInstance();			
			calendarPresentacionReal.setTime(presentacionExamen.getFechaPresentacion()); // Configuramos la fecha que se recibe
			calendarPresentacionReal.add(Calendar.HOUR, zonaHoraria.getHoraDiferencia());  // numero de horas a añadir, o restar en caso de horas<0
			Date fechaPresentacionReal =  calendarPresentacionReal.getTime();			
			      
			
			// Se asigna código de éxito
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_EXITO_OPERACION);
			// Se asigna mensaje de éxito
			respuestaServicio.setRespuesta("La fecha de presentación del exámen es " + fechaPresentacionReal);
			
			// Retorna el resultado de la operación
			return respuestaServicio;			
		}catch (Exception e) {
			// Se asigna código de error
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
			// Se asigna mensaje de error
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_OPERACION);
			// Retorna el resultado de la operación
			return respuestaServicio;	
		}
	}

	// Método que retorna la fecha de presentación por estudiante y exámen
	@Override
	public RespuestaServicio consultarFechaPresentacionExamen(EstudianteExamenDto estudianteExamenDto) {
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try {
			PresentacionExamen presentacionExamen = presentacionExamenDao.obtenerPresentacionExamenPorIdExamenIdEstudiante(estudianteExamenDto.getIdExamen(), estudianteExamenDto.getIdEstudiante());
			// Obtener zona horaria por ciudad
			ZonaHoraria zonaHoraria = zonaHorariaDao.obtenerZonaHorariaPorIdCiudad(presentacionExamen.getIdCiudad().getId());
			// Se calcula la fecha según la zona horaria del estudiante
			Calendar calendarPresentacionReal = Calendar.getInstance();			
			calendarPresentacionReal.setTime(presentacionExamen.getFechaPresentacion()); // Configuramos la fecha que se recibe
			calendarPresentacionReal.add(Calendar.HOUR, zonaHoraria.getHoraDiferencia());  // numero de horas a añadir, o restar en caso de horas<0
			Date fechaPresentacionReal =  calendarPresentacionReal.getTime();			
			      
			
			// Se asigna código de éxito
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_EXITO_OPERACION);
			// Se asigna mensaje de éxito
			respuestaServicio.setRespuesta("La fecha de presentación del exámen es " + fechaPresentacionReal);
			
			// Retorna el resultado de la operación
			return respuestaServicio;			
		}catch (Exception e) {
			// Se asigna código de error
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
			// Se asigna mensaje de error
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_OPERACION);
			// Retorna el resultado de la operación
			return respuestaServicio;	
		}
	}

	// Método que guarda las respuestas de la presentación del exámen
	@Override
	public RespuestaServicio guardarRespuestasPresentacion(RespuestasPresentacion respuestasPresentacion) {
		
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		
		try {
			// Se persiste en base de datos las respuestas del exámen
			respuestasPresentacionDao.save(respuestasPresentacion);
			// Se asigna código de éxito
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_EXITO_OPERACION);
			// Se asigna mensaje de éxito
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_EXITO_OPERACION);
			
			// Retorna el resultado de la operación
			return respuestaServicio;			
			
		} catch(Exception e){
			// Se asigna código de error
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
			// Se asigna mensaje de error
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_OPERACION);
			// Retorna el resultado de la operación
			return respuestaServicio;			
		}

	}

	@Override
	public RespuestaServicio obtenerCalificacionPorEstudiante(EstudianteExamenDto estudianteExamenDto) {
RespuestaServicio respuestaServicio = new RespuestaServicio();
		
		try {
			
			int resultadoExamen = 0;
			
			// Se persiste en base de datos las respuestas del exámen
			List<ResultadosExamenes> resultadosExamenes = resultadosExamenesDao.obtenerCalifiacion(estudianteExamenDto.getIdExamen(), estudianteExamenDto.getIdEstudiante());
			
			for(ResultadosExamenes item: resultadosExamenes) {
				resultadoExamen = resultadoExamen + item.getPuntaje();
			}
			
			// Se asigna código de éxito
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_EXITO_OPERACION);
			// Se asigna mensaje de éxito
			respuestaServicio.setRespuesta("La calificación es " + resultadoExamen);
			
			// Retorna el resultado de la operación
			return respuestaServicio;			
			
		} catch(Exception e){
			// Se asigna código de error
			respuestaServicio.setCodigoRespuesta(ConstantesFonYou.CODIGO_ERROR_OPERACION);
			// Se asigna mensaje de error
			respuestaServicio.setRespuesta(ConstantesFonYou.MENSAJE_ERROR_OPERACION);
			// Retorna el resultado de la operación
			return respuestaServicio;			
		}

	}
	

	

}
