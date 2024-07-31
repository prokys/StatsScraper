package statsScraper.leagueStats;

import java.util.List;

public class PlayerSuperLeagueStats extends Player {
    public PlayerSuperLeagueStats(String fullName, List<LeagueStats> leagueStats) {
        setFullName(fullName);
        setLeague("SuperLeague");
        for (LeagueStats stat : leagueStats){
            if (stat.getLeague().equals("Livesport Superliga") ||
                    stat.getLeague().equals("Superliga florbalu") ||
                    stat.getLeague().equals("AutoCont extraliga") ||
                    stat.getLeague().equals("Tipsport Superliga") ||
                    stat.getLeague().equals("Fortuna extraliga") ||
                    stat.getLeague().equals("Fortuna extraliga - divize A")) {
                setMatches(getMatches() + stat.getMatches());
                setAssists(getAssists() + stat.getAssists());
                setGoals(getGoals() + stat.getGoals());
                setCombinedGoalsAndAssists(getCombinedGoalsAndAssists() + stat.getCombinedGoalsAndAssists());
                setPenalties(getPenalties() + stat.getPenalties());
            }
        }
    }
}
