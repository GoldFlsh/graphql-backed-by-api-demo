package org.ryank.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
class Address {

  private String suite;
  private String city;
  private String zipcode;
  private GeoCoords geo;
}
