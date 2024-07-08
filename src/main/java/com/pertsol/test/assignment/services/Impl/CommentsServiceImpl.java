package com.pertsol.test.assignment.services.Impl;

import com.pertsol.test.assignment.entities.Comments;
import com.pertsol.test.assignment.repository.CommentsRepository;
import com.pertsol.test.assignment.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

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
}
