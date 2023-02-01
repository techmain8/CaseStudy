package com.quest.library.repositories;

import java.util.ArrayList;
import java.util.List;
import com.quest.library.interfaces.BookRepoInterface;
import com.quest.library.models.Book;

public class BookRepo implements BookRepoInterface
{
	private List<Book> books;

	//TO assign book 
	public BookRepo() 
	{
        books = new ArrayList<>();
    }
	
	//To Add New Book 
	public void addBook(Book book) 
	{
		books.add(book);
	}
	
	//To Get All Books
	public List<Book> getAllBooks() 
	{
		return books;
	}
	
	//To Find A Book By Id
	public Book findBookById(int id) 
	{
		for (Book book : books) 
		{
			if (book.getBookId() == id) 
			{
				return book;
			}
		}
		return null;
	}
	
	//To Find A Book By Title
	public List<Book> findBooksByTitle(String title) 
	{
		List<Book> result = new ArrayList<>();
		for (Book book : books) 
		{
			if (book.getTitle().equalsIgnoreCase(title)) 
			{
				result.add(book);
			}
		}
		return result;
	}
	
	// To Update A Book
	public void updateBook(Book updatedBook) 
	{
		for (Book book : books) 
		{
			if (book.getBookId() == updatedBook.getBookId()) 
			{
				book.setTitle(updatedBook.getTitle());
				book.setISBN(updatedBook.getISBN());
				book.setPublicationYear(updatedBook.getPublicationYear());
				book.setEdition(updatedBook.getEdition());
				book.setPublisherId(updatedBook.getPublisherId());
				book.setCategoryId(updatedBook.getCategoryId());
				book.setNoOfCopies(updatedBook.getNoOfCopies());
				book.setAvailableCopies(updatedBook.getAvailableCopies());
				break;
			}
		}
	}

	// To Delete A Book
	public void deleteBook(int id) 
	{
		for (int i = 0; i < books.size(); i++) 
		{
	      if (books.get(i).getBookId() == id) 
	      {
	        books.remove(i);
	        break;
	      }
	    }
	  }
}

