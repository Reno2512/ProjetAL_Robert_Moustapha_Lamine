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

import com.inti.formation.entities.ParticipationEntity;
import com.inti.formation.service.IParticipationService;

@RestController
@RequestMapping("/apiParticipation")
@CrossOrigin("*")
public class ParticipationWebService {
	
	@Autowired
	private IParticipationService serv;
	
	
	@PostMapping
	public ParticipationEntity save(@RequestBody ParticipationEntity e) {
		return serv.save(e);
	}
	
	@PutMapping
	public void update(@RequestBody ParticipationEntity e) {
		serv.update(e);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		serv.delete(id);
	}
	
	@GetMapping("/{id}")
	public ParticipationEntity findById(@PathVariable long id) {
		return serv.findById(id);
	}
	
	@GetMapping
	public List<ParticipationEntity> findAll(){
		return serv.findAll();
	}
	
	
	
}
