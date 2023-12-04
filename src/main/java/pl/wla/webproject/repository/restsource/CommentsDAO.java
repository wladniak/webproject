package pl.wla.webproject.repository.restsource;

import java.util.List;

public interface CommentsDAO {
    public List<CommentRestEntity> getRestData();

    public CommentRestEntity getSingleComment(final int id);
}
