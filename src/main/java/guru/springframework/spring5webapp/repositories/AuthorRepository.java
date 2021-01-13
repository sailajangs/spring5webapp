package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
