package org.ryank.demo.graphql.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ryank.demo.graphql.schema.User;

class UserTest {

  private final String exampleUserJson = "  {"
      + "    \"id\": 1,"
      + "    \"name\": \"Leanne Graham\","
      + "    \"username\": \"Bret\","
      + "    \"email\": \"Sincere@april.biz\","
      + "    \"address\": {"
      + "      \"street\": \"Kulas Light\","
      + "      \"suite\": \"Apt. 556\","
      + "      \"city\": \"Gwenborough\","
      + "      \"zipcode\": \"92998-3874\","
      + "      \"geo\": {"
      + "        \"lat\": \"-37.3159\","
      + "        \"lng\": \"81.1496\""
      + "      }"
      + "    },"
      + "    \"phone\": \"1-770-736-8031 x56442\","
      + "    \"website\": \"hildegard.org\","
      + "    \"company\": {"
      + "      \"name\": \"Romaguera-Crona\","
      + "      \"catchPhrase\": \"Multi-layered graphql-server neural-net\","
      + "      \"bs\": \"harness real-time e-markets\""
      + "    }"
      + "  }";

  @Test
  @DisplayName("User.jsonToPojo should return a deserialized user pojo")
  void serializationOfUserObject() throws IOException {
    User output = User.jsonToPojo(exampleUserJson);
    System.out.println(output);
    assertThat(output.getId(), is(1));
  }
}