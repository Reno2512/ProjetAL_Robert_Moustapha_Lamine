package com.inti.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.DemandEntity;
import com.inti.formation.repositories.IDemandRepository;
import com.inti.formation.service.IDemandService;

@Service
public class DemandService implements IDemandService{

	@Autowired
	private IDemandRepository rep;
	
	@Override
	public DemandEntity save(DemandEntity d) {
		return rep.save(d);
	}

	@Override
	public void update(DemandEntity d) {
		rep.save(d);
		
	}

	@Override
	public void delete(long id) {
		rep.deleteById(id);
		
	}

	@Override
	public DemandEntity findById(long id) {

		return rep.findById(id).get();
	}

	@Override
	public List<DemandEntity> findAll() {
		
		return rep.findAll();
	}

}
