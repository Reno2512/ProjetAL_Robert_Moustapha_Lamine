package com.inti.formation.service;

import java.util.List;

import com.inti.formation.entities.UserEntity;

public interface IUserService {
	
	public UserEntity save(UserEntity u);
	public void update(UserEntity u);
	public void delete(long id);
	public UserEntity findById(long id);
	public List<UserEntity> findAll();

}
