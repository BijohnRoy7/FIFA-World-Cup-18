package invenz.example.bijohn.fifawc2018.model;

public class Group {

    private String team1, team2, team3, team4, groupName;
    private Integer team1Img,team2Img,team3Img,team4Img;

    public Group(String team1, String team2, String team3, String team4, String groupName, Integer team1Img, Integer team2Img, Integer team3Img, Integer team4Img) {
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
        this.groupName = groupName;
        this.team1Img = team1Img;
        this.team2Img = team2Img;
        this.team3Img = team3Img;
        this.team4Img = team4Img;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Integer getTeam3Img() {
        return team3Img;
    }

    public void setTeam3Img(Integer team3Img) {
        this.team3Img = team3Img;
    }

    public Integer getTeam4Img() {
        return team4Img;
    }

    public void setTeam4Img(Integer team4Img) {
        this.team4Img = team4Img;
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

    public String getTeam3() {
        return team3;
    }

    public void setTeam3(String team3) {
        this.team3 = team3;
    }

    public String getTeam4() {
        return team4;
    }

    public void setTeam4(String team4) {
        this.team4 = team4;
    }
}
