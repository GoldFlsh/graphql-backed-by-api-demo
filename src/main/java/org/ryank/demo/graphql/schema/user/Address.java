package org.ryank.demo.graphql.schema.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Address {

  private String suite;
  private String city;
  private String zipcode;
  private GeoCoords geo;
}
