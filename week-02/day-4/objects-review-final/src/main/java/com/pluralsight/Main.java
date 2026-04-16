package com.pluralsight;

public class Main
{
    private static Metal mercury = new Metal("Mercury", "Hg", 80, -38 ,674, "silvery");
    private static Metal gallium = new Metal("Gallium", "Ga", 31, 86, 3999, "silvery");
    private static Metal cesium = new Metal("Cesium", "Cs", 55, 83, 1240, "golden");
    private static Metal rubidium = new Metal("Rubidium", "Rb", 37, 103, 1274, "silvery");
    private static Metal potassium = new Metal("Potassium", "K", 19, 146, 1382, "silvery");
    private static Metal sodium = new Metal("Sodium", "Na", 11, 208, 1621, "silvery");
    private static Metal indium = new Metal("Indium", "In", 49, 314, 3762, "silvery");
    private static Metal tin = new Metal("Tin", "Sn", 50, 450, 4716, "silvery");
    private static Metal bismuth = new Metal("Bismuth", "Bi", 83, 520, 2847, "iridescent");
    private static Metal lead = new Metal("Lead", "Pb", 82, 621, 3182, "dull gray");
    private static Metal zinc = new Metal("Zinc", "Zn", 30, 787, 1665, "bluish silver");
    private static Metal magnesium = new Metal("Magnesium", "Mg", 12, 1202, 1994, "silvery");
    private static Metal aluminum = new Metal("Aluminum", "Al", 13, 1221, 4473, "silvery");
    private static Metal silver = new Metal("Silver", "Ag", 47, 1763, 3924, "silver");
    private static Metal gold = new Metal("Gold", "Au", 79, 1948, 5379, "gold");
    private static Metal copper = new Metal("Copper", "Cu", 29, 1984, 4652, "reddish");
    private static Metal nickel = new Metal("Nickel", "Ni", 28, 2651, 4915, "silvery");
    private static Metal cobalt = new Metal("Cobalt", "Co", 27, 2723, 5301, "bluish");
    private static Metal palladium = new Metal("Palladium", "Pd", 46, 2831, 5360, "silvery");
    private static Metal titanium = new Metal("Titanium", "Ti", 22, 3034, 5949, "gray");
    private static Metal platinum = new Metal("Platinum", "Pt", 78, 3215, 6917, "silvery");
    private static Metal chromium = new Metal("Chromium", "Cr", 24, 3465, 4840, "steel gray");
    private static Metal molybdenum = new Metal("Molybdenum", "Mo", 42, 4753, 8382, "gray");
    private static Metal tungsten = new Metal("Tungsten", "W", 74, 6192 ,10031, "gray");

    static void main()
    {

        displayMetalInfo(mercury);
        displayMetalInfo(zinc);
        displayMetalInfo(tungsten);
    }

    static void displayMetalInfo(Metal metal)
    {
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Name:         " + metal.getName());
        System.out.println("Melting Temp: " + metal.getMeltingPointF());
        System.out.println("Boiling Temp: " + metal.getBoilingPointF());
        System.out.println("Liquid State Range:   " + metal.getLiqudStateRange());
    }

}
