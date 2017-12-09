package com.epam.course.store.controller;

import com.epam.course.store.domain.Order;
import com.epam.course.store.repository.OrderRepository;
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

@RequestMapping("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller
public class OrderController {
    
    private final OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") int id) {
        Order entity = repository.findOne(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Order> delete(@PathVariable("id") int id) {
        if (!repository.exists(id)) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Order> post(@RequestBody Order entity) {
        if (repository.exists(entity.getId())) {
            return ResponseEntity.badRequest().build();
        }
        repository.save(entity);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(String.valueOf(entity.getId())).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping
    public ResponseEntity<Order> put(@RequestBody Order entity) {
        if (entity == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(entity));
    }
}
