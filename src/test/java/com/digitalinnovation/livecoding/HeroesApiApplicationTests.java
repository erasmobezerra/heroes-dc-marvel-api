package com.digitalinnovation.livecoding;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovation.livecoding.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    HeroesRepository heroesRepository;

    @Test
    public void getOneHeroeById() {
        // Verifica se retorna status 200 ok caso insira um ID existente
        webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "2")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    public void getAllHeroes() {
        // Verifica se retorna status 200 ok caso insira um ID existente
        webTestClient.get().uri(HEROES_ENDPOINT_LOCAL)
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    public void getOneHeronotFound() {
        // Verificar se, procurar um ID inexistente no DynamoDB, retorna status NOTFOUND
        webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "19")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void deleteHero() {
        // Verifica se, ao deletar um ID existente, retorna status NOTFOUND
        webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "5")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }

}


