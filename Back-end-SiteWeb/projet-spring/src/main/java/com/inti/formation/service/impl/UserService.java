package com.inti.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.UserEntity;
import com.inti.formation.repositories.IUserRepository;
import com.inti.formation.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository rep;
	
	
	@Override
	public UserEntity save(UserEntity u) {
	
		return rep.save(u);
	}

	@Override
	public void update(UserEntity u) {
		rep.save(u);
		
	}

	@Override
	public void delete(long id) {
		rep.deleteById(id);
	}

	@Override
	public UserEntity findById(long id) {
		
		return rep.findById(id).get();
	}

	@Override
	public List<UserEntity> findAll() {
		return rep.findAll();
	}

}
