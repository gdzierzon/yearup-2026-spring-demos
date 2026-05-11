package com.pluralsight.models;

public class Card
{
    private Suits suit;
    private String faceValue;


    public Card(Suits suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suits getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public String getColor()
    {
        switch (suit)
        {
            case Suits.Hearts:
            case Suits.Diamonds:
                return "Red";
            default:
                return "Black";
        }
    }

    public int getPointValue()
    {
        switch (faceValue)
        {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(faceValue);
        }
    }
}
