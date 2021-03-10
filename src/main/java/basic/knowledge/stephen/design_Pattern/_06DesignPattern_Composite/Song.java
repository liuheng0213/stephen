package basic.knowledge.stephen.design_Pattern._06DesignPattern_Composite;

public class Song extends SongComponent {
    String songName;
    String bandName;
    int releaseYear;


    public Song(String songName, String bandName, int releaseYear) {
        this.songName = songName;
        this.bandName = bandName;
        this.releaseYear = releaseYear;
    }


    @Override
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    public void displaySongInfo() {
        System.out.println(getSongName() +
                " was recorded by " + getBandName()
                + " in " + getReleaseYear());
    }
}
