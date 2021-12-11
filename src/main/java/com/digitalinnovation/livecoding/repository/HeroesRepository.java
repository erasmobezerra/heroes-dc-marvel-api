package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {
}
