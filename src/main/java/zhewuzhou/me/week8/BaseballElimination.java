package zhewuzhou.me.week8;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class BaseballElimination {
    static final String SPACE = " ";
    private final Map<String, Team> teams = new TreeMap<>();
    private Team winner;
    private int totalTeam;
    private int[][] against;
    private int[] wins;
    private int[] loses;
    private int[] remaining;
    private String[] names;
    private ArrayList<int[]> uniquePair = new ArrayList<>();

    BaseballElimination(String filename) {
        parseFile(filename);
        createMap();
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
        return checkAndFetch(team).wins;
    }

    // number of losses for given team
    public int losses(String team) {
        return checkAndFetch(team).losses;
    }

    // number of remaining games for given team
    public int remaining(String team) {
        return checkAndFetch(team).remaining;
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        return checkAndFetch(team1).teamVs.get(team2);
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        return checkAndFetch(team).isEliminated;
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        Team targetTeam = checkAndFetch(team);
        if (targetTeam.wins + targetTeam.remaining < winner.wins) {
            targetTeam.certificateOfElimination.add(this.winner.name);
        } else {
            int currentVertex = 1;
            Map<Integer, Integer> vertexMap = new HashMap<>();
            Map<Integer, List<Integer>> vertexParent = new HashMap<>();
            ArrayList<FlowEdge> edges = new ArrayList<>();
            Set<Integer> joinedTeam = new HashSet<>();
            int fullCapacity = 0;
            for (int[] pair : uniquePair) {
                if (pair[0] != targetTeam.id && pair[1] != targetTeam.id) {
                    int capacity = this.against[pair[0]][pair[1]];
                    fullCapacity += capacity;
                    edges.add(new FlowEdge(0, currentVertex, capacity));
                    updateParent(vertexParent, pair, currentVertex);
                    joinedTeam.add(pair[0]);
                    joinedTeam.add(pair[1]);
                    currentVertex++;
                }
            }
            int totalVertexNum = currentVertex + joinedTeam.size() + 1;
            for (int id : joinedTeam) {
                for (int parent : vertexParent.get(id)) {
                    edges.add(new FlowEdge(parent, currentVertex, Double.POSITIVE_INFINITY));
                }
                edges.add(new FlowEdge(currentVertex, totalVertexNum - 1, targetTeam.wins + targetTeam.remaining - wins[id]));
                vertexMap.put(currentVertex, id);
                currentVertex++;
            }
            FlowNetwork network = new FlowNetwork(totalVertexNum);
            for (FlowEdge e : edges) {
                network.addEdge(e);
            }
            FordFulkerson algorithm = new FordFulkerson(network, 0, totalVertexNum - 1);
            if (algorithm.value() != fullCapacity) {
                for (int v : vertexMap.keySet()) {
                    if (algorithm.inCut(v)) {
                        targetTeam.certificateOfElimination.add(names[vertexMap.get(v)]);
                    }
                }
            }
        }
        return targetTeam.certificateOfElimination;
    }

    private void updateParent(Map<Integer, List<Integer>> vertexParent, int[] teamIds, int vertexId) {
        for (int id : teamIds) {
            if (vertexParent.get(id) == null) {
                ArrayList<Integer> parents = new ArrayList<>();
                parents.add(vertexId);
                vertexParent.put(id, parents);
            } else {
                vertexParent.get(id).add(vertexId);
            }
        }
    }

    private class Team {
        private String name;
        private int id;
        private int wins;
        private int losses;
        private int remaining;
        private boolean isEliminated;
        private Map<String, Integer> teamVs = new TreeMap<>();
        private List<String> certificateOfElimination = new ArrayList<>();
    }

    private void createMap() {
        int mostWins = 0;
        for (int i = 0; i < this.totalTeam; i++) {
            Team t = new Team();
            t.name = this.names[i];
            t.wins = this.wins[i];
            t.losses = this.loses[i];
            t.remaining = this.remaining[i];
            t.id = i;
            TreeMap<String, Integer> teamVs = new TreeMap<>();
            for (int j = 0; j < this.totalTeam; j++) {
                teamVs.put(this.names[j], this.against[i][j]);
            }
            t.teamVs = teamVs;
            this.teams.put(t.name, t);
            if (t.wins > mostWins) {
                this.winner = t;
            }
        }
        for (int i = 0; i < this.totalTeam; i++) {
            for (int j = 0; j < this.totalTeam; j++) {
                if (i != j && i < j) {
                    int[] teamPair = {i, j};
                    uniquePair.add(teamPair);
                }
            }
        }
    }

    private void parseFile(String filename) {
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
    }

    private Team checkAndFetch(String name) {
        Team team = teams.get(name);
        if (null == team) {
            throw new IllegalArgumentException("Not a valid team name");
        }
        return team;
    }
}
