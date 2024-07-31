package statsScraper.leagueStats;

import java.util.List;

public class PlayerAllTimeStats extends Player {

    public PlayerAllTimeStats(String fullName, List<LeagueStats> leagueStats){
        setFullName(fullName);
        setLeague("All leagues");
        for (LeagueStats stat : leagueStats){
            setMatches(getMatches() + stat.getMatches());
        }
        for (LeagueStats stat : leagueStats){
            setAssists(getAssists() + stat.getAssists());
        }
        for (LeagueStats stat : leagueStats){
            setGoals(getGoals() + stat.getGoals());
        }
        for (LeagueStats stat : leagueStats){
            setCombinedGoalsAndAssists(getCombinedGoalsAndAssists() + stat.getCombinedGoalsAndAssists());
        }
        for (LeagueStats stat : leagueStats){
            setPenalties(getPenalties() + stat.getPenalties());
        }
    }

    public PlayerAllTimeStats(String fullName, String league, int matches, int goals, int assists, int combinedGoalsAndAssists) {
        setFullName(fullName);
        setLeague(league);
        setMatches(matches);
        setGoals(goals);
        setAssists(assists);
        setCombinedGoalsAndAssists(combinedGoalsAndAssists);
    }
    public PlayerAllTimeStats() {

    }
    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + getFullName() + '\'' +
                ", league='" + getLeague() + '\'' +
                ", matches=" + getMatches() +
                ", goals=" + getGoals() +
                ", assists=" + getAssists() +
                ", combinedGoalsAndAssists=" + getCombinedGoalsAndAssists() +
                '}';
    }
}
