package org.ryank.demo.graphql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ryank.demo.graphql.schema.User;
import org.ryank.demo.graphql.service.UsersClient;
import org.springframework.web.client.RestTemplate;

class UsersClientTest {

  private UsersClient usersClient = new UsersClient(new RestTemplate());

  @Test
  @DisplayName("getUser should get the specified user matching the id")
  void getUserById() throws IOException {
    User user = usersClient.getUser(1);
    assertThat(user, is(User.jsonToPojo(FULL_USER_DATA_FOR_USER_1)));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  @DisplayName("UsersClient should return a user that matches requested id")
  void getUserByIdParams(int userId) {
    User user = usersClient.getUser(userId);
    assertThat(user.getId(), is(userId));
  }

  private static final String FULL_USER_DATA_FOR_USER_1 = "  {\n"
      + "    \"id\": 1,\n"
      + "    \"name\": \"Leanne Graham\",\n"
      + "    \"username\": \"Bret\",\n"
      + "    \"email\": \"Sincere@april.biz\",\n"
      + "    \"address\": {\n"
      + "      \"street\": \"Kulas Light\",\n"
      + "      \"suite\": \"Apt. 556\",\n"
      + "      \"city\": \"Gwenborough\",\n"
      + "      \"zipcode\": \"92998-3874\",\n"
      + "      \"geo\": {\n"
      + "        \"lat\": \"-37.3159\",\n"
      + "        \"lng\": \"81.1496\"\n"
      + "      }\n"
      + "    },\n"
      + "    \"phone\": \"1-770-736-8031 x56442\",\n"
      + "    \"website\": \"hildegard.org\",\n"
      + "    \"company\": {\n"
      + "      \"name\": \"Romaguera-Crona\",\n"
      + "      \"catchPhrase\": \"Multi-layered graphql-server neural-net\",\n"
      + "      \"bs\": \"harness real-time e-markets\"\n"
      + "    }\n"
      + "  }";
}