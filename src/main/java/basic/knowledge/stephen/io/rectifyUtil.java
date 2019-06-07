package basic.knowledge.stephen.io;

import java.io.File;

public class rectifyUtil {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\宝宝视频\\18.07");
        File[] files = file.listFiles();
        for (File f:files) {
            String fullName = f.getName();
            if(f.isFile() && fullName.endsWith(".jpg") && fullName.startsWith("1")){
                String[] split = fullName.split("\\.");
                String preName = split[0];
                String newFullName = preName.concat(".mp4");
                f.renameTo(new File("C:\\Users\\Lenovo\\Desktop\\宝宝视频\\18.07",newFullName));
            }
        }
    }
}
