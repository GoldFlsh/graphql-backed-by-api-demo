package org.ryank.demo.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import javax.validation.constraints.NotNull;
import org.ryank.demo.graphql.schema.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class UsersClient {

  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/users";

  private final RestTemplate restTemplate;

  @Autowired
  public UsersClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GraphQLQuery
  public User getUser(@NotNull @GraphQLArgument(name = "id") Integer id) {
    return restTemplate.getForEntity(BASE_URI_PATH + "/" + id, User.class).getBody();
  }
}
