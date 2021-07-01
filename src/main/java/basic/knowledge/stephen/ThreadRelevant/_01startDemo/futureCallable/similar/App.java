package basic.knowledge.stephen.ThreadRelevant._01startDemo.futureCallable.similar;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SharedResource sharedResource = new SharedResource();
        FutureTask userInfoFutureTask = new FutureTask(new UserInfoCallable(sharedResource));
        new Thread(userInfoFutureTask).start();
        FutureTask indexDatafutureTask = new FutureTask(new IndexDataCallable(sharedResource));
        new Thread(indexDatafutureTask).start();

        Object o = userInfoFutureTask.get();
        Object o1 = indexDatafutureTask.get();

        System.out.println();


    }
}
