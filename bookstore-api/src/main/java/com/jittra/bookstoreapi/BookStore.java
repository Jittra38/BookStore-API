package com.jittra.bookstoreapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookStore {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String book_name;
	private String author_name;
    private Double price;
  
    
    public BookStore(){

    }

	
	public BookStore(Integer id, String book_name, String author_name, Double price) {
		this.id = id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.price = price;
	}

	public String getbook_name() {
		return book_name;
	}
	public void setbook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getauthor_name() {
		return author_name;
	}
	public void setauthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	//public boolean isRecommend() {
	//	return recommend;
	//}

	//public void setRecommend(boolean recommend) {
	//	this.recommend = recommend;
	//}
	

}
