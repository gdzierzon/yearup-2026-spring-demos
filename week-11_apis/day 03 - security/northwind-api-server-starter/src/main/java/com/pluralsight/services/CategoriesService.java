package com.pluralsight.services;

import com.pluralsight.models.Category;
import com.pluralsight.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService
{
    CategoriesRepository repository;

    @Autowired
    public CategoriesService(CategoriesRepository repository)
    {
        this.repository = repository;
    }

    public List<Category> findAllCategories()
    {
        var categories = repository.findAll();

        return categories;
    }

    public Optional<Category> findCategoryById(int id)
    {
        var category = repository.findById(id);

        return category;
    }

    public List<Category> findCategoriesByName(String name)
    {
        var categories = repository.findAllByCategoryName(name);

        return categories;
    }

    public Category addCategory(Category category)
    {
        var newCategory = repository.save(category);

        return newCategory;
    }

    public Category updateCategory(int id, Category category)
    {
        Category newCategory = repository.findById(id).get();

        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setDescription(category.getDescription());

        return repository.save(newCategory);
    }

    public void deleteCategory(int id)
    {
        repository.deleteById(id);
    }
}
