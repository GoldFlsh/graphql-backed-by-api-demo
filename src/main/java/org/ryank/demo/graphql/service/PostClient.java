package org.ryank.demo.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.ryank.demo.graphql.schema.post.Post;
import org.ryank.demo.graphql.schema.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class PostClient {

  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/posts";

  private final RestTemplate restTemplate;

  @Autowired
  public PostClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Note if I wanted them both named 'posts' then I can implement this solution...
   * https://github.com/leangen/graphql-spqr/wiki/Errors#operation-with-multiple-resolver-methods-of-different-types
   *
   * See Comment to see example of combining into one method
   */

  @GraphQLQuery(name = "post")
  public Post getPost(@NotNull @GraphQLArgument(name = "id") Integer id, @GraphQLContext User user) {
    return restTemplate.getForEntity(BASE_URI_PATH + "/" + id + "?userId=" + user.getId(), Post.class).getBody();
  }

  @GraphQLQuery(name = "posts")
  public Collection<Post> getPostsByUser(@GraphQLContext User user) {
    return restTemplate.exchange(
        BASE_URI_PATH + "?userId=" + user.getId(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Post>>() {
        }
    ).getBody();
  }
}
