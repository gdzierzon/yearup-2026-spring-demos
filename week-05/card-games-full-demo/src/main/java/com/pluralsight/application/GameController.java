package com.pluralsight.application;

import com.pluralsight.models.Game;
import com.pluralsight.models.Player;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController
{
    Game game = new Game();

    public void run()
    {
        game.startNewGame();

        addRandomPlayers(4);

        game.playGame();


        // display all player scores
        for(Player player: game.getPlayers())
        {
            UserInterface.displayPlayerHand(player);
        }

        // display winner
        UserInterface.displayWinner(game.getWinner());

    }

    private void addRandomPlayers(int numberOfPlayers)
    {
        ArrayList<String> names = new ArrayList<>(List.of(
                "Abeer",
                "Ariel",
                "Beruk",
                "Bryan",
                "Damarrius",
                "Imanuel",
                "Jacintha",
                "Jeremy",
                "Jodici",
                "Justin",
                "Louie",
                "Melissa",
                "Meron",
                "Nathan",
                "Omar",
                "Oscar",
                "Sara",
                "Sasha",
                "Sean",
                "Taihvonne",
                "Yoel",
                "Gregor"
        ));

        Collections.shuffle(names);
        for (int i = 0; i < numberOfPlayers; i++)
        {
            Player player = new Player(names.get(i));
            game.addPlayer(player);
        }
    }
}
