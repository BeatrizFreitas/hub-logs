package br.com.hub.errors.integration;

import br.com.hub.errors.repository.UserDetailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
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
            return new RestTemplateBuilder().basicAuthentication("client-id", "secret-id");
        }
    }

    @Test
    public void listUsersWhenUsernameAndPasswordAreIncorrectShouldReturnStatusCode401(){
        testRestTemplate = testRestTemplate.withBasicAuth("1","1");
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/user", String.class);
        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(401);
    }
}

