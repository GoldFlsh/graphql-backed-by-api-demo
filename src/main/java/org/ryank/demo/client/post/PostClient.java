package org.ryank.demo.client.post;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.ryank.demo.client.post.schema.Post;
import org.ryank.demo.client.user.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GraphQLQuery(name = "post")
  public Post getPostByUser(@GraphQLContext User user) {
    return restTemplate.getForEntity(BASE_URI_PATH + "?userId="+user.getId() , Post.class).getBody();
  }
}
