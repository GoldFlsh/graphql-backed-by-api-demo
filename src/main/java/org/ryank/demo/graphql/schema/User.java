package org.ryank.demo.graphql.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
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
  List<Album> albums;

  public static User jsonToPojo(String json) throws IOException {
    return new ObjectMapper().readerFor(User.class).readValue(json);
  }
}
