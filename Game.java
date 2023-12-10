class Game//This is the game class
{
    private String name;
    private int timesPlayed;//wrap some attributes

    public Game(String name, int timesPlayed) {
        this.name = name;
        this.timesPlayed = timesPlayed;
    }//set the access location for the 2 attributes

    public String getName() {
        return name;
    }

    public int getTimesplayed() {
        return timesPlayed;
    }//set the access location

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }//set the access location

}
