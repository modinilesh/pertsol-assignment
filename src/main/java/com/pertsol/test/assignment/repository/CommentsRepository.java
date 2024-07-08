package com.pertsol.test.assignment.repository;

import com.pertsol.test.assignment.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    //find Comments by username
    List<Comments> findByUsername(String username);

    //find Comments by date
    List<Comments> findByDate(LocalDate date);

}
