package zhewuzhou.me.week8;

import edu.princeton.cs.algs4.In;

import java.util.Map;
import java.util.TreeMap;

public class BaseballElimination {
    private final Map<String, Team> teams = new TreeMap<>();
    private int totalTeam;

    BaseballElimination(String filename) {
        In matches = new In(filename);
        while (matches.exists() && matches.hasNextLine()) {
            String line = matches.readLine();
            if (!line.contains(" ")) {
                this.totalTeam = Integer.parseInt(line);
            } else {

            }
        }
    }

    // number of teams
    public int numberOfTeams() {
        return 0;
    }

    // all teams
    public Iterable<String> teams() {
        return null;
    }

    // number of wins for given team
    public int wins(String team) {
        return 0;
    }

    // number of losses for given team
    public int losses(String team) {
        return 0;
    }

    // number of remaining games for given team
    public int remaining(String team) {
        return 0;
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        return 0;
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        return false;
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        return null;
    }

    private class Team {
        private String name;
        private int wins;
        private int losses;
        private int remaining;
        private Map<String, Integer> against = new TreeMap<>();
    }
}
