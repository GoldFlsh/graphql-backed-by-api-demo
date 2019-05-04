package org.ryank.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
class Address {

  private final String street;
  private final String suite;
  private final String city;
  private final String zipcode;
  private final GeoCoords geo;
}
