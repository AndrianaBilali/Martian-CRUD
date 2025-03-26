package com.example.MartianCRUD.controller;

import com.example.MartianCRUD.model.Resource;
import com.example.MartianCRUD.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    // Create or Update Resource
    @PostMapping
    public ResponseEntity<Resource> addOrUpdateResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceRepository.save(resource));
    }

    // Get all Resources
    @GetMapping
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    // Get Resource by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        return resourceRepository.findById(id)
                .map(resource -> ResponseEntity.ok(resource))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        return resourceRepository.findById(id)
                .map(resource -> {
                    resourceRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();  // Explicitly specify Void here
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}