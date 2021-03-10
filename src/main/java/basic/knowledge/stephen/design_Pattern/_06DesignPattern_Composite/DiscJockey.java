package basic.knowledge.stephen.design_Pattern._06DesignPattern_Composite;

public class DiscJockey {
    SongComponent songList;

    public DiscJockey(SongComponent songList) {
        this.songList = songList;
    }

    public void printSongList(){
        songList.displaySongInfo();
    }

    public SongComponent getSongList() {
        return songList;
    }

    public void setSongList(SongComponent songList) {
        this.songList = songList;
    }
}
