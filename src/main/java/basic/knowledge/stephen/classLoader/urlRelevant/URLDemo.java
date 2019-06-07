package basic.knowledge.stephen.classLoader.urlRelevant;




import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    private URL root = this.getClass().getClassLoader().getResource(".");

    @Test
    public  void testURL() throws MalformedURLException {
        URL url = new URL(this.root, "");
        System.out.println(root.getPath());//URLDemo的class在那个路径
        System.out.println(url.getPath());
    }
}
