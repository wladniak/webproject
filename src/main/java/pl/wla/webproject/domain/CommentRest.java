package pl.wla.webproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRest {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
