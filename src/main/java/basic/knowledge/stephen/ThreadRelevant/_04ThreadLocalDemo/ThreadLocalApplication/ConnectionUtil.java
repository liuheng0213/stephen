package basic.knowledge.stephen.ThreadRelevant._04ThreadLocalDemo.ThreadLocalApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 假设有这样一个数据库链接管理类，这段代码在单线程中使用是没有任何问题的，但是如果在多线程中使用呢？很显然，在多线程中使用会存在线程安全问题：
 * 第一，这里面的2个方法都没有进行同步，很可能在openConnection方法中会多次创建connect；
 * 第二，由于connect是共享变量，那么必然在调用connect的地方需要使用到同步来保障线程安全，因为很可能一个线程在使用connect进行数据库操作，而另外一个线程调用closeConnection关闭链接。

 　　所以出于线程安全的考虑，必须将这段代码的两个方法进行同步处理，并且在调用connect的地方需要进行同步处理。

 　　这样将会大大影响程序执行效率，因为一个线程在使用connect进行数据库操作的时候，其他线程只有等待。

 　　那么大家来仔细分析一下这个问题，这地方到底需不需要将connect变量进行共享？
 事实上，是不需要的。假如每个线程中都有一个connect变量，各个线程之间对connect变量的访问实际上是没有依赖关系的，即一个线程不需要关心其他线程是否对这个connect进行了修改的。
 */
public final class ConnectionUtil {

    private ConnectionUtil() {}

    private static final ThreadLocal<Connection> connThreadLocal = new ThreadLocal<>();

    public static Connection getConn() {
        Connection con = connThreadLocal.get();
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("url", "userName", "password");
                connThreadLocal.set(con);
            } catch (ClassNotFoundException | SQLException e) {
                // ...
            }
        }
        return con;
    }

    public void addTopic() throws SQLException {
        // ④从ThreadLocal中获取线程对应的Connection
        Statement stat = getConn().createStatement();
    }

}