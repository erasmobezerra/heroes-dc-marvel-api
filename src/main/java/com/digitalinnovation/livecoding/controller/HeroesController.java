package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovation.livecoding.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j /* O Simple Logging Facade for Java (SLF4J) serve como uma fachada simples
          ou abstração para várias estruturas de logs, ou seja, registros (por exemplo,
          java.util.logging, logback, log4j) permitindo que o usuário final conecte a
          estrutura de registro desejada no momento da implementação.
        */
public class HeroesController {

    @Autowired // Ponto de injeção de dependência.
    HeroesService heroesService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllItems() {
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public ResponseEntity<Mono<Heroes>> findByIdHero(@PathVariable String id) {
        return heroesService.findByIdHero(id);
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIDHero(@PathVariable String id) {
        return heroesService.deleteByIDHero(id);
    }
}
