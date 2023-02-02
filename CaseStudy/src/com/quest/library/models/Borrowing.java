package com.quest.library.models;

import java.util.Date;

//book, User, borrow date, and return date.
public class Borrowing 
{
	private int borrowId;
    private int patronId;
    private int bookId;
    private Date borrowedDate;
    private Date dueDate;
    private Date returnDate;
    private int fine;
    
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getPatronId() {
		return patronId;
	}
	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	@Override
	public String toString() {
		return "Borrowing [borrowId=" + borrowId + ", patronId=" + patronId + ", bookId=" + bookId + ", borrowedDate="
				+ borrowedDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fine=" + fine + "]";
	}
    
    
}
