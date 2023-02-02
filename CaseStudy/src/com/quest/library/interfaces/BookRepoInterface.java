package com.quest.library.interfaces;

import java.util.List;

import com.quest.library.models.Book;

public interface BookRepoInterface 
{
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public Book findBookById(int id);
	public List<Book> findBooksByTitle(String title);
	public void updateBook(Book updatedBook);
	public void deleteBook(int id);
	
}
