package com.talent.talent.company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompanyConfig {

    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository repository){
        return args -> {
            Company amazon = new Company(
                    "Amazon",
                    "a company",
                    "www.amazon.com"
            );
            Company google = new Company(
                    "Google",
                    "a company",
                    "www.google.com"
            );
            Company linkedin = new Company(
                    "LinkedIn",
                    "a company",
                    "www.linkedin.com"
            );

            repository.saveAll(
                    List.of(amazon, google, linkedin)
            );
        };
    }
}
