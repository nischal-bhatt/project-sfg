package jt.project.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jt.project.domain.Author;
import jt.project.domain.Book;
import jt.project.domain.Publisher;
import jt.project.repositories.AuthorRepository;
import jt.project.repositories.BookRepository;
import jt.project.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("ST PETERSBURG");
		publisher.setState("FL");
		
		publisherRepository.save(publisher);
		
		
		Author eric = new Author("eric","evant");
		Book ddd = new Book("Domain driven design","123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author rod = new Author("rod","johnson");
		Book noEJB = new Book("J2EE DEveloper kamathi with EJB","1213131344");
		
		rod.getBooks().add(noEJB);
	    noEJB.getAuthors().add(rod);
	    noEJB.setPublisher(publisher);
	    publisher.getBooks().add(noEJB);
	    
	    authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
	    
		
	    System.out.println("started in bootstrap");
	    System.out.println("num of books " + bookRepository.count());
	    //System.out.println();
	    System.out.println(publisher.getBooks().size());
	    //System.out.println(rod); - circular reference
	    System.out.println(rod);
	    //what is to string circular reference?
	}

}
