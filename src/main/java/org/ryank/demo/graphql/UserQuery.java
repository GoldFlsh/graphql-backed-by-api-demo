package org.ryank.demo.graphql;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.schema.DataFetchingEnvironment;
import javax.validation.constraints.NotNull;
import org.ryank.demo.client.UsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@GraphQLName(value = "query")
public class UserQuery {

  private final UsersClient client;

  @Autowired
  public UserQuery(UsersClient client) {
    this.client = client;
  }

  @GraphQLField
  public User findUser(final DataFetchingEnvironment env,
      @NotNull @GraphQLName("id") final int id) {
    client.getById(id);
  }

}
