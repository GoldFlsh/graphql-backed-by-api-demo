package org.ryank.demo.client.schema.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.ryank.demo.client.schema.comment.Comment;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Post {

  private Integer id;
  private String title;
  private String body;
  private List<Comment> comments;
}