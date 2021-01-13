package guru.springframework.spring5webapp.bootstap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private AuthorRepository authRep;
	private BookRepository bookRep;
	private PublisherRepository pubRep;

	
	public BootStrapData(AuthorRepository authRep, BookRepository bookRep,PublisherRepository pubRep) {
		this.authRep = authRep;
		this.bookRep = bookRep;
		this.pubRep = pubRep;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
        Publisher penguin = new Publisher();
        penguin.setName("Penguin");
        penguin.setStreet("1232 WilliamAve");
        penguin.setCity("BF");
        penguin.setState("NY");
        penguin.setZip("74637");
        
        pubRep.save(penguin);
        
        
		Author orwell = new Author("George","Orwell");
        Book ddd = new Book("1984", "123123"); 
        //Address add1 = new Address("1232 WilliamAve","BF","NY","74637");

        orwell.getBooks().add(ddd);
        ddd.getAuthor().add(orwell);
        penguin.getBooks().add(ddd);
        

        authRep.save(orwell);
        bookRep.save(ddd);
        pubRep.save(penguin);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        penguin.getBooks().add(noEJB);
        

        authRep.save(rod);
        bookRep.save(noEJB);
        pubRep.save(penguin);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRep.count());
        System.out.println("Publishers:"+pubRep.count());
        System.out.println("no.of books for penguin:"+penguin.getBooks().size());
		
	}

}
