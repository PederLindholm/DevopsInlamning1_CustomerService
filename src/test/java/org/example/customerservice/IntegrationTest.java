package org.example.customerservice;

import org.example.customerservice.dto.CustomerDTO;
import org.example.customerservice.entity.CustomerEntity;
import org.example.customerservice.repositories.CustomerRepository;
import org.example.customerservice.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class IntegrationTest {

    @Mock
    private CustomerRepository mockCustomerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findCustomerById(){
        CustomerEntity customerEntity = new CustomerEntity();
        when(mockCustomerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        CustomerDTO result = customerService.getCustomerById(1L);
        assertNotNull(result);
    }

}
