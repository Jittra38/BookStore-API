package com.jittra.bookstoreapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;



@RestController
public class BookController {
	private static final Order Order = null;

//	List<BookStore> bookstore = new ArrayList<>(Arrays.asList(
//            new BookStore(5,"An American Princess","Annejet van ser Zijk",200.00),
//            new BookStore(1,"Jittra","Annejet van ser Zijk",500.00),
//            new BookStore(3,"test","Annejet van ser Zijk",800.00)
//	));
    
	List<Users> users = new ArrayList<>(Arrays.asList(
            new Users("2","Jhon","password1234","Moday"),
            new Users("3","Jittr","password1234","Friday"),
            new Users("4","King","password1234","Friday")
	));
	
	class ResponseError {
		public String message;

		public ResponseError(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
		
	       
	//@RequestMapping("/books")
//	public List<BookStore> getAllBook() {
	//   return bookstore;
	//}
	
	@RequestMapping(path = "/users/orders", method = RequestMethod.POST, headers = "Accept=application/json")
	  Order newOrder(@RequestBody Order newOrder) {
	   // return repository.save(newOrder);
		 return Order;
	  }

         
	@RequestMapping("/users")
	public List<Users> getAllUsers() {
	   return users;
	}
	
	@RequestMapping(path = "/books", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<?> GetBook(@Context JSONArray jsonArray) throws JSONException {
		//ArrayList<BookStore> books = getBooksRecom();
		//ArrayList<BookStore> books = getBooksNormal();
		ArrayList<BookStore> books = getBooks();
	//	List<BookStore> bookstore = new ArrayList<>(Arrays.asList(
	      //      new BookStore(5,"An American Princess","Annejet van ser Zijk",200.00),
	       //     new BookStore(1,"Jittra","Annejet van ser Zijk",500.00),
	        //    new BookStore(3,"test","Annejet hjgkujhfijhgijhgfhjkjhg van ser Zijk",800.00)
		//));
		
		if(books.isEmpty()) {
			return ResponseEntity.ok(new ResponseError("Books out of stock."));
		}
		return ResponseEntity.ok(books);
	}
	
	
	@RequestMapping(value = "/users/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUsers(@PathVariable String id) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getId().equals(id)) {
				users.remove(i);
				return ResponseEntity.ok("200 OK");
				//break;
			}
		}
		return ResponseEntity.ok("200 ERROR");
     }
	
	private ArrayList<BookStore> getBooksRecom() throws JSONException {
		return getBookByJson(getJson("https://scb-test-book-publisher.herokuapp.com/books/recommendation"));
	}

	private JSONArray getJson(String url) throws JSONException {
		RestClient rest = new RestClient();
		String str_json = "{data : " + rest.get(url) + " }";
		JSONObject mainObj = new JSONObject(str_json);
		return (JSONArray) mainObj.getJSONArray("data");
	}
	
	private ArrayList<BookStore> getBookByJson(JSONArray jsonArray) throws JSONException {
		ArrayList<BookStore> book = new ArrayList<BookStore>();
		for (int i = 0; i < jsonArray.length(); i++) {
			System.out.println();
			JSONObject obj = jsonArray.getJSONObject(i);
			String author_name = obj.getString("author_name");
			Double price = obj.getDouble("price");
			Integer id = obj.getInt("id");
			String book_name = obj.getString("book_name");
			book.add(new BookStore(id, book_name, author_name, price));
		}
		return book;
	}
	
	private ArrayList<BookStore> getBooksNormal() throws JSONException {
		return getBookByJson(getJson("https://scb-test-book-publisher.herokuapp.com/books"));
	}
	
	private ArrayList<BookStore> getBooks() throws JSONException {
		ArrayList<BookStore> book_normal = getBooksNormal();
		ArrayList<BookStore> book_recom = getBooksRecom();
		ArrayList<BookStore> book_rtn = new ArrayList<BookStore>();
//		book_recom.addAll(book_normal);
		if(book_recom.isEmpty() && book_recom.isEmpty()) {
			return book_recom;
		}
		book_rtn = checkDuplicate(book_recom,book_rtn);
		book_rtn = checkDuplicate(book_normal,book_rtn);

		return book_rtn;
	}
	
	private ArrayList<BookStore> checkDuplicate(ArrayList<BookStore>book, ArrayList<BookStore>book_rtn) {
		for (int i = 0; i < book.size(); i++) {
			if (i == 0) {
				book_rtn.add(book.get(i));
			} else {
				boolean check_dup = false;
				for (int j = 0; j < book_rtn.size(); j++) {
					if (book.get(i).getId() == book_rtn.get(j).getId()) {
						check_dup = true;
					}
				}
				if (!check_dup) {
					book_rtn.add(book.get(i));
				}
			}
		}
		return book_rtn;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String>  Login(@RequestBody Users newUser) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(newUser.getUsername()) && users.get(i).getPassword().equals(newUser.getPassword())) {
				return ResponseEntity.ok("200 OK");
			}
		}
		return ResponseEntity.ok("200 ERROR");
   }
}


