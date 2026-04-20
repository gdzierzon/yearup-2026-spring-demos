package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LIstProducts
{
    static void main()
    {
        try
        {
            // 1) open the file
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            // skip the first line - and read again
            line = reader.readLine();
            while(line != null)
            {
                // 2) read the contents of the file
                String[] columns = line.split("\\|");

                String sku = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                String department = columns[3];

                Product product = new Product(sku, name, price, department);

                System.out.println(product.getName() + " costs $" + product.getPrice());


                // read the next line until nothing is left to read
                line = reader.readLine();
            }

            // 3) close the file
            reader.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
