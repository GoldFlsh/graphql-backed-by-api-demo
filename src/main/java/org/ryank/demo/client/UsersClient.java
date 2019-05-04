package org.ryank.demo.client;

import org.ryank.demo.client.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
class UsersClient {

  private final RestTemplate restTemplate = new RestTemplate();
  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/users/";

  User getById(int userId) {
    return restTemplate.getForEntity(BASE_URI_PATH + userId, User.class).getBody();
  }
}
