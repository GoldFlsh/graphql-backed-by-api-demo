package org.ryank.demo.client;

import org.ryank.demo.graphql.schema.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class UsersClient {

  private final RestTemplate restTemplate = new RestTemplate();
  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/users/";

  public User getById(int userId) {
    return restTemplate.getForEntity(BASE_URI_PATH + userId, User.class).getBody();
  }
}
