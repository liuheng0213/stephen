package basic.knowledge.stephen.java8.lambda_java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MapTest {
    @Test
    public void testMap(){
        List<Integer> nums = Arrays.asList(12, 6, 8);
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        nums.stream().map(x -> x / 2).forEach(x -> System.out.println(x));

    }
}
