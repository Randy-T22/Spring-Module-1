package com.example.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT s FROM Customer s WHERE s.id = ?1")
    Optional<Customer> findById(Long id);

    @Query("SELECT s FROM Customer s WHERE s.name = ?1")
    Optional<Customer> getNames(String id);


}
