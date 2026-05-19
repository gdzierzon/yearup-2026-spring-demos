package com.pluralsight;

import com.pluralsight.models.Vehicle;
import com.pluralsight.models.pairs.IntegerPair;
import com.pluralsight.models.pairs.Pair;
import com.pluralsight.models.pairs.music.Musician;
import com.pluralsight.models.pairs.music.Trumpeteer;
import com.pluralsight.models.pairs.music.Violinist;

import java.util.ArrayList;
import java.util.Map;

public class Main
{

    static void main()
    {
        IntegerPair pairONumbers = new IntegerPair(15,12);
        System.out.println(pairONumbers.getLeftNumber() + " : " + pairONumbers.getRightNumber());
        pairONumbers.swap();
        System.out.println(pairONumbers.getLeftNumber() + " : " + pairONumbers.getRightNumber());

//        System.out.println();
//        Pair<String> pair = new Pair<>("Omar", "Nathan");
//        System.out.println(pair.getLeft() + " : " + pair.getRight());
//        pair.swap();
//        System.out.println(pair.getLeft() + " : " + pair.getRight());

        System.out.println();
        Pair<Musician> duet = new Pair<>(new Violinist(), new Trumpeteer());
        duet.perform();
        duet.swap();
        duet.perform();


    }

    public static void arrayListDemo()
    {
        ArrayList<Vehicle> list = new ArrayList<>();

//        list.add("Gregor");
//        list.add(21);
        list.add(new Vehicle("Ford", "Expedition"));

        for (Vehicle item : list)
        {

            System.out.println(item.getMake());
        }
    }
}
