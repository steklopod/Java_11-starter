package ru.steklopod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@AutoConfigureMockMvc
//@TestInstance(PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
//        (webEnvironment = RANDOM_PORT)
class UserControllerTest {
    //    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private WebTestClient webTestClient;

//    @BeforeAll
//    void setup() {
//        System.err.println("Startin Controller test");
//    }

    @Test
//    @DisplayName("\uD83D\uDC7F \uD83D\uDC7F \uD83D\uDC7F")
    void testGreeting() throws Exception {
//        webTestClient.get()
//                .uri("/")
//                .exchange()
//                .expectStatus().is2xxSuccessful();
//                .expectBody(content().string(containsString("Привет")))
    }

}
