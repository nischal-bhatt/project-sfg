package jt.project.repositories;

import org.springframework.data.repository.CrudRepository;

import jt.project.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}
