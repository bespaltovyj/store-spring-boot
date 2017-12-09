package com.epam.course.store.controller;

import com.epam.course.store.configuration.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestMapping("/property")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller
public class PropertyController {

    private final TestConfiguration testConfiguration;

    @Autowired
    public PropertyController(TestConfiguration testConfiguration) {
        this.testConfiguration = testConfiguration;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok(testConfiguration.getStr());
    }
}
