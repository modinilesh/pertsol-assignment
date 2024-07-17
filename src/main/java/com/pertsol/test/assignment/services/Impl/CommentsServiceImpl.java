package com.pertsol.test.assignment.services.Impl;

import com.pertsol.test.assignment.dto.ResponseDto;
import com.pertsol.test.assignment.entities.Comments;
import com.pertsol.test.assignment.repository.CommentsRepository;
import com.pertsol.test.assignment.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    private ResponseDto responseDto = new ResponseDto<>();

    @Override
    public Comments createComment(Comments comments) {
        Comments savedComment = commentsRepository.save(comments);
        return savedComment;
    }

    @Override
    public Comments updateComment(Comments comments, Long id) {
        Comments old = commentsRepository.findById(id).orElseGet(null);
        old.setText(comments.getText());
        old.setUsername(comments.getUsername());
        old.setDate(comments.getDate());
        return commentsRepository.save(old);
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
    }

    @Override
    public List<Comments> getAllComments() {
        List<Comments> comments = commentsRepository.findAll();
        return comments;
    }

    @Override
    public List<Comments> getCommentsByUsername(String username) {
        List<Comments> commentsByUsername = commentsRepository.findByUsername(username);
        return commentsByUsername;
    }

    @Override
    public List<Comments> getCommentsByDate(LocalDate date) {
        List<Comments> commentsByDate = commentsRepository.findByDate(date);
        return commentsByDate;
    }

    @Override
    public ResponseDto getCommentsByUsernameAndDate(String username, LocalDate date) {
        try{
            List<Comments> commentsByUsernameAndDate = commentsRepository.findByUsernameAndDate(username, date);
            responseDto.setData(commentsByUsernameAndDate);
            responseDto.setMessage("Data fetched successfully");
            responseDto.setStatusCode(HttpStatus.OK);
        }catch (Exception e){
            responseDto.setMessage(e.getMessage());
            responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseDto;
    }


}
