package com.demo.repository;

import com.demo.entity.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    @Query("SELECT e FROM BookEntity e WHERE e.bookName LIKE  %:title%")
    public List<BookEntity> getBooksByTitle(@Param("title") String title);
}
