package repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jittra.bookstoreapi.BookStore;

public interface BookStoreRepository extends JpaRepository<BookStore, String> {
	
	
}