package com.pluralsight.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<>();

        Suits[] suits = {Suits.Spades, Suits.Diamonds, Suits.Hearts, Suits.Clubs};
        String[] faces = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};

        for(Suits suit : suits)
        {
            for (String face : faces)
            {
                cards.add(new Card(suit, face));
            }
        }
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getCardCount()    {
        return cards.size();
    }

    public Card takeTopCard()
    {
        return cards.removeFirst();
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
