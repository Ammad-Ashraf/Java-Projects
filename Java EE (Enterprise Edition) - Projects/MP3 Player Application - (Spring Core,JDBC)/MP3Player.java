package Ammad.Projectname;

public class MP3Player
{
    private Kalaam kalaam;

    public MP3Player(Kalaam kalaam)
    {
        this.kalaam = kalaam;
    }

    public void playKalaam()
    {
        System.out.println("Playing " + kalaam.getTitle() + " by " + kalaam.getArtist() + " [" + kalaam.getDuration() + " seconds]");
    }
}
