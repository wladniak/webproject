package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.CommentRest;
import pl.wla.webproject.domain.mapper.EntityToDomainMapper;
import pl.wla.webproject.repository.restsource.CommentsDAO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommentsServiceImpl implements CommentsService {
    private final CommentsDAO commentsDAO;

    private final EntityToDomainMapper entityToDomainMapper;

    @Override
    public List<CommentRest> getComments() {
        return commentsDAO.getRestData().stream().map(entityToDomainMapper::mapComment).collect(Collectors.toList());
    }

    @Override
    public CommentRest getSingleComment(int id) {

        return entityToDomainMapper.mapComment(commentsDAO.getSingleComment(id));


    }
}
