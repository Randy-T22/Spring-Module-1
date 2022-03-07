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
                    1,
                    "address",
                    1);

            Customer steve = new Customer(
                    "Steve",
                    "password2",
                    2,
                    "address2",
                    2);

            repository.saveAll(List.of(randy, steve));
        };
    }
}
