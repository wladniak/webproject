package pl.wla.webproject.repository.restsource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentRestEntity {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
