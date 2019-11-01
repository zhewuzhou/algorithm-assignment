package zhewuzhou.me.week8;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class BaseballElimination {
    static final String SPACE = " ";
    private final Map<String, Team> teams = new TreeMap<>();
    private int totalTeam;
    private int[][] against;
    private int[] wins;
    private int[] loses;
    private int[] remaining;
    private String[] names;

    BaseballElimination(String filename) {
        In matches = new In(filename);
        int teamIndex = 0;
        while (matches.exists() && matches.hasNextLine()) {
            String line = matches.readLine();
            if (!line.contains(SPACE)) {
                this.totalTeam = Integer.parseInt(line);
                this.against = new int[totalTeam][totalTeam];
                this.wins = new int[totalTeam];
                this.loses = new int[totalTeam];
                this.remaining = new int[totalTeam];
                this.names = new String[totalTeam];
            } else {
                String[] team = Arrays.stream(line.split(SPACE))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);
                this.names[teamIndex] = team[0];
                this.wins[teamIndex] = Integer.parseInt(team[1]);
                this.loses[teamIndex] = Integer.parseInt(team[2]);
                this.remaining[teamIndex] = Integer.parseInt(team[3]);
                int[] vs = new int[this.totalTeam];
                for (int i = 0; i < this.totalTeam; i++) {
                    vs[i] = Integer.parseInt(team[4 + i]);
                }
                System.arraycopy(vs, 0, against[teamIndex], 0, this.totalTeam);
                teamIndex++;
            }
        }
        for (int i = 0; i < this.totalTeam; i++) {
            Team t = new Team();
            t.name = this.names[i];
            t.wins = this.wins[i];
            t.losses = this.loses[i];
            t.remaining = this.remaining[i];
            TreeMap<String, Integer> teamVs = new TreeMap<>();
            for (int j = 0; j < this.totalTeam; j++) {
                teamVs.put(this.names[j], this.against[i][j]);
            }
            t.teamVs = teamVs;
            this.teams.put(t.name, t);
        }
    }

    // number of teams
    public int numberOfTeams() {
        return this.totalTeam;
    }

    // all teams
    public Iterable<String> teams() {
        return this.teams.keySet();
    }

    // number of wins for given team
    public int wins(String team) {
        return teams.get(team).wins;
    }

    // number of losses for given team
    public int losses(String team) {
        return teams.get(team).losses;
    }

    // number of remaining games for given team
    public int remaining(String team) {
        return teams.get(team).remaining;
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        return teams.get(team1).teamVs.get(team2);
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
        private boolean isEliminated;
        private Map<String, Integer> teamVs = new TreeMap<>();
    }
}
