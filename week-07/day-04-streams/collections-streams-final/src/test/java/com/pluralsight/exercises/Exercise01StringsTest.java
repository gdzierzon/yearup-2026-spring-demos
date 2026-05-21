package com.pluralsight.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise01StringsTest
{
    Exercise01Strings exercises = new Exercise01Strings();

    @Test
    void getCountOfNames()
    {
        // arrange
        int expected = 72;

        // act
        var actual = exercises.getCountOfNames();

        // assert
        Assertions.assertEquals(expected, actual, "there should not have been any names filtered out.");
    }

    @Test
    void getNamesThatStartWith()
    {
        // arrange
        String firstLetter = "e";
        int expected = 8;

        // act
        var results = exercises.getNamesThatStartWith(firstLetter);

        // assert
        Assertions.assertEquals(expected, results.size());
    }

    @Test
    void getSortedNames()
    {
        // arrange
        String expected = "Abigail";

        // act
        var result = exercises.getSortedNames();

        // assert
        var actual = result.get(0);
        Assertions.assertEquals(expected, actual, "The list should have been sorted.");
    }

    @Test
    void getReverseSortedNames()
    {
        // arrange
        String expected = "Wyatt";

        // act
        var result = exercises.getReverseSortedNames();

        // assert
        var actual = result.get(0);
        Assertions.assertEquals(expected, actual, "The list should have been sorted.");
    }

    @Test
    void getLengthOfLongestName()
    {
        // arrange
        int expected = 9;

        // act
        var actual = exercises.getLengthOfLongestName();

        // assert
        Assertions.assertEquals(expected, actual, "The list should have been sorted.");
    }

    @Test
    void getLongestNames()
    {
        // arrange
        int expected = 4;

        // act
        var actual = exercises.getLongestNames();

        // assert
        Assertions.assertEquals(expected, actual.size(), "Should have been filtered for names with 9 letters");
    }

    @Test
    void getNamesLongerThan()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getNamesShorterThan()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getFirstNameAlphabetically()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getLastNameAlphabetically()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getFirstFiveNamesAlphabetically()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getLastFiveNameAlphabetically()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getUppercaseNames()
    {
        // arrange

        // act

        // assert
    }

    @Test
    void getLowercaseNames()
    {
        // arrange

        // act

        // assert
    }
}