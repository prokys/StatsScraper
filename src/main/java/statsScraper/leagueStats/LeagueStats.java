package statsScraper.leagueStats;

import java.util.List;

public class LeagueStats extends Stats{
    private String phase;
    private String team;
    public LeagueStats() {

    }

    public LeagueStats(String league, String phase, String team, int matches, int goals, int assists, int combinedGoalsAndAssists, int penalties) {
        setLeague(league);
        this.phase = phase;
        this.team = team;
        setMatches(matches);
        setGoals(goals);
        setAssists(assists);
        setCombinedGoalsAndAssists(combinedGoalsAndAssists);
        setPenalties(penalties);
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


    @Override
    public String toString() {
        return "LeagueStats{" +
                "league='" + getLeague() + '\'' +
                ", phase='" + phase + '\'' +
                ", team='" + team + '\'' +
                ", matches=" + getMatches() +
                ", goals=" + getGoals() +
                ", assists=" + getAssists() +
                ", combinedGoalsAndAssists=" + getCombinedGoalsAndAssists() +
                ", penalties=" + getPenalties() +
                '}';
    }

}
