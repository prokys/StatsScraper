package statsScraper.leagueStats;

import java.util.List;

public class LeagueStats {
    private String league;
    private String phase;
    private String team;
    private int matches;
    private int goals;
    private int assists;
    private int combinedGoalsAndAssists;
    private int penalties;
    public LeagueStats() {

    }

    public LeagueStats(String league, String phase, String team, int matches, int goals, int assists, int combinedGoalsAndAssists, int penalties) {
        this.league = league;
        this.phase = phase;
        this.team = team;
        this.matches = matches;
        this.goals = goals;
        this.assists = assists;
        this.combinedGoalsAndAssists = combinedGoalsAndAssists;
        this.penalties = penalties;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getCombinedGoalsAndAssists() {
        return combinedGoalsAndAssists;
    }

    public void setCombinedGoalsAndAssists(int combinedGoalsAndAssists) {
        this.combinedGoalsAndAssists = combinedGoalsAndAssists;
    }

    @Override
    public String toString() {
        return "LeagueStats{" +
                "league='" + league + '\'' +
                ", phase='" + phase + '\'' +
                ", team='" + team + '\'' +
                ", matches=" + matches +
                ", goals=" + goals +
                ", assists=" + assists +
                ", combinedGoalsAndAssists=" + combinedGoalsAndAssists +
                ", penalties=" + penalties +
                '}';
    }

}
