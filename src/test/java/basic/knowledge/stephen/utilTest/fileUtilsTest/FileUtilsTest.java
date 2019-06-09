package basic.knowledge.stephen.utilTest.fileUtilsTest;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtilsTest {
    @Test
    public void testFileUtils() throws IOException {
        List<String> strings = Arrays.asList("a", "b", "c");
        List<String> latestStrings = new ArrayList<>();
        strings.stream().map(x->"Date,"+x).forEach(x-> latestStrings.add(x));
        FileUtils.writeLines(new File("C:/Users/Lenovo/Desktop/test.csv"), latestStrings);
    }
}
