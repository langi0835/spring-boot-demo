package demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long>{

	List<Book> findByAuthor(String author);
	List<Book> findByAuthorAndStatus(String author,int status);
	List<Book> findByDescriptionEndsWith(String des);
	
	@Query(value = "Select * From Book Where length(name) > ?1",nativeQuery = true)
	List<Book> findByJPql(int len);
}
