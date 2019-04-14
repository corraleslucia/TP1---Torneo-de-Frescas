package Tournament;

import models.Human;

public class Winner {
    private Human winner;
    private Double consumed_quantity;

    public Winner(Human winner, Double consumed_quantity) {
        this.winner = winner;
        this.consumed_quantity = consumed_quantity;
    }

    public Human getWinner() {
        return winner;
    }

    public Double getConsumed_quantity() {
        return consumed_quantity;
    }
}
