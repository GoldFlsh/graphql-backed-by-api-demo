package org.ryank.demo.client.comment;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.ryank.demo.client.comment.schema.Comment;
import org.ryank.demo.client.post.schema.Post;
import org.ryank.demo.client.user.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class CommentClient {

  private static final String BASE_URI_PATH = "https://jsonplaceholder.typicode.com/comments";

  private final RestTemplate restTemplate;

  //TODO Use URI Builder pattern based on arguments that aren't null instead of crappy two methods

  @Autowired
  public CommentClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GraphQLQuery(name = "comments")
  public Collection<Comment> getComments(@GraphQLArgument(name = "email") String email, @GraphQLContext Post post) {
    return Optional.ofNullable(email)
        .map(o -> getComment(o, post))
        .orElse(getComments(post));
  }

  private Set<Comment> getComments(Post post) {
    return restTemplate.exchange(
        BASE_URI_PATH + "?postId=" + post.getId(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Set<Comment>>() {}
    ).getBody();
  }

  private Set<Comment> getComment(String email, Post post) {
    return restTemplate.exchange(
        BASE_URI_PATH + "?email=" + email + "&?postId=" + post.getId(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Set<Comment>>() {}
    ).getBody();
  }
}
