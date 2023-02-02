package com.quest.library.models;

import java.util.Date;

//patron, book, fine amount, and payment status.
public class Fine 
{
	private int fineId;
    private int patronId;
    private int bookId;
    private Date dueDate;
    private Date returnDate;
    private int fine;
    
	public int getFineId() {
		return fineId;
	}
	public void setFineId(int fineId) {
		this.fineId = fineId;
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
		return "Fine [fineId=" + fineId + ", patronId=" + patronId + ", bookId=" + bookId + ", dueDate=" + dueDate
				+ ", returnDate=" + returnDate + ", fine=" + fine + "]";
	}
    
    
}
