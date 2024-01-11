package controller;

import com.biblioteca.entities.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.BookRepository;

import java.util.List;

@RestController
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> findAll() {
        try {
            List<Libro> libros = repository.findAll();
            return new ResponseEntity<>(libros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/libros/create")
    public ResponseEntity<Libro> create (@RequestBody Libro newLibro){
        try {
            if (newLibro.getTitulo() == null || newLibro.getTitulo().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            };
            Libro createdLibro = repository.save(newLibro);
            return new ResponseEntity<>(createdLibro, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/libros/delete")
    public ResponseEntity<Libro> delete(@PathVariable Integer id){
        try{
            if (!repository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Realizar la eliminación
            repository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
