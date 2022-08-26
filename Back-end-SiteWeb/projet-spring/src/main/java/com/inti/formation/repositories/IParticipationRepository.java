package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.ParticipationEntity;

public interface IParticipationRepository extends JpaRepository<ParticipationEntity, Long>{

}
