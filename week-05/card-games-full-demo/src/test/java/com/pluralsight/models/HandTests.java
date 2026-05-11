package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandTests
{
    private Card spadesAce = new Card(Suits.Spades, "A");
    private Card heartsTen = new Card(Suits.Hearts, "10");
    private Card diamondsThree = new Card(Suits.Diamonds, "3");
    private Card clubsJack = new Card(Suits.Clubs, "J");


    @Test
    public void deal_should_addCardToHand()
    {
        // arrange
        Hand hand = new Hand();
        int expectedCardCount = 2;
        hand.deal(spadesAce);
        hand.deal(diamondsThree);

        // act
        ArrayList<Card> cards = hand.getCards();

        // assert
        assertEquals(expectedCardCount, cards.size(), "because the hand was dealt 2 cards");
        assertTrue(cards.contains(spadesAce), "because the hand was deal the Ace of Spades");
        assertTrue(cards.contains(diamondsThree), "because the hand was deal the Three of Diamonds");
    }

    @Test
    public void getHandValue_shouldReturn_sumOfAllCardPoints()
    {
        // arrange
        Hand hand = new Hand();
        hand.deal(spadesAce);
        hand.deal(diamondsThree);
        int expectedPoints = 14;

        // act
        int actualPoints = hand.getHandValue();

        // assert
        assertEquals(expectedPoints, actualPoints, "because the hand was dealt an Ace and a 3");
    }

}