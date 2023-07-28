package com.example.h2customerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CustomerDTO> getAllInfo(@RequestBody CustomerDTO dto) {
        customerRepository.save(new Customer(null, dto.getFirstName(), dto.getLastName(), dto.getAddress(),
                dto.getPhoneNumber(), dto.getEmail()));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        customerRepository.findCustomerById(id);
        return new ResponseEntity<>(customerRepository.findCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> deleteCustomer (@PathVariable Integer id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Customer with ID: '" + id + "' has been successfully deleted.", HttpStatus.OK);
    }

}
