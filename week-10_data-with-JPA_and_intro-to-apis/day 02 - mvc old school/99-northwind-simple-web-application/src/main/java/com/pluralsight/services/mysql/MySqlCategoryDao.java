package com.pluralsight.services.mysql;

import com.pluralsight.models.Category;
import com.pluralsight.services.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class MySqlCategoryDao implements CategoryDao
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlCategoryDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Category> getCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = """
            SELECT CategoryID
                , CategoryName
                , Description
            FROM categories
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            Category category = mapRowToCategory(row);
            categories.add(category);
        }

        return categories;
    }

    public Category getCategory(int categoryId)
    {
        String sql =
                """
            SELECT CategoryID
                , CategoryName
                , Description
            FROM categories
            WHERE CategoryID = ?
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        if(row.next())
        {
            Category category = mapRowToCategory(row);
            return category;
        }

        return null;
    }

    public void addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories (CategoryName, Description)
                VALUES (?,?)
                """;

        jdbcTemplate.update(sql
                , category.getCategoryName()
                , category.getDescription());
    }

    public void updateCategory(Category category)
    {
        String sql = """
                UPDATE categories
                SET CategoryName = ?
                    , Description = ?
                WHERE CategoryID = ?
                """;

        jdbcTemplate.update(sql
                , category.getCategoryName()
                , category.getDescription()
                , category.getCategoryId());
    }

    public void deleteCategory(int categoryId)
    {
        String sql = """
                DELETE FROM categories
                WHERE CategoryID = ?
                """;

        jdbcTemplate.update(sql, categoryId);
    }

    private Category mapRowToCategory(SqlRowSet row)
    {
        int categoryId = row.getInt("CategoryID");
        String categoryName = row.getString("CategoryName");
        String description = row.getString("Description");

        return new Category(categoryId, categoryName, description);
    }
}
