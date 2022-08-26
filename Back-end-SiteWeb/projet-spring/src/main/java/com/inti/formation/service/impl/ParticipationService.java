package com.inti.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.ParticipationEntity;
import com.inti.formation.repositories.IParticipationRepository;
import com.inti.formation.service.IParticipationService;

@Service
public class ParticipationService implements IParticipationService{

	@Autowired
	IParticipationRepository rep;
	
	@Override
	public ParticipationEntity save(ParticipationEntity e) {
		return rep.save(e);
	}

	@Override
	public void update(ParticipationEntity e) {
		rep.save(e);		
	}

	@Override
	public void delete(long id) {
		rep.deleteById(id);
	}

	@Override
	public ParticipationEntity findById(long id) {
		return rep.findById(id).get();
	}

	@Override
	public List<ParticipationEntity> findAll() {
		return rep.findAll();
	}

}
