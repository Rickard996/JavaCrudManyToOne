package cl.RicardoC.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import cl.RicardoC.models.Dojo;
import cl.RicardoC.models.Ninja;
import cl.RicardoC.services.DojoService;
import cl.RicardoC.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	//main page. view create new dojo
	@RequestMapping(value = "/dojos/new", method = RequestMethod.GET)
	public String homeNewDojo() {
		return "newDojo.jsp";
	}
	
	//create a new dojo
	
	@RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
	public RedirectView createDojo(@Valid @RequestParam(value = "nameDojo") String nameDojo) {
		
		Dojo newDojo = new Dojo();
		newDojo.setName(nameDojo);
		this.dojoService.saveAndUpdateDojo(newDojo);
		return new RedirectView("/ninjas/new");

	}
	
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.GET)
	public String newNinjaView(Model model) {
		
		List<Dojo> listOfAllDojos = this.dojoService.findAllDojos();
		model.addAttribute("listDojos", listOfAllDojos);
		
		return "newNinja.jsp";
	}
	
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.PUT)
	public RedirectView createNinja(@Valid @RequestParam(value = "dojoId") Long dojoId,
			@Valid @ModelAttribute(value = "ninja") Ninja ninja,
			BindingResult result) {
		
		
		System.out.println("recibi mi objeto con id aun null: "+ninja);
		if(result.hasErrors()) {
			return new RedirectView("/ninjas/new");
		}else {
			Optional<Dojo> optDojo = this.dojoService.findAllDojosById(dojoId);  //encuentra el dojo al que le agregaré mi ninja
			if(optDojo.isPresent()) {
				Dojo dojoToAddNinja = optDojo.get();  //si existe, obtengo mi dojo
				ninja.setDojo(dojoToAddNinja);
				dojoToAddNinja.getNinjas().add(ninja);
				this.ninjaService.saveAndUpdateNinja(ninja);
			}
			return new RedirectView("/ninjas/new");
		}

	}
	
	@RequestMapping(value = "/dojos/{id}")
	public String viewStudentsInDojo(@PathVariable(value = "id") Long id,
			Model model) {
		
		List<Ninja> allNinjas = this.ninjaService.findAllNinjas();  //los encuentro a todos
//		//ahora los filtrare
		ArrayList<Ninja> ninjasInIdDojo = new ArrayList<Ninja>(); //aca guardo solo los del id que me interesan
//		
		for(Ninja ninja: allNinjas) {
			if(ninja.getDojo().getId()==id) {
				ninjasInIdDojo.add(ninja);
			}
		}
		
		model.addAttribute("ninjasInIdDojo", ninjasInIdDojo);
		if(!ninjasInIdDojo.isEmpty()) {
			model.addAttribute("dojoName", ninjasInIdDojo.get(0).getDojo().getName());
		}
		
		
		return "finalView.jsp";
	}
	
	
	
	
	
	
	
	
}
