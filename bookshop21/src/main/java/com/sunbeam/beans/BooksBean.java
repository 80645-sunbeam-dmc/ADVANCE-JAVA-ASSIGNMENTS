package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.BookDao;
import com.sunbeam.pojos.Book;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-22 13:10 
 */
public class BooksBean {
	private String subject;
	private List<Book> bookList;
	public BooksBean() {
		this.bookList = new ArrayList<>();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public void fetchBooks() {
		try(BookDao bookDao = new BookDao()) {
			this.bookList = bookDao.findBySubject(this.subject);
			System.out.println("list"+this.bookList);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
