package com.pluralsight.io;

import com.pluralsight.models.Metal;
import com.pluralsight.models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductsFileManager
{
    public static ArrayList<Product> loadProducts()
    {
        // create the ArrayList
        ArrayList<Product> products = new ArrayList<>();


        // try with resources
        try (
                FileReader fileReader = new FileReader("data/products.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {


            // skip the first line - which is the header
            String line = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null)
            {
                // split the line into an array of strings
                String[] fields = line.split(",");
                int productId = Integer.parseInt(fields[0]);
                String name = fields[1];
                BigDecimal price = new BigDecimal(fields[2]);

                // create a Metal object
                Product product = new Product(productId, name, price);

                products.add(product);
            }

        }
        catch (Exception e)
        {
            System.err.println("There was a problem reading the file: " + e.getMessage());
        }


        // return the ArrayList
        return products;
    }
}
