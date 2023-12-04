package pl.wla.webproject.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRestDTO {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
