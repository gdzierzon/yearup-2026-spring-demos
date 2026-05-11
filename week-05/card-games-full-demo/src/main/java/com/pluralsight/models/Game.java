package com.pluralsight.models;

import java.util.ArrayList;

public class Game
{
    private Deck deck;
    private ArrayList<Player> players;

    public void playGame()
    {
        for (int i = 0; i < 2; i++)
        {
            dealRound();
        }
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public Player getWinner()
    {
        Player winner = players.getFirst();

        // find player with highest score
        for (Player player : players)
        {
            if (player.getScore() > winner.getScore())
            {
                winner = player;
            }
        }

        return winner;
    }

    public void startNewGame()
    {
        players = new ArrayList<>();
        deck = new Deck();
        deck.shuffle();
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void dealRound()
    {
        for (Player player: players)
        {
            dealCard(player);
        }
    }

    public void dealCard(Player player)
    {
        player.deal(deck.takeTopCard());
    }
}
