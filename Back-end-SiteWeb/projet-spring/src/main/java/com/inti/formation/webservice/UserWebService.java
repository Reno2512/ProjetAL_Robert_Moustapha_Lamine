package com.inti.formation.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.UserEntity;
import com.inti.formation.service.IUserService;

@RestController
@RequestMapping("/apiUser")
@CrossOrigin("*")
public class UserWebService {
	
	@Autowired
	IUserService serv;
	
	@PostMapping
	public UserEntity add(@RequestBody UserEntity u) {
		return serv.save(u);
	}
	
	@PutMapping
	public void update(@RequestBody UserEntity u) {
		serv.update(u);
	}
	
	@DeleteMapping("/delete/'{id}")
	public void delete(@PathVariable long id) {
		serv.delete(id);
	}
	
	@GetMapping("/find/{id}")
	public UserEntity findById(@PathVariable long id) {
		return serv.findById(id);
	}
	
	@GetMapping("/finALL")
	public List<UserEntity> findAll(){
		return serv.findAll();
	}

}
