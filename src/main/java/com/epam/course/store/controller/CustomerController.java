package com.epam.course.store.controller;


import com.epam.course.store.domain.Customer;
import com.epam.course.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RequestMapping("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("idGreaterThan")
    public ResponseEntity<List<Customer>> findCustomersByIdGreaterThan(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(repository.findCustomersByIdGreaterThan(id));
    }

    @GetMapping("byFirstName")
    public ResponseEntity<List<Customer>> findCustomersByFirstName(@RequestParam(value = "firstName") String firstName) {
        return ResponseEntity.ok(repository.findCustomersByFirstName(firstName));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> get(@PathVariable("id") int id) {
        Customer entity = repository.findOne(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") int id) {
        if (!repository.exists(id)) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {
        if (repository.exists(customer.getId())) {
            return ResponseEntity.badRequest().build();
        }
        repository.save(customer);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(String.valueOf(customer.getId())).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping
    public ResponseEntity<Customer> put(@RequestBody Customer customer) {
        if (customer == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(customer));
    }

}
