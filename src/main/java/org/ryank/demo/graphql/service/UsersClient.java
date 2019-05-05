package org.ryank.demo.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.ryank.demo.graphql.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class UsersClient {

  private static final String BASE_URI_PATH = "/users";

  private final RestTemplate restTemplate;

  @Autowired
  public UsersClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GraphQLQuery
  public User getUser(@GraphQLNonNull @GraphQLArgument(name = "id") Integer id) {
    return restTemplate.getForEntity(BASE_URI_PATH + "/" + id, User.class).getBody();
  }

  @GraphQLMutation
  public User updateUser(@GraphQLNonNull @GraphQLArgument(name = "id") Integer id,
      @GraphQLNonNull @GraphQLArgument(name = "username") String username) {
    User user = getUser(id).withUsername(username);
    return restTemplate.postForEntity("/users", user, User.class).getBody();
  }
}
