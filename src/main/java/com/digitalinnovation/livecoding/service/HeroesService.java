package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
@Slf4j
public class HeroesService {

    @Autowired
    private HeroesRepository heroesRepository;

    public Flux<Heroes> findAll() {
        log.info("requesting the list off all heroes");
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public ResponseEntity<Mono<Heroes>> findByIdHero(String id) {
        log.info("Requesting the hero with id {}", id);
        Optional<Heroes> optional = this.heroesRepository.findById(id);
        return optional.map(heroes -> ResponseEntity.ok().body(Mono.justOrEmpty(heroes)))
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Mono<Heroes> save(Heroes heroes) {
        log.info("A new Hero was Created");
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<HttpStatus> deleteByIDHero(String id) {
        log.info("Deleting the hero with id {}", id);
        heroesRepository.deleteById(id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}

