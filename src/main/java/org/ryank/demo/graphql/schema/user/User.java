package org.ryank.demo.graphql.schema.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.ryank.demo.graphql.schema.post.Post;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class User {

  private Integer id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  List<Post> posts;

  public static User jsonToPojo(String json) throws IOException {
    return new ObjectMapper().readerFor(User.class).readValue(json);
  }
}
