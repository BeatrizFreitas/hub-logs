package br.com.hub.errors.integration;

import br.com.hub.errors.model.User;
import br.com.hub.errors.repository.UserDetailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndpointTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetailsRepository userDetailsRepository;

    @TestConfiguration
    static class Config{
        @Bean
        public RestTemplateBuilder restTemplateBuilder(){
            return new RestTemplateBuilder().basicAuthentication("randomUser", "@passwordUser");
        }
    }

    @Test
    public void listUsersWhenUsernameAndPasswordAreIncorrectShouldReturnStatusCode401(){
        testRestTemplate = testRestTemplate.withBasicAuth("u","p");
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/user", String.class);
        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(401);
    }

    @Test
    public void listUsersWhenUsernameAndPasswordAreCorrectShouldReturnStatusCode200(){
        List<User> usersList = asList(new User(1, "Louise", "louise@gmail.com", "ADMIN"),
                new User(2, "Beatriz", "beatriz@gmail.com", "ADMIN"));
        BDDMockito.when(userDetailsRepository.findAll()).thenReturn(usersList);
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/user", String.class);
        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}

