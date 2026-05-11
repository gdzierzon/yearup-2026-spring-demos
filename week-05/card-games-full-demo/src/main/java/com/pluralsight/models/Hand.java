package com.pluralsight.models;

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public void deal(Card card)
    {
        cards.add(card);
    }

    public int getHandValue()
    {
        int value = 0;

        for(Card card: cards)
        {
            value += card.getPointValue();
        }

        return value;
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getCardCount()
    {
        return cards.size();
    }
}
