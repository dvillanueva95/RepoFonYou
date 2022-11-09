package com.fonyou.examen.web.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fonyou.examen.web.app.models.dao.IEstudianteDao;
import com.fonyou.examen.web.app.models.entity.Estudiante;
import com.fonyou.examen.web.app.util.ConstantesFonYou;
import com.fonyou.examen.web.app.util.RespuestaServicio;

@Service
public class GestionEstudianteServiceImpl implements IGestionEstudianteService{
	
	@Autowired
	private IEstudianteDao estudianteDao;

	@Override
	public RespuestaServicio crearEstudiante(Estudiante estudiante) {
		
		RespuestaServicio respuestaServicio = new RespuestaServicio();
				
		try {
			// Se persiste en base de datos un nuevo estudiante
			estudianteDao.save(estudiante);
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

}
