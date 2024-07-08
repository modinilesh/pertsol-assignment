package com.pertsol.test.assignment.services;

import com.pertsol.test.assignment.entities.Comments;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CommentsService {

    //create comment
    Comments createComment(Comments comments);

    //update Comment
    Comments updateComment(Comments comments, Long id);

    //delete Comment
    void deleteComment(Long id);

    //Tasks
    //get all comments
    List<Comments> getAllComments();

    //get comments by username
    List<Comments> getCommentsByUsername(String username);

    //get comments by date
    List<Comments> getCommentsByDate(LocalDate date);

}
