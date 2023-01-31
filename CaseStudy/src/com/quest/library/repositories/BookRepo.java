package com.quest.library.repositories;

import java.util.ArrayList;
import java.util.List;

import com.quest.library.models.Book;

public class BookRepo {

	private List<Book> books;

	public BookRepo() {
        books = new ArrayList<>();
    }

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book findBookById(int id) {
		for (Book book : books) {
			if (book.getBookId() == id) {
				return book;
			}
		}
		return null;
	}

	public List<Book> findBooksByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				result.add(book);
			}
		}
		return result;
	}


}
