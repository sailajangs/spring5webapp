package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	
	private BookRepository bookRep;
	
	public BookController(BookRepository bookRep) {
		this.bookRep = bookRep;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books",bookRep.findAll());
		return "books/books"; 
	}

}
