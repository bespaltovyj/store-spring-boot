package com.epam.course.store.controller;

import com.epam.course.store.domain.ItemBalance;
import com.epam.course.store.repository.ItemBalanceRepository;
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

@RequestMapping("/item-balance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller
public class ItemBalanceController {

    private final ItemBalanceRepository repository;

    @Autowired
    public ItemBalanceController(ItemBalanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ItemBalance>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemBalance> get(@PathVariable("id") int id) {
        ItemBalance entity = repository.findOne(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ItemBalance> delete(@PathVariable("id") int id) {
        if (!repository.exists(id)) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ItemBalance> post(@RequestBody ItemBalance entity) {
        if (repository.exists(entity.getId())) {
            return ResponseEntity.badRequest().build();
        }
        repository.save(entity);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(String.valueOf(entity.getId())).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @PutMapping
    public ResponseEntity<ItemBalance> put(@RequestBody ItemBalance entity) {
        if (entity == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(entity));
    }
}
