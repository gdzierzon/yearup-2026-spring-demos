package com.pluralsight.models.players;

import com.pluralsight.models.cards.Card;
import com.pluralsight.models.hands.BlackJackHand;
import com.pluralsight.models.hands.Hand;

public class Player
{
    private String name;
    private BlackJackHand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new BlackJackHand();
    }

    public void deal(Card card)
    {
        hand.deal(card);
    }

    public String getName()
    {
        return name;
    }

    public Hand showHand()
    {
        hand.show();
        return hand;
    }

    public int getHandValue()
    {
        return hand.getValue();
    }
}
