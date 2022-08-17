package cl.RicardoC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.RicardoC.models.Ninja;
import cl.RicardoC.repositories.NinjaRepo;

@Service
public class NinjaService {

	//inyecto interfaz 
	@Autowired
	NinjaRepo ninjaRepo;

	public NinjaService(NinjaRepo ninjaRepo) {
		super();
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> findAllNinjas(){
		return (List<Ninja>) this.ninjaRepo.findAll();
	}
	
	public Optional<Ninja> findAllNinjasById(Long id){
		return this.ninjaRepo.findById(id);
	}
	
	public Ninja saveAndUpdateNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	
	
}
