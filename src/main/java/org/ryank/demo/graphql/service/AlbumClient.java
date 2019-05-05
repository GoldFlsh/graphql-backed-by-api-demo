package org.ryank.demo.graphql.service;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.Collection;
import java.util.Set;
import org.ryank.demo.graphql.schema.Album;
import org.ryank.demo.graphql.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@GraphQLApi
@Service
public class AlbumClient {

  private static final String BASE_URI_PATH = "/albums";

  private final RestTemplate restTemplate;

  @Autowired
  public AlbumClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GraphQLQuery(name = "albums")
  public Collection<Album> getAlbums(@GraphQLContext User user) {
    return restTemplate.exchange(
        buildUriFromParams(user),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Set<Album>>() {
        }
    ).getBody();
  }

  private String buildUriFromParams(User user) {
    return BASE_URI_PATH + postUriParam(user);
  }

  private String postUriParam(User user) {
    return "?userId=" + user.getId();
  }
}
