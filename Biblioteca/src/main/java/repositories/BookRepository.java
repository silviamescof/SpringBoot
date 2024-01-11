package repositories;

import com.biblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Libro , Integer> {

}

