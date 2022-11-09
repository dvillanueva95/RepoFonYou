package com.fonyou.examen.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fonyou.examen.web.app.models.entity.Examen;

public interface IExamenDao extends CrudRepository<Examen, Integer>{

}
