package com.sunbeam.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	private int id;
	private String title;
	@Column(name="rel_date")
	private Date release;
	
	public Movie() {
		super();
	}

	public Movie(int id, String title, Date release) {
		super();
		this.id = id;
		this.title = title;
		this.release = release;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", release=" + release + "]";
	}
	
	
	
}
