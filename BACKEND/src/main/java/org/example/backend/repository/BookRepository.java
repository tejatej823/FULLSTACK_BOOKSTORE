package org.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.backend.model.Book;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface BookRepository extends JpaRepository<Book,UUID>{
    boolean existsByIsbn(String isbn);
}
