package com.jittra.bookstoreapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import java.util.ArrayList;

@Entity
public class Users {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String date_of_birth;
	//private ArrayList<String> books;
	//private String salt;
	
	

	public Users(String id, String username, String password, String date_of_birth){
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.date_of_birth = date_of_birth;
	        //this.books = books;
	      //  this.salt = salt;
	    }

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getdate_of_birth() {
		return date_of_birth;
	}

	public void setdate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	//public ArrayList<String> getBooks() {
	//return books;
	//}

	//public void setBooks(ArrayList<String> books) {
		//this.books = books;
	//}
	//public String getSalt() {
	//	return salt;
	//}

//	public void setSalt(String salt) {
	//	this.salt = salt;
	//}

}
