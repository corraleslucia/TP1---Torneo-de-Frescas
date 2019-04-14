package Tournament;

import models.Human;

public class TournamentManager {

    private final Integer rounds = 10;

    //for 10 rounds, makes compete both humans until one pee or the rounds end.
    public Winner competition(Human viking, Human spartan) {
        Integer roundCount = 0;
        Double vikingResult = 0.0;
        Double spartanResult = 0.0;
        Winner winner = null;

        do {
            Double auxV = viking.compete();
            Double auxS = spartan.compete();

            vikingResult = auxV + vikingResult;
            spartanResult = auxS + spartanResult;
            roundCount++;
            if (auxV == 0 || auxS == 0)//if one of them has to pee
            {
                if (auxV == 0 && auxS == 0) { //if both have to pee
                    winner = null;
                } else {
                    winner = auxV != 0 ? new Winner(viking, vikingResult) : new Winner(spartan, spartanResult); //if one peed, the other is the winner
                }
            }
        } while (winner == null && roundCount < rounds); //if the rounds ended and no one pee

        if (winner == null) { //the winner is the one with the most consumed_quantity
            winner = vikingResult > spartanResult ? new Winner(viking, vikingResult) : new Winner(spartan, spartanResult);
        }
        return winner;
    }

}
