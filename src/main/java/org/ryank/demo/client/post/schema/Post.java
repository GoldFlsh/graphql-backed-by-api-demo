package org.ryank.demo.client.post.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Post {

  private Integer id;
  private String title;
  private String body;
}