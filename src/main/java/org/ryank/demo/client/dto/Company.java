package org.ryank.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
class Company {
  private final String name;
  private final String catchPhrase;
  private final String bs; //I can't tell what bs is but it's in the dummy data
}
