package basic.knowledge.stephen.AliasAlgorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 別名算法,动态保证中奖概率
 */
public class MainTest {
    public static void main(String[] args) {
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        map.put("earPhone", 0.01);
        map.put("1", 0.792);
        map.put("2", 0.099);
        map.put("5", 0.0495);
        map.put("10", 0.0297);
        map.put("30", 0.0198);

        List<Double> list = new ArrayList<Double>(map.values());
        List<String> gifts = new ArrayList<String>(map.keySet());

        AliasMethod method = new AliasMethod(list);

        Map<String, AtomicInteger> resultMap = new HashMap<String, AtomicInteger>();

        for (int i = 0; i < 1000; i++) {
            int index = method.next();
            String key = gifts.get(index);
            //System.out.println("==========="+key);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new AtomicInteger());
            }
            resultMap.get(key).incrementAndGet();
        }
        for (String key : resultMap.keySet()) {
            System.out.println(key + "==" + resultMap.get(key));
        }

    }
}
