package main;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FootballTeam implements Comparable<FootballTeam> {
    private int gamesWon;

    public FootballTeam(int gamesWon){
        if(gamesWon < 0){
            throw new IllegalArgumentException(
                    "Not possible to have less than 0 games won!" +
                            "(was + " + gamesWon + ")");
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam o) {
        return 1;
    }

}
