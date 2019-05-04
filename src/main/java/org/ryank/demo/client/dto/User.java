package org.ryank.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class User {

  private final Integer id;
  private final String name;
  private final String username;
  private final String email;
  private final Address address;
  private final String phone;
  private final String website;
  private final Company company;

  public static User jsonToPojo(String json) throws IOException {
    return new ObjectMapper().readerFor(User.class).readValue(json);
  }
}
