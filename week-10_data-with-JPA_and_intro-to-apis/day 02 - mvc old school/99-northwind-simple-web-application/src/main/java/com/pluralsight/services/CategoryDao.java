package com.pluralsight.services;

import com.pluralsight.models.Category;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;

public interface CategoryDao
{
    ArrayList<Category> getCategories();
    Category getCategory(int categoryId);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
}
