package basic.knowledge.stephen.design_Pattern._06DesignPattern_Composite;

import java.util.ArrayList;
import java.util.Iterator;

public class SongGroup extends SongComponent {
    ArrayList<SongComponent> songComponents = new ArrayList();

    String groupName;
    String groupDescription;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public void add(SongComponent newSongComponent) {
        songComponents.add(newSongComponent);
    }

    @Override
    public void remove(SongComponent newSongComponent) {
        songComponents.remove(newSongComponent);
    }

    @Override
    public SongComponent getComponent(int componentIndex) {
        return songComponents.get(componentIndex);
    }

    @Override
    public void displaySongInfo() {
        System.out.println(getGroupName() + " " + getGroupDescription() + "\n");

        Iterator<SongComponent> iterator = songComponents.iterator();
        while(iterator.hasNext()){
            SongComponent songInfo = iterator.next();
            songInfo.displaySongInfo();
        }
    }
}
