package com.pluralsight.models;

import java.util.ArrayList;

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        hand = new Hand();
    }

    public String getName()
    {
        return name;
    }

    public int getCardCount()
    {
        return hand.getCardCount();
    }

    public int getScore()
    {
        return hand.getHandValue();
    }

    public void deal(Card card)
    {
        hand.deal(card);
    }

    public ArrayList<Card> getCards()
    {
        return hand.getCards();
    }
}
