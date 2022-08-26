package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.UserEntity;

public interface IUserRepository extends JpaRepository <UserEntity, Long>{

}
