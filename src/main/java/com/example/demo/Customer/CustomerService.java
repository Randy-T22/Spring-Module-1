package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerBySSN = customerRepository.findCustomerBySSN(customer.getSSN());
        if(customerBySSN.isPresent()){
            throw new IllegalStateException("Customer already in database.");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Customer with id " + id + " does not exist");
        }
        customerRepository.deleteById(id);
    }

    @Transactional
    public void updateCustomer(Long id,
                              String name) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
    }
}
