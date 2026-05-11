package com.pluralsight;

import com.pluralsight.application.GameController;
import com.pluralsight.models.Game;

public class Main
{
    static void main()
    {
        GameController app = new GameController();
        app.run();
    }
}
