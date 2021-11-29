package com.digitalinnovation.livecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;

@SpringBootApplication
@EnableDynamoDBRepositories // Spring use as configurações configuradas do DynamoDB
public class HeroesApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(HeroesApiApplication.class, args);
        System.out.println("Super poderes com webflux!");
    }

}

