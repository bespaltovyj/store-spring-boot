package com.epam.course.store.controller;

import com.epam.course.store.domain.Item;
import com.epam.course.store.repository.ItemRepository;
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

@RequestMapping("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller
public class ItemController {

    private final ItemRepository repository;

    @Autowired
    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> get(@PathVariable("id") int id) {
        Item entity = repository.findOne(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") int id) {
        if (!repository.exists(id)) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Item> post(@RequestBody Item entity) {
        if (repository.exists(entity.getId())) {
            return ResponseEntity.badRequest().build();
        }
        repository.save(entity);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(String.valueOf(entity.getId())).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping
    public ResponseEntity<Item> put(@RequestBody Item entity) {
        if (entity == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(entity));
    }
}
