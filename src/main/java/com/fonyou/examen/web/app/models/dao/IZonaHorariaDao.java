package com.fonyou.examen.web.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fonyou.examen.web.app.models.entity.ZonaHoraria;

public interface IZonaHorariaDao extends CrudRepository<ZonaHoraria, Integer>{

	@Query(value = "SELECT * FROM zonaHoraria WHERE idCiudad = :idCiudad", nativeQuery=true)
    ZonaHoraria obtenerZonaHorariaPorIdCiudad(@Param("idCiudad") int idCiudad);
	
}
