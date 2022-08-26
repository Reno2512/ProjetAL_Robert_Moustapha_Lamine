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

import com.inti.formation.entities.DemandEntity;
import com.inti.formation.service.IDemandService;

@RestController
@RequestMapping("/apiDemand")
@CrossOrigin("*")
public class DemandWebService {
	
	@Autowired
	private IDemandService serv;
	
	@PostMapping
	public DemandEntity add(@RequestBody DemandEntity d) {
		return serv.save(d);
	}
	
	@PutMapping
	public void update(@RequestBody DemandEntity d) {
		serv.update(d);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		serv.delete(id);
	}
	
	@GetMapping("/{id}")
	public DemandEntity findById(@PathVariable long id) {
		return serv.findById(id);
	}
	
	@GetMapping
	public List<DemandEntity> findAll(){
		return serv.findAll();
	}
	

}
