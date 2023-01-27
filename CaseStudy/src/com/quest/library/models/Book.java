package com.quest.library.models;

//title, ISBN, publication date, author, and availability.
public class Book 
{
	private int bookId;
	private String title;
	private String ISBN;
	private int publicationYear;
	private int edition;
	private int publisherId;
	private int categoryId;
	private int noOfCopies;
	private int availableCopies;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", ISBN=" + ISBN + ", publicationYear=" + publicationYear
				+ ", edition=" + edition + ", publisherId=" + publisherId + ", categoryId=" + categoryId
				+ ", noOfCopies=" + noOfCopies + ", availableCopies=" + availableCopies + "]";
	}
	
	
}
