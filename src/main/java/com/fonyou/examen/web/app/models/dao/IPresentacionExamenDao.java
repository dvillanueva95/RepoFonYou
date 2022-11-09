package com.fonyou.examen.web.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fonyou.examen.web.app.models.entity.PresentacionExamen;
import com.fonyou.examen.web.app.models.entity.ZonaHoraria;

public interface IPresentacionExamenDao extends CrudRepository<PresentacionExamen, Integer >{
	
	@Query(value = "SELECT * FROM presentacionExamen WHERE idExamen = :idExamen AND idEstudiante = :idEstudiante", nativeQuery=true)
	PresentacionExamen obtenerPresentacionExamenPorIdExamenIdEstudiante(@Param("idExamen") int idExamen, @Param("idEstudiante") int idEstudiante);

}
