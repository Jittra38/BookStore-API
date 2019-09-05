package com.jittra.bookstoreapi;

import java.awt.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;


@Entity
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	  public Order(){

	  }

	@Autowired
	private Double id_book;
    private Double price;
    
    
    public Double getIdbook() {
  		return id_book;
  	}
  	public void setIdbook(Double id_book) {
  		this.id_book = id_book;
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
}
