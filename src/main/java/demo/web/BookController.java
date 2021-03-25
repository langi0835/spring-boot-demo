package demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.Service.BookService;
import demo.domain.Book;

@RestController
@RequestMapping("/v1")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 取得所有書單
	 * @return
	 */
	@GetMapping("/books")
	public List<Book> getAll(){
		return bookService.findAll();		
	}
	
	/**
	 * 找尋一個書單
	 * @param id
	 * @return
	 */
	@GetMapping("/books/{id}")
	public Optional<Book> getOne(@PathVariable Long id){
		return bookService.findOne(id);		
	}
	
	/**
	 * 新增一個書單
	 * @param book
	 * @return
	 */
	@PostMapping("/books")
	public Book post(Book book) {
		return bookService.save(book);
	}
		
	/**
	 * 更新一個書單
	 * @param book
	 * @return
	 */
	@PutMapping("/books")
	public Book update(Book book) {
		return bookService.save(book);
	}
	
	/**
	 * 刪除一個書單
	 * @param id
	 */
	@DeleteMapping("/books/{id}")
	public void deleteOne(@PathVariable Long id){
		bookService.delete(id);		
	}
	
	/**
	 * 根據Author查詢書單
	 * @param author
	 * @return
	 */
	@PostMapping("/books/author")
	public List<Book> findByAuthor(@RequestParam String author) {
		return bookService.findByAuthor(author);
	}
	
	@PostMapping("/books/jpql")
	public List<Book> findByJPql(@RequestParam int len) {
		return bookService.findByJPql(len);
	}
}
