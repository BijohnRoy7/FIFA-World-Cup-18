package invenz.example.bijohn.fifawc2018.model;

public class PointTable {

    private String name, mp, w, l, d, gdBangla, ptsBangla;
    private int pts, gd;

    public PointTable() {
        // TODO Auto-generated constructor stub
    }

    public PointTable(String name, String mp, String w, String l, String d, String gdBangla, String ptsBangla,  int gd, int pts) {
        this.name = name;
        this.mp = mp;
        this.w = w;
        this.l = l;
        this.d = d;
        this.gdBangla = gdBangla;
        this.ptsBangla = ptsBangla;
        this.pts = pts;
        this.gd = gd;
    }

    public String getGdBangla() {
        return gdBangla;
    }

    public void setGdBangla(String gdBangla) {
        this.gdBangla = gdBangla;
    }

    public String getPtsBangla() {
        return ptsBangla;
    }

    public void setPtsBangla(String ptsBangla) {
        this.ptsBangla = ptsBangla;
    }

    public int getGd() {
        return gd;
    }

    public void setGd(int gd) {
        this.gd = gd;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
