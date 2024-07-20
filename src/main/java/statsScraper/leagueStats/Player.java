package statsScraper.leagueStats;

import java.util.List;

public class Player {
    private String fullName;
    private String league;
    private int matches;
    private int goals;
    private int assists;
    private int combinedGoalsAndAssists;

    public Player(String fullName, List<LeagueStats> leagueStats){
        this.fullName = fullName;
        this.league = "All leagues";
        for (LeagueStats stat : leagueStats){
            this.matches = this.matches + stat.getMatches();
        }
        for (LeagueStats stat : leagueStats){
            this.assists = this.assists + stat.getAssists();
        }
        for (LeagueStats stat : leagueStats){
            this.goals = this.goals + stat.getGoals();
        }
        for (LeagueStats stat : leagueStats){
            this.combinedGoalsAndAssists = this.combinedGoalsAndAssists + stat.getCombinedGoalsAndAssists();
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + fullName + '\'' +
                ", league='" + league + '\'' +
                ", matches=" + matches +
                ", goals=" + goals +
                ", assists=" + assists +
                ", combinedGoalsAndAssists=" + combinedGoalsAndAssists +
                '}';
    }
}
