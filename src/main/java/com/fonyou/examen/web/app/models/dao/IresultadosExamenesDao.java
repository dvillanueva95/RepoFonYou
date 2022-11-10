package com.fonyou.examen.web.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fonyou.examen.web.app.models.view.ResultadosExamenes;

public interface IresultadosExamenesDao extends CrudRepository<ResultadosExamenes, String>{
	
	@Query(value = "SELECT * FROM resultadosExamenes WHERE idExamen = :idExamen AND idEstudiante = :idEstudiante", nativeQuery=true)
	List<ResultadosExamenes> obtenerCalifiacion(@Param("idExamen") int idExamen, @Param("idEstudiante") int idEstudiante );	

}
