package com.neepa.springboot.basics.springbootbasics;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRestController {
	
	@GetMapping("/books")
	public List<Books> getAllBooksBooks() {
		return Arrays.asList(new Books(1L, "Alchemist", "Paulo Coelo"));
	}

}
