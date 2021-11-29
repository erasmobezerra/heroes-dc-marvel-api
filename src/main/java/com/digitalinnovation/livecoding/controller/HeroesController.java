package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
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
@Slf4j // O Simple Logging Facade for Java (SLF4J) serve como uma fachada simples
// ou abstração para várias estruturas de logs, ou seja, registros (por exemplo,
// java.util.logging, logback, log4j) permitindo que o usuário final conecte a
// estrutura de registro desejada no momento da implementação .
public class HeroesController {

    @Autowired // Ponto de injeção de dependência.
    HeroesService heroesService;

/*
  1) (A anotação do lombok "@SLF4J" substitui esta declaração:)
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroesController.class);

  2) (A anotação "@Autowired" torna não necessário este construtor:)
  public HeroesController(HeroesService heroesService) {
    this.heroesService = heroesService;
  }
*/

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes"); // Quando chamado o método, exibe no console a string
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id); // Quando chamado o método, exibe no console a string
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new Hero was Created");
        return heroesService.save(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
