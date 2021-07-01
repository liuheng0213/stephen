package basic.knowledge.stephen.ThreadRelevant._01startDemo.futureCallable.similar;

import java.util.Map;
import java.util.concurrent.Callable;

public class UserInfoCallable implements Callable {
    private SharedResource resource;

    public UserInfoCallable(SharedResource resource) {
        this.resource = resource;
    }


    @Override
    public Map<String,String> call() throws Exception {
        Thread thread1 = Thread.currentThread();
        System.out.println("thread1启动:"+thread1.getName());
        thread1.sleep(5000);
        //模拟调用获取页面数据mapper接口
        resource.map.put("2", "返回用户信息数据");
        return resource.map;

    }
}
