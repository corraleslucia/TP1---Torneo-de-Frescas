package app;

import Tournament.TournamentManager;
import Tournament.Winner;
import databases.Jdbc;
import models.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static models.HumanFactory.getHuman;

public class Main {

    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();

        DecimalFormat dF = new DecimalFormat("#.##");

        List<Viking> vikings = new ArrayList<>();
        List<Spartan> spartans = new ArrayList<>();
        Human tabernOwner = getHuman(TabernOwer.class, "Arsenio Hunter", 73, 100, new DrinkVikingImp(), new PeeSpartanImp());

        vikings = Arrays.asList(getHuman(Viking.class, "Travis Villarreal", 70, 119, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Rigel Wilson", 61, 55, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Thaddeus Cannon", 27, 96, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Colby Rowe", 57, 62, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Nash Wagner", 68, 98, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Vivien Mendoza", 38, 56, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Connor Jordan", 40, 92, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Zenia Kirby", 25, 61, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Baxter Jacobson", 33, 82, new DrinkVikingImp(), new PeeVikingImp()),
                getHuman(Viking.class, "Herrod Montoya", 7, 68, new DrinkVikingImp(), new PeeVikingImp()));

        spartans = Arrays.asList(getHuman(Spartan.class, "Yardley Herring", 66, 74, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "April Osborne", 63, 94, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Grant Talley", 35, 71, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Nathan Peters", 21, 70, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Brett Galloway", 39, 80, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Macy Crosby", 19, 65, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Bernard Ruiz", 46, 83, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Omar Orr", 49, 74, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Rashad Conway", 35, 69, new DrinkSpartanImp(), new PeeSpartanImp()),
                getHuman(Spartan.class, "Burton James", 53, 81, new DrinkSpartanImp(), new PeeSpartanImp()));

        //show vikings and spartans
        System.out.println("-----------------------------");
        System.out.println("VIKINGS");
        System.out.println("=============================");
        System.out.println(vikings);
        System.out.println("-----------------------------");
        System.out.println("SPARTANS");
        System.out.println("=============================");
        System.out.println(spartans);
        System.out.println("-----------------------------");

        //order by weight
        vikings.sort(comparing(Human::getWeight));
        spartans.sort(comparing(Human::getWeight));

        //show vikings and spartans by weight
        System.out.println("-----------------------------");
        System.out.println("VIKINGS (order by Weight)");
        System.out.println("=============================");
        System.out.println(vikings);
        System.out.println("-----------------------------");
        System.out.println("SPARTANS (order by Weight)");
        System.out.println("=============================");
        System.out.println(spartans);

        System.out.println("\nCOMPETITION");

        TournamentManager tournament = new TournamentManager();

        Integer competitorsQuantity = vikings.size() < spartans.size() ? spartans.size() : vikings.size(); // gets the competitors of the bigger group

        for (int i = 0; i < competitorsQuantity; i++) {
            if (vikings.get(i) == null) { //checks if there are no more competitors in one of the groups
                System.out.println("There are not more Viking competitors.");
            } else if (spartans.get(i) == null) {
                System.out.println("There are not more Spartan competitors.");
            } else { // gets one of each and make them compete
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(format("ROUND %d : Viking = %s - Spartan = %s", i + 1, vikings.get(i).getName(), spartans.get(i).getName()));
                System.out.println("=======================================================================");
                Winner winner = tournament.competition(vikings.get(i), spartans.get(i));
                if (winner == null) {
                    System.out.println("NO WINNERS IN THIS ROUND");
                } else {
                    jdbc.insertWinner(winner); // inserts the winner in the database
                    System.out.println(format("ROUND WINNER: %s - %s lts.", winner.getWinner().getName(), dF.format(winner.getConsumed_quantity())));
                }

            }
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("WINNERS");
        System.out.println("=============================");
        List<Winner> winners = jdbc.getWinners(); //gets every round winner from the database
        winners.forEach(winner -> System.out.println(format("%s - %s - %s", winner.getWinner().getName(),
                dF.format(winner.getConsumed_quantity()), winner.getWinner().getClass().getSimpleName())));

        Winner bestWinner = winners.stream() //gets the best among all winners
                .sorted(comparingDouble(Winner::getConsumed_quantity)
                        .reversed())
                .findFirst()
                .get();

        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println(format("FINAL ROUND : %s = %s - Tabern Owner = %s",
                bestWinner.getWinner().getClass().getSimpleName(), bestWinner.getWinner().getName(), tabernOwner.getName()));
        System.out.println("=======================================================================");
        Winner champion = tournament.competition(bestWinner.getWinner(), tabernOwner); // competes best winner with owner

        System.out.println(format("ROUND WINNER: %s - %s lts.", champion.getWinner().getName(), dF.format(champion.getConsumed_quantity())));
        System.out.println("=======================================================================");
    }
}
