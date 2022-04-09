package jt.project.repositories;

import org.springframework.data.repository.CrudRepository;

import jt.project.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long>{

}
