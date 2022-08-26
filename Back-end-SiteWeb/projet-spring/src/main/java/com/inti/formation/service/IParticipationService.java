package com.inti.formation.service;

import java.util.List;

import com.inti.formation.entities.ParticipationEntity;

public interface IParticipationService {
	
	public ParticipationEntity save(ParticipationEntity e);
	public void update(ParticipationEntity e);
	public void delete(long id);
	public ParticipationEntity findById(long id);
	public List<ParticipationEntity> findAll();

}
