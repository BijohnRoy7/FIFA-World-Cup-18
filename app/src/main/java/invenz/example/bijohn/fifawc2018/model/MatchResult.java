package invenz.example.bijohn.fifawc2018.model;

public class MatchResult {

    private String team1, team2, matchNo, score;

    public MatchResult(String team1, String team2, String matchNo, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchNo = matchNo;
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }
}
