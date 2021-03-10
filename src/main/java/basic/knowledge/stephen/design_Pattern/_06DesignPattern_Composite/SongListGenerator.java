package basic.knowledge.stephen.design_Pattern._06DesignPattern_Composite;

public class SongListGenerator {

    public static void main(String[] args) {
        SongComponent industrialMusic = new SongGroup("Industrial","industrial dscription");
        SongComponent heavyMetalMusic = new SongGroup("Heavy Metal","Heavy Metal description");
        SongComponent dubstepMusicMusic = new SongGroup("Dubstep","Dubstep description");

        SongComponent everySong = new SongGroup("Song list","every song available");

        everySong.add(industrialMusic);

        industrialMusic.add(new Song("industrial 1","industrial 1",1991));
        industrialMusic.add(new Song("industrial 2","industrial 2",1992));

        industrialMusic.add(dubstepMusicMusic);

        dubstepMusicMusic.add(new Song("dubstep 1","dubstep 1",1993));
        dubstepMusicMusic.add(new Song("dubstep 2","dubstep 2",1994));


        everySong.add(heavyMetalMusic);

        heavyMetalMusic.add(new Song("heavy metal 1","heavy metal 1",1994));


        DiscJockey discJockey = new DiscJockey(everySong);


        discJockey.printSongList();

    }

}
