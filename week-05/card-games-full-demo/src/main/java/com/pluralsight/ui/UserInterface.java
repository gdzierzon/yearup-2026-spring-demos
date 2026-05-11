package com.pluralsight.ui;

import com.pluralsight.models.Card;
import com.pluralsight.models.Player;
import com.pluralsight.models.Suits;

public class UserInterface
{

    public static void displayPlayerHand(Player player)
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW + player.getName() + ": " + ColorCodes.GREEN + player.getScore() + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW +  "-------------------------------" + ColorCodes.RESET);
        for(Card card : player.getCards())
        {
            displayCard(card);
//            System.out.println(card.getFaceValue() + " of " + card.getSuit());
        }
        System.out.println();
    }

    public static void displayWinner(Player player)
    {
        System.out.println(ColorCodes.YELLOW);
        System.out.println("*********************************");
        System.out.println("              WINNER");
        System.out.println("*********************************" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + player.getName() + ": " + ColorCodes.RED + player.getScore() + ColorCodes.RESET);
    }

    public static void displayCard(Card card)
    {
        String color;
        String suit;

        switch(card.getSuit())
        {
            case Suits.Diamonds:
                color = ColorCodes.RED;
                suit = Symbols.DIAMONDS;
                break;
            case Suits.Hearts:
                color = ColorCodes.RED;
                suit = Symbols.HEARTS;
                break;
            case Suits.Clubs:
                color = ColorCodes.WHITE;
                suit = Symbols.CLUBS;
                break;
            case Suits.Spades:
            default:
                color = ColorCodes.WHITE;
                suit = Symbols.SPADES;
                break;
        }
        System.out.print(color + card.getFaceValue() + suit + ColorCodes.RESET + "  ");
    }
}
