package org.ryank.demo.graphql.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
class Company {
  private String name;
  private String catchPhrase;
  private String bs; //I can't tell what bs is but it's in the dummy data
}
