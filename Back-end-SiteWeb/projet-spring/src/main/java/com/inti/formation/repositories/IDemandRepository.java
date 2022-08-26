package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.DemandEntity;

public interface IDemandRepository extends JpaRepository<DemandEntity, Long>{

}
