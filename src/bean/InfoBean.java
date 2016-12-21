package bean;

/*
 * 検索情報を格納するBean
 */
public class InfoBean {
    private String sportsKana;      //スポーツ名（カナ）
    private String sportsKanji;     //スポーツ名（漢字）
    private String sportsPlayers;   //競技人数

    public String getSportsKana() {
        return sportsKana;
    }
    public void setSportsKana(String sportsKana) {
        this.sportsKana = sportsKana;
    }
    public String getSportsKanji() {
        return sportsKanji;
    }
    public void setSportsKanji(String sportsKanji) {
        this.sportsKanji = sportsKanji;
    }
    public String getSportsPlayers() {
        return sportsPlayers;
    }
    public void setSportsPlayers(String sportsPlayers) {
        this.sportsPlayers = sportsPlayers;
    }
}
