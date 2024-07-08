package com.pertsol.test.assignment.controller;

import com.pertsol.test.assignment.entities.Comments;
import com.pertsol.test.assignment.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentsRestController {

    @Autowired
    private CommentsService commentsService;

    //Retrieve all comments
    @GetMapping
    public ResponseEntity<List<Comments>> getComments(){
        return new ResponseEntity<List<Comments>>(commentsService.getAllComments(), HttpStatus.OK);
    }

    //get comments by username
    @GetMapping(value = "/search", params = "username")
    public ResponseEntity<List<Comments>> getAllCommentsByUsername(
            @RequestParam(required = false, value = "username") String username){
        return new ResponseEntity<>(commentsService.getCommentsByUsername(username), HttpStatus.OK);
    }

    //Retrieve all comments
    @GetMapping(value = "/search", params = "date")
    public ResponseEntity<List<Comments>> getAllCommentsByDate(
            @RequestParam(required = false, value = "date") @DateTimeFormat LocalDate date){
        return new ResponseEntity<>(commentsService.getCommentsByDate(date), HttpStatus.OK);
    }

}
