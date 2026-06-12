package com.pluralsight.controllers;

// all requests related to Categories will
// be handled by THIS controller

import com.pluralsight.models.Category;
import com.pluralsight.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController
{
    private CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService)
    {
        this.categoriesService = categoriesService;
    }


    @GetMapping("")
    public ResponseEntity<List<Category>> getAll()
    {
        var categories = categoriesService.findAllCategories();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getById(@PathVariable int id)
    {
        var category = categoriesService.findCategoryById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        var newCategory = categoriesService.addCategory(category);

        URI location = URI.create("/categories/" + category.getCategoryId());

        return ResponseEntity.created(location).body(newCategory);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Category category)
    {
        categoriesService.updateCategory(id, category);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        categoriesService.deleteCategory(id);

        return ResponseEntity.noContent().build();
    }
}
