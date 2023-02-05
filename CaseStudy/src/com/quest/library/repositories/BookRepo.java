package com.quest.library.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.quest.library.interfaces.BookRepoInterface;
import com.quest.library.models.Book;
import com.quest.library.config.DataBaseConfig;

public class BookRepo implements BookRepoInterface
{
	private Connection getConnection() throws ClassNotFoundException, SQLException 
	{

		Class.forName(DataBaseConfig.DRIVER_URL);
		return DriverManager.getConnection(DataBaseConfig.CONNECTION_URL, DataBaseConfig.USERNAME,
				DataBaseConfig.PASSWORD);

	}
	
	
	//To Add New Book 
	public void addBook(Book book) 
	{
		try (Connection connection = getConnection()) 
		{
			String query = "INSERT INTO books (book_id, title, ISBN, publication_year, edition, publisher_id, category_id, no_of_copies, available_copies) " + "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, book.getBookId());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getISBN());
			statement.setInt(4, book.getPublicationYear());
			statement.setInt(5, book.getEdition());
			statement.setInt(6, book.getPublisherId());
			statement.setInt(7, book.getCategoryId());
			statement.setInt(8, book.getNoOfCopies());
			statement.setInt(9, book.getAvailableCopies());
			int noOfRowsAffected = statement.executeUpdate();
			if (noOfRowsAffected > 0) 
			{
				System.out.println("Book Added Sucessfully!");
			} 
			else 
			{
				System.out.println("Oops! Something Went Wrong");
			}
			statement.close();
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	// To Update A Book
	public void updateBook(Book updatedBook) 
	{
		try (Connection connection = getConnection()) 
		{
			String sql = "UPDATE books SET title = ?, ISBN = ?, publication_year = ?, edition = ?, publisher_id = ?, category_id = ?, no_of_copies = ?, available_copies = ? WHERE book_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, updatedBook.getTitle());
			statement.setString(2, updatedBook.getISBN());
			statement.setInt(3, updatedBook.getPublicationYear());
			statement.setInt(4, updatedBook.getEdition());
			statement.setInt(5, updatedBook.getPublisherId());
			statement.setInt(6, updatedBook.getCategoryId());
			statement.setInt(7, updatedBook.getNoOfCopies());
			statement.setInt(8, updatedBook.getAvailableCopies());
			statement.setInt(9, updatedBook.getBookId());
			int noOfRowsAffected = statement.executeUpdate();
			if (noOfRowsAffected > 0) 
			{
				System.out.println("Book Updated Sucessfully!");
			} 
			else 
			{
				System.out.println("Oops! Something Went Wrong");
			}
			statement.close();
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
		
	//To Get All Books
	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<>();
		try (Connection connection = getConnection()) 
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

			while(resultSet.next()) 
			{
				int id = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String ISBN = resultSet.getString("ISBN");
				int publicationYear = resultSet.getInt("publication_year");
				int edition = resultSet.getInt("edition");
				int publisherId = resultSet.getInt("publisher_id");
				int categoryId = resultSet.getInt("category_id");
				int noOfCopies = resultSet.getInt("no_of_copies");
				int availableCopies = resultSet.getInt("available_copies");
				books.add(new Book(id, title, ISBN, publicationYear, edition, publisherId, categoryId, noOfCopies, availableCopies));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return books;
	}

	
	//To Find A Book By Id
	public Book findBookById(int id) 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try 
		{
			connection = getConnection();
			statement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) 
			{
				int bookid = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String ISBN = resultSet.getString("ISBN");
				int publicationYear = resultSet.getInt("publicationYear");
				int edition = resultSet.getInt("edition");
				int publisherId = resultSet.getInt("publisherId");
				int categoryId = resultSet.getInt("categoryId");
				int noOfCopies = resultSet.getInt("noOfCopies");
				int availableCopies = resultSet.getInt("availableCopies");
				return new Book(bookid, title, ISBN, publicationYear, edition, publisherId, categoryId, noOfCopies,
						availableCopies);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (resultSet != null) 
				{
					resultSet.close();
				}
				if (statement != null) 
				{
					statement.close();
				}
				if (connection != null) 
				{
					connection.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//To Find A Book By Title
	public List<Book> findBooksByTitle(String title) 
	{
		List<Book> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			String query = "SELECT * FROM books WHERE title = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, title);
			resultSet = statement.executeQuery();
			while (resultSet.next()) 
			{
				Book book = new Book();
				book.setBookId(resultSet.getInt("id"));
				book.setTitle(title);
				book.setISBN(resultSet.getString("ISBN"));
				book.setPublicationYear(resultSet.getInt("publication_year"));
				book.setEdition(resultSet.getInt("edition"));
				book.setPublisherId(resultSet.getInt("publisher_id"));
				book.setCategoryId(resultSet.getInt("category_id"));
				book.setNoOfCopies(resultSet.getInt("no_of_copies"));
				book.setAvailableCopies(resultSet.getInt("available_copies"));
				result.add(book);
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (resultSet != null) 
				{
					resultSet.close();
				}
				if (statement != null) 
				{
					statement.close();
				}
				if (connection != null) 
				{
					connection.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	// To Delete A Book
	public void deleteBook(int id) 
	{
		try (Connection connection = getConnection()) 
		{
			String sql = "DELETE FROM books WHERE book_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			int noOfRowsAffected = statement.executeUpdate();
			if (noOfRowsAffected > 0) {
				System.out.println("Student Deleted Sucessfully!");
			} else {
				System.out.println("Oops! Something Went Wrong");
			}
			statement.close();
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}

