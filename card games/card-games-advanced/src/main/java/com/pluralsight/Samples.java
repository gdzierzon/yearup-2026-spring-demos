package com.pluralsight;

import com.pluralsight.models.cards.Card;
import com.pluralsight.models.cards.facecards.FaceCard;
import com.pluralsight.models.cards.facecards.builders.CardBuilder;
import com.pluralsight.models.games.BlackJack;
import com.pluralsight.models.hands.BlackJackHand;
import com.pluralsight.models.players.BlackJackPlayer;
import com.pluralsight.models.players.Player;
import com.pluralsight.ui.FaceCardPrinter;
import com.pluralsight.ui.UserOutput;

public class Samples
{
    public static void main(String[] args)
    {
//        List<String> names = new ArrayList<>();
//        names.add("test");
//        King king = new King(Suits.SPADES);
//
//        FaceCard q = CardBuilder.QUEEN_DIAMONDS();
//        FaceCard k = CardBuilder.KING_DIAMONDS();
//        demo();

        cardValues();
    }

    public static void cardValues()
    {
        FaceCard card1 = CardBuilder.ACE_CLUBS();
        FaceCard card2 = CardBuilder.ACE_DIAMONDS();
        FaceCard card3 = CardBuilder.QUEEN_DIAMONDS();
        FaceCard card4 = CardBuilder.TEN_HEARTS();
        FaceCard card5 = CardBuilder.THREE_HEARTS();

        BlackJackHand hand = new BlackJackHand();
        hand.deal(card1);
        hand.deal(card2);
        hand.deal(card3);
        hand.deal(card4);
        hand.deal(card5);

        FaceCardPrinter.printCards(card1, card2, card3, card4, card5);
        hand.getCards().forEach(Card::flip);
        FaceCardPrinter.printCards(card1, card2, card3, card4, card5);

        System.out.println(hand.getValue());
        System.out.println(hand.isBust());
    }

    public static void demo()
    {
        Player player = new Player("Gregor");
        player.deal(CardBuilder.QUEEN_DIAMONDS());
        player.deal(CardBuilder.TWO_CLUBS());
        player.deal(CardBuilder.EIGHT_SPADES());
        player.deal(CardBuilder.THREE_SPADES());
        player.deal(CardBuilder.ACE_HEARTS());
        player.deal(CardBuilder.ACE_SPADES());
        player.deal(CardBuilder.TWO_DIAMONDS());

        UserOutput.showHand(player);
    }



    public void run()
    {
        BlackJack game = new BlackJack();

        BlackJackPlayer gary = new BlackJackPlayer("Gary");
        BlackJackPlayer sarah = new BlackJackPlayer("Sarah");
        BlackJackPlayer steph = new BlackJackPlayer("Steph");

        game.join(gary);
        game.join(sarah);
        game.join(steph);

        game.dealPlayersIn();

        for (int i = 0; i < 5; i++)
        {
            for(Player player : game.getPlayers())
            {
                BlackJackHand hand = (BlackJackHand) player.showHand();
                if(!hand.isBust() && hand.getValue() + 6 < 21)
                {
                    game.hit(player);
                }
            }
        }

        for(Player player : game.getPlayers())
        {
            UserOutput.showHand(player);
        }

        // declares winner
        game.endGame();

        UserOutput.winner(game.getWinner());
    }
}
