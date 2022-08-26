package com.inti.formation.service;

import java.util.List;

import com.inti.formation.entities.DemandEntity;


public interface IDemandService {
	public DemandEntity save(DemandEntity d);
	public void update(DemandEntity d);
	public void delete(long id);
	public DemandEntity findById(long id);
	public List<DemandEntity> findAll();

}
