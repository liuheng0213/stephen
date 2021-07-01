package basic.knowledge.stephen.ThreadRelevant._01startDemo.futureCallable.similar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public Map<String,String> getUserInfo() throws Exception{
        Map<String, String> map = new HashMap<String,String>();
        //1.获取用户基本信息
        Callable<String> userInfoCallable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread thread0 = Thread.currentThread();
                System.out.println("thread0启动:"+thread0.getName());
                thread0.sleep(3000);
                //模拟调用获取用户mapper接口
                return "返回用户信息数据";
            }
        };
        FutureTask userInfoFutureTask = new FutureTask(userInfoCallable);
        new Thread(userInfoFutureTask).start();

        //2.获取页面展示数据信息
        Callable<String> indexDataCallable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread thread1 = Thread.currentThread();
                System.out.println("thread1启动:"+thread1.getName());
                thread1.sleep(5000);
                //模拟调用获取页面数据mapper接口
                return "返回页面数据信息";
            }
        };
        FutureTask indexDatafutureTask = new FutureTask(indexDataCallable);
        new Thread(indexDatafutureTask).start();//开启线程

        //3.获取对象并合并数据（调用get()方法，该线程会进入阻塞状态，直到线程返回结果才会继续执行下面代码）
        String userInfo = userInfoFutureTask.get().toString();
        map.put("userInfo",userInfo);

        String indexData = indexDatafutureTask.get().toString();
        map.put("indexData",indexData);
        return map;
    }

    public static void main(String[] args) {
        System.out.println("主线程main："+Thread.currentThread().getName());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println("开始"+sdf.format(new Date()));
        FutureTaskTest futureTaskTest = new FutureTaskTest();
        Map<String, String> userInfo=null;
        try {
            userInfo = futureTaskTest.getUserInfo();
            if(userInfo!=null){
                System.out.println(userInfo.get("userInfo"));
                System.out.println(userInfo.get("indexData"));
            }
            System.out.println("结束"+sdf.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
