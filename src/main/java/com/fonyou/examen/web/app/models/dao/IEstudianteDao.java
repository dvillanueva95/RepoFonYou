package com.fonyou.examen.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fonyou.examen.web.app.models.entity.Estudiante;

public interface IEstudianteDao extends CrudRepository<Estudiante, Integer>{

}
