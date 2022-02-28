package com.example.demo.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer randy = new Customer(
                    "Randy Trullet",
                    "password",
                    1L,
                    "address",
                    1L);

            Customer steve = new Customer(
                    "Steve",
                    "password2",
                    2L,
                    "address2",
                    2L);

            repository.saveAll(List.of(randy, steve));
        };
    }
}
