package org.ryank.demo.client.user;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import javax.validation.constraints.NotNull;
import org.ryank.demo.client.user.schema.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class UsersClient {

  private final RestTemplate restTemplate = new RestTemplate();
  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/users/";

  @GraphQLQuery
  public User getUser(@NotNull @GraphQLArgument(name = "id") Integer id) {
    return restTemplate.getForEntity(BASE_URI_PATH + id, User.class).getBody();
  }
}
