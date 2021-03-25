package demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Book;

@RestController
@RequestMapping("/v1")
public class HelloController {
	
	@Autowired
	private Book book;
	
	@GetMapping("/books")
	public Object getAll(@RequestParam int page,@RequestParam(defaultValue="10") int size) {
		
		Map<String,Object> book1 = new HashMap<>();
		book1.put("name", "書名1");
		book1.put("isbn", "456789987uio");
		book1.put("author", "作家1");
		
		Map<String,Object> book2 = new HashMap<>();
		book2.put("name", "書名2");
		book2.put("isbn", "456789987uio");
		book2.put("author", "作家2");
		
		List<Map> contents = new ArrayList<>();
		contents.add(book1);
		contents.add(book2);
		
		Map<String,Object> pagemap = new HashMap<>();
		pagemap.put("page", page);
		pagemap.put("size", size);
		pagemap.put("contents", contents);
		
		return pagemap;
	}
	
	@GetMapping("/books/{id}")
	public Object getOne(@PathVariable long id) {		
		return book;
	}
	
	@PostMapping("books")
	public Object post(@RequestParam String name,
					@RequestParam String author,
					@RequestParam String isbn) {
		
		Map<String,Object> book = new HashMap<>();
		book.put("name", name);
		book.put("isbn", isbn);
		book.put("author", author);
		return book;
	}
}
