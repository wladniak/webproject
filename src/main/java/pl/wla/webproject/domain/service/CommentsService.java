package pl.wla.webproject.domain.service;

import pl.wla.webproject.domain.CommentRest;

import java.util.List;

public interface CommentsService {
    List<CommentRest> getComments();

    CommentRest getSingleComment(final int id);
}
