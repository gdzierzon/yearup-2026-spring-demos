package com.mangomusic.ui;

import com.mangomusic.data.ReportsDao;
import com.mangomusic.models.ReportResult;
import com.mangomusic.util.ConsoleColors;
import com.mangomusic.util.InputValidator;

import java.sql.SQLOutput;
import java.util.List;

public class SpecialReportsScreen {

    private final ReportsDao reportsDao;

    public SpecialReportsScreen(ReportsDao reportsDao) {
        this.reportsDao = reportsDao;
    }

    public void display() {
        boolean running = true;

        while (running) {
            InputValidator.clearScreen();
            displayMenu();

            int choice = InputValidator.getIntInRange("Select an option: ", 0, 2);

            switch (choice) {
                case 1:
                    showMangoMusicMapped();
                    break;
                case 2:
                    //@TODO - Create report
                    showMostPlayedAlbumsByGenre();
                    break;
                case 3:
                    //@TODO - Create report
//                    showUserDiversityScore();
                    break;
                case 4:
                    //@TODO - Create report
//                    showPeakListeningHours();
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
    }

    private void showMostPlayedAlbumsByGenre()
    {
        //TODO: get most played albums
        System.out.println("most played albums");
        var result = reportsDao.getMostPlayedAlbumsByGenre();


        String previousGenre = "";
        System.out.println("genre           album                artist               plays    rank");
        System.out.println("--------------- -------------------- -------------------- -------- ----");
        for(var album : result)
        {
            var currentGenre = album.getString("genre");
            if(previousGenre == "") previousGenre = currentGenre;

            if(!previousGenre.equalsIgnoreCase(currentGenre))
            {
                System.out.println();
                previousGenre = currentGenre;
            }

            System.out.printf("%-15s %-20s %-20s %-8d %d \n",
                    album.getString("genre"),
                    album.getString("album_title"),
                    album.getString("artist"),
                    album.getInt("play_count"),
                    album.getInt("genre_rank")
            );
        }
    }

    private void displayMenu() {
        ConsoleColors.printHeader("SPECIAL REPORTS");

        System.out.println("\nPERSONALIZED ANALYTICS:");
        System.out.println("1. MangoMusic Mapped (Year in Review)");
        System.out.println("2. Most Played Albums by Genre");
        System.out.println("3. User Listening Diversity Score");
        System.out.println("4. Peak Listening Hours Analysis");

        System.out.println("\n0. Back to main menu");
        System.out.println();
    }

    private void showMangoMusicMapped() {
        InputValidator.clearScreen();
        ConsoleColors.printHeader("🎵 MANGOMUSIC MAPPED 🎵");
        System.out.println("Your personalized year in review\n");

        int userId = InputValidator.getIntInRange("Enter user ID: ", 1, Integer.MAX_VALUE);

        ReportResult mapped = reportsDao.getMangoMusicMapped(userId);

        int year = mapped.getInt("year");

        if (mapped.getInt("total_plays") == 0) {
            ConsoleColors.printWarning("No listening data found for user ID " + userId + " in " + year + ".");
        } else {
            System.out.println("\n" + "=".repeat(70));
            System.out.println("YOUR " + year + " LISTENING STORY");
            System.out.println("=".repeat(70));

            System.out.println("\n🎧 LISTENING STATS:");
            System.out.println("   Total Plays: " + mapped.getInt("total_plays"));
            System.out.println("   Albums Explored: " + mapped.getInt("unique_albums"));
            System.out.println("   Artists Discovered: " + mapped.getInt("unique_artists"));
            System.out.println("   Completion Rate: " +
                    String.format("%.1f%%", (mapped.getInt("completed_plays") * 100.0 / mapped.getInt("total_plays"))));

            System.out.println("\n⭐ YOUR TOP PICKS:");
            System.out.println("   #1 Artist: " + mapped.getString("top_artist") +
                    " (" + mapped.getInt("top_artist_plays") + " plays)");
            System.out.println("   Favorite Genre: " + mapped.getString("top_genre"));
            System.out.println("   Most Active Month: " + mapped.getString("top_month") +
                    " (" + mapped.getInt("top_month_plays") + " plays)");

            System.out.println("\n🔥 FUN FACTS:");
            System.out.println("   Longest Listening Streak: " + mapped.getInt("longest_streak") + " days");
            System.out.println("   Listener Personality: " + mapped.getString("listener_personality"));

            System.out.println("\n" + "=".repeat(70));
            System.out.println("Thanks for making " + year + " a year full of music! 🎶");
            System.out.println("=".repeat(70));
        }

        InputValidator.pressEnterToContinue();
    }
}