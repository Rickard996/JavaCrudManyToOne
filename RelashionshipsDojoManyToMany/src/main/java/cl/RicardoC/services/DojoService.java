package cl.RicardoC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.RicardoC.models.Dojo;
import cl.RicardoC.repositories.DojoRepo;

@Service
public class DojoService {

	@Autowired
	DojoRepo dojoRepo;
	
	public List<Dojo> findAllDojos(){
		return (List<Dojo>) this.dojoRepo.findAll();
	}
	
	public Optional<Dojo> findAllDojosById(Long id){
		return this.dojoRepo.findById(id);
	}
	
	public Dojo saveAndUpdateDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	
	
	
	
}
