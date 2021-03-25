package demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Book;
import demo.domain.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * 查詢所有的書單列表
	 * @return
	 */
	public List<Book> findAll(){
		
		return bookRepository.findAll();
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> findOne(long id) {
		return bookRepository.findById(id);
	}
	
	public void delete(long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> findByAuthor(String author){
		return bookRepository.findByAuthor(author);
	}
	
	public List<Book> findByJPql(int len){
		return bookRepository.findByJPql(len);
	}
}
