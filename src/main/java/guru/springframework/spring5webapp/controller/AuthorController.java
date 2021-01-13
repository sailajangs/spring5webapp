package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	AuthorRepository authRep;
	
	public AuthorController(AuthorRepository authRep) {
		this.authRep = authRep;
	}

	@RequestMapping("/authors")
	public String getAuthorsList(Model model) {
		
		model.addAttribute("authors",authRep.findAll());
		return "authors/authorslist";
	}
}
