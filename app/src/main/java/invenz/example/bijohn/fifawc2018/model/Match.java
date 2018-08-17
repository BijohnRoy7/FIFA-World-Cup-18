package invenz.example.bijohn.fifawc2018.model;

public class Match {

    private String team1, team2, time, stadium, matchNo;
    private Integer team1Img, team2Img;

    public Match() {
    }

    public Match(String team1, String team2, String time, String stadium, String matchNo, Integer team1Img, Integer team2Img) {
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        this.stadium = stadium;
        this.matchNo = matchNo;
        this.team1Img = team1Img;
        this.team2Img = team2Img;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }

    public Integer getTeam1Img() {
        return team1Img;
    }

    public void setTeam1Img(Integer team1Img) {
        this.team1Img = team1Img;
    }

    public Integer getTeam2Img() {
        return team2Img;
    }

    public void setTeam2Img(Integer team2Img) {
        this.team2Img = team2Img;
    }
}
