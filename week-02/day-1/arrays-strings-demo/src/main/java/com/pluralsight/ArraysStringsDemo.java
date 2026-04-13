package com.pluralsight;

public class ArraysStringsDemo
{
    static void main()
    {
        int age = 32;
        int[] ages = new int[12];
        double[] prices = new double[5];
        char letter = 'a';// `abcdef` 'abcdef'
        char[] letters = {'a','b','c','d','e','f'};


        char[] firstName = {'G','r','e','g','o','r'};
        //String name = "Gregor";
        String name;
        name = new String("Gregor");
        String nameUpper = name.toUpperCase();
        boolean nameStartsWithG = name.startsWith("g");

        System.out.println(name);
        System.out.println(nameUpper);
        System.out.println(nameStartsWithG);

        System.out.println();

        String fileName = "catPhotos.JPG";
        boolean isJpg = fileName.toLowerCase()
                                .endsWith(".jpg");

        System.out.println(fileName);
        System.out.println("is a JPG: " + isJpg);

        // page 11 in book
        String productCode = "Mens-M-595";
        // what is the size of this product?
        // indexOf
        int firstDashPosition = productCode.indexOf("-");
        System.out.println(firstDashPosition);

        int startPosition = firstDashPosition + 1;
        String sizeLetter = productCode.substring(startPosition, startPosition + 1);
        System.out.println(sizeLetter);

        int lastDashPosition = productCode.lastIndexOf("-");
        String price = productCode.substring(lastDashPosition + 1);
        System.out.println("Price: " + price);

        // String.split()
        String input = "Dallas|Ft, Worth|Austin";
        String[] cities = input.split("\\|");

        String first, second, third = "";

        first = cities[0];
        second = cities[1];
        if(cities.length > 2)
        {
            third = cities[2];
        }

        System.out.println(first);
        System.out.println(second);
        if(cities.length > 2)
        {
            System.out.println(third);
        }


    }
}
