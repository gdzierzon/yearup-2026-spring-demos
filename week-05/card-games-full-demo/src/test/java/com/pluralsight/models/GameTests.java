package com.pluralsight.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTests
{
    private Game game;
    private Player player1, player2;

    private Card spadesAce = new Card(Suits.Spades, "A");
    private Card heartsTen = new Card(Suits.Hearts, "10");
    private Card diamondsThree = new Card(Suits.Diamonds, "3");
    private Card clubsJack = new Card(Suits.Clubs, "J");

    @BeforeEach
    public void setup()
    {
        game = new Game();
        game.startNewGame();

        player1 = new Player("player 1");
        player2 = new Player("player 2");
    }

    @Test
    public void startNewGame_shouldCreate_newDeckAndPlayers()
    {
        // arrange
        Game game = new Game();
        ArrayList<Player> playersBeforeStart = game.getPlayers();

        // act
        game.startNewGame();

        // assert
        ArrayList<Player> playersAfterStart = game.getPlayers();
        assertNull(playersBeforeStart, "because the players list is null before start");
        assertNotNull(playersAfterStart, "because I started teh game");

    }

    @Test
    public void dealRound_shouldDealOneCardToEachPlayer()
    {
        // arrange
        game.addPlayer(player1);
        game.addPlayer(player2);

        // act
        game.dealRound();

        // assert
        assertEquals(1, player1.getCards().size(), "because I dealt 1 round of cards - Player 1 should have 1 card");
        assertEquals(1, player2.getCards().size(), "because I dealt 1 round of cards - Player 2 should have 1 card");

    }

    @Test
    public void getWinner_shouldReturnPlayerWithHighestScore()
    {
        // arrange
        game.addPlayer(player1);
        game.addPlayer(player2);

        player1.deal(spadesAce);
        player1.deal(diamondsThree);
        player2.deal(heartsTen);
        player2.deal(clubsJack);

        // act
        Player winner = game.getWinner();

        // assert
        assertEquals(player2, winner, "because player2's hand was worth 20 and player1's hand was worth 14");
    }

}