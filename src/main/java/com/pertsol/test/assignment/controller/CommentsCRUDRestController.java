package com.pertsol.test.assignment.controller;

import com.pertsol.test.assignment.entities.Comments;
import com.pertsol.test.assignment.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentsCRUDRestController {

    @Autowired
    private CommentsService commentsService;

    //Create comment
    @PostMapping
    public ResponseEntity<Comments> createComments(@RequestBody Comments comments){
        return new ResponseEntity<Comments>(commentsService.createComment(comments), HttpStatus.CREATED);
    }

    //Update comment
    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComments(@RequestBody Comments comments,
                                                   @PathVariable(name = "id") Long id){
        return new ResponseEntity<Comments>(commentsService.updateComment(comments, id), HttpStatus.OK);
    }

    //delete comment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComments(@PathVariable(name = "id") Long id){
        commentsService.deleteComment(id);
        return new ResponseEntity<String>("The user with user id: "+ id + " deleted successfully.", HttpStatus.OK);
    }

}
