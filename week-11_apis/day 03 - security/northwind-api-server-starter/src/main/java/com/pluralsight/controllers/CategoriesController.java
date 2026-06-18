package com.pluralsight.controllers;

// all requests related to Categories will
// be handled by THIS controller

import com.pluralsight.models.Category;
import com.pluralsight.models.ErrorResponse;
import com.pluralsight.services.CategoriesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/categories")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CategoriesController
{
    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService)
    {
        this.categoriesService = categoriesService;
    }


    @GetMapping("")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> findAll(HttpServletRequest request)
    {
        try
        {
            var categories = categoriesService.findAllCategories();

            return ResponseEntity.ok(categories);
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> findById(@PathVariable int id)
    {
        try
        {
            var category = categoriesService.findCategoryById(id);

            if (category.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "The category does not exist");
                error.addMessage("categoryId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(category.get());
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody Category category)
    {
        try
        {
            // don't allow duplicates
            var existing = categoriesService.findCategoriesByName(category.getCategoryName());
            if (!existing.isEmpty())
            {
                var error = ErrorResponse.get400();
                error.addMessage("message", "Invalid new Category.");
                error.addMessage("reason", "A category with that name already exists.");
                error.addMessage("new category", category);
                error.addMessage("existing category", existing);

                return ResponseEntity.badRequest().body(error);
            }

            var newCategory = categoriesService.addCategory(category);

            URI location = URI.create("/categories/" + category.getCategoryId());
            return ResponseEntity.created(location).body(newCategory);
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Category category)
    {
        try
        {
            var existingCategory = categoriesService.findCategoryById(id);

            if (existingCategory.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Update failed: The category does not exist");
                error.addMessage("categoryId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoriesService.updateCategory(id, category);

            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable int id)
    {

        try
        {
            var existingCategory = categoriesService.findCategoryById(id);

            if (existingCategory.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Delete failed: The category does not exist");
                error.addMessage("categoryId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoriesService.deleteCategory(id);

            // noContent = status 204
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }

    }
}
