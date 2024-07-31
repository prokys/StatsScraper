package statsScraper.leagueStats;

public class Stats {
    private String league;
    private int matches;
    private int goals;
    private int assists;
    private int combinedGoalsAndAssists;
    private int penalties;

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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

    public int getCombinedGoalsAndAssists() {
        return combinedGoalsAndAssists;
    }

    public void setCombinedGoalsAndAssists(int combinedGoalsAndAssists) {
        this.combinedGoalsAndAssists = combinedGoalsAndAssists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
}
