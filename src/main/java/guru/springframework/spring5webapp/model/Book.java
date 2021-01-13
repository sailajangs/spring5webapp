package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns =@JoinColumn(name="book_id"),
	           inverseJoinColumns = @JoinColumn(name= "author_id"))
	private Set<Author> author = new HashSet();
	
	@ManyToOne
	private Publisher publisher;
	
	
	public Book() {
	}


	public Book(String name, String isbn) {
		this.title = name;
		this.isbn = isbn;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String name) {
		this.title = name;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Set<Author> getAuthor() {
		return author;
	}


	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	

	public Publisher getPub() {
		return publisher;
	}


	public void setPub(Publisher pub) {
		this.publisher = pub;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + "]";
	}



	
	
}
