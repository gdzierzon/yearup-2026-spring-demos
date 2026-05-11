package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTests
{

    private Card spadesAce = new Card(Suits.Spades, "A");
    private Card heartsTen = new Card(Suits.Hearts, "10");
    private Card diamondsThree = new Card(Suits.Diamonds, "3");
    private Card clubsJack = new Card(Suits.Clubs, "J");

    @Test
    public void getScore_shouldReturn_valueOfPlayersHand()
    {
        // arrange
        Player player = new Player("Gregor");
        player.deal(spadesAce);
        player.deal(diamondsThree);
        int expectedPoints = 14;

        // act
        int actualPoints = player.getScore();

        // assert
        assertEquals(expectedPoints, actualPoints, "because the hand was dealt an Ace and a 3");
    }

}