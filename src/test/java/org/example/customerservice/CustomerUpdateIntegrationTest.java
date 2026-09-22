package org.example.customerservice;

import org.example.customerservice.dto.CustomerDTO;
import org.example.customerservice.entity.CustomerEntity;
import org.example.customerservice.repositories.CustomerRepository;
import org.example.customerservice.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerUpdateIntegrationTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    void updateCustomer_changesArePersisted() {
        CustomerEntity saved = customerRepository.save(
                new CustomerEntity("Mai", "mai@test.se", "0701234567")
        );

        CustomerDTO update = new CustomerDTO();
        update.setId(saved.getId());
        update.setName("Mai Do");
        update.setEmail("maido@test.se");
        update.setTel("0709999999");

        customerService.updateCustomer(update);

        CustomerEntity updated = customerRepository.findById(saved.getId()).orElseThrow();
        assertEquals("Mai Do", updated.getName());
        assertEquals("maido@test.se", updated.getEmail());
        assertEquals("0709999999", updated.getTel());
    }

}