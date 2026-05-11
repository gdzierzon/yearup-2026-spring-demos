package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTests
{
    @Test
    public void constructor_shouldCreate_sortedDeck()
    {
        // arrange
        int expectedCardCount = 52;
        Suits expectedSuit = Suits.Spades;
        String expectedFace = "A";

        // act
        Deck deck = new Deck();

        // assert
        assertEquals(expectedCardCount, deck.getCardCount(), "because I created a new deck");
        Card card = deck.getCards().getFirst();
        assertEquals(expectedSuit, card.getSuit(), "because the deck has not been shuffled");
        assertEquals(expectedFace, card.getFaceValue(), "because the deck has not been shuffled");
    }

    @Test
    public void shuffle_shouldShuffle_cardsInTheDeck()
    {

        // arrange
        Deck deck = new Deck();
        Card originalCard = deck.getCards().getFirst();

        // act
        deck.shuffle();

        // assert
        Card newCard = deck.getCards().getFirst();
        assertNotEquals(originalCard, newCard, "because I shuffled the deck");
    }

    @Test
    public void takeTopCard_should_removeCardFromDeck()
    {
        // arrange
        Deck deck = new Deck();
        deck.shuffle();

        // act
        Card card = deck.takeTopCard();

        // assert
        assertEquals(51, deck.getCardCount(), "because I took a card from the deck");
        assertFalse(deck.getCards().contains(card), "because I took the card from the deck");
    }

}