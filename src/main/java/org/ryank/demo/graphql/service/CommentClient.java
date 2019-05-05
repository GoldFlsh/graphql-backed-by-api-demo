package org.ryank.demo.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.ryank.demo.graphql.schema.Comment;
import org.ryank.demo.graphql.schema.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class CommentClient {

  private static final String BASE_URI_PATH = "/comments";

  private final RestTemplate restTemplate;

  @Autowired
  public CommentClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GraphQLQuery(name = "comments")
  public Collection<Comment> getComments(@GraphQLArgument(name = "email") String email, @GraphQLContext Post post) {
    return restTemplate.exchange(
        buildUriFromParams(email, post),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Set<Comment>>() {
        }
    ).getBody();
  }

  private String buildUriFromParams(String email, Post post) {
    return BASE_URI_PATH + emailUriParam(email) + "&" + postUriParam(post);
  }

  private String emailUriParam(String email) {
    return Optional.ofNullable(email)
        .map(o -> "?email=" + email)
        .orElse("");
  }


  private String postUriParam(Post post) {
    return "?postId=" + post.getId();
  }
}
