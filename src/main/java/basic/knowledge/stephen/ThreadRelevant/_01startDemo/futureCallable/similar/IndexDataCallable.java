package basic.knowledge.stephen.ThreadRelevant._01startDemo.futureCallable.similar;

import java.util.Map;
import java.util.concurrent.Callable;

public class IndexDataCallable implements Callable {
    private SharedResource resource;

    public IndexDataCallable(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public Map<String,String> call() throws Exception {
        Thread thread1 = Thread.currentThread();
        System.out.println("thread1启动:"+thread1.getName());
        thread1.sleep(5000);
        //模拟调用获取页面数据mapper接口
        resource.map.put("1", "返回页面数据信息");
        return resource.map;
    }
}
