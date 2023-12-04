package pl.wla.webproject.repository.restsource;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CommentsDAOImpl implements CommentsDAO {
    private final static String restURL = "https://jsonplaceholder.typicode.com/comments";
    private RestTemplate restTemplate;

    public CommentsDAOImpl() {
        this.restTemplate = new RestTemplateBuilder().build();

    }

    private ParameterizedTypeReference<List<CommentRestEntity>> getParameterizedTypeReferenceComment() {
        return new ParameterizedTypeReference<List<CommentRestEntity>>() {
        };
    }

    ;

    @Override
    public List<CommentRestEntity> getRestData() {

        ResponseEntity<List<CommentRestEntity>> response = restTemplate.exchange(
                restURL,
                HttpMethod.GET,
                null,
                getParameterizedTypeReferenceComment()
        );

        List<CommentRestEntity> commentList = response.getBody();
        return commentList;

    }

    @Override
    public CommentRestEntity getSingleComment(int id) {
        ResponseEntity<CommentRestEntity> comment = restTemplate.getForEntity(restURL + '/' + id, CommentRestEntity.class);
        return comment.getBody();
    }
}
