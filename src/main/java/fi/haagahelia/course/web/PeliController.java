package fi.haagahelia.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.KategoriaRepository;
import fi.haagahelia.course.domain.Peli;
import fi.haagahelia.course.domain.PeliRepository;

@Controller
public class PeliController {
	@Autowired
	private PeliRepository repository; 

	@Autowired
	private KategoriaRepository drepository; 
	
	// Näytä kaikki pelit
    @RequestMapping(value="/pelilista")
    public String peliList(Model model) {	
        model.addAttribute("pelit", repository.findAll());
        return "pelilista";
    }
  
    // RESTful palvelu kaikkien pelien hankkimiseen
    @RequestMapping(value="/pelit", method = RequestMethod.GET)
    public @ResponseBody List<Peli> peliListRest() {	
        return (List<Peli>) repository.findAll();
    }    

    // RESTful palvelu kaikkien pelien hankkimiseen id:n mukaan
    @RequestMapping(value="/peli/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Peli> findPeliRest(@PathVariable("id") Long peliId) {	
    	return repository.findById(peliId);
    }       
    
    // Lisää uusi peli
    @RequestMapping(value = "/add")
    public String addPeli(Model model){
    	model.addAttribute("peli", new Peli());
    	model.addAttribute("kategoriat", drepository.findAll());
        return "lisaapeli";
    }     
    
    // Tallenna uusi peli
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Peli peli){
        repository.save(peli);
        return "redirect:pelilista";
    }    

    // Poista peli
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePeli(@PathVariable("id") Long peliId, Model model) {
    	repository.deleteById(peliId);
        return "redirect:../pelilista";
    }     
}