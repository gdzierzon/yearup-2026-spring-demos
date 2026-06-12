package com.pluralsight.services;

import com.pluralsight.models.Category;
import com.pluralsight.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService
{
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository)
    {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> findAllCategories()
    {

        return categoriesRepository.findAll();
    }
}
