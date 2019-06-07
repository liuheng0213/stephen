package basic.knowledge.stephen.ThreadRelevant._04ThreadLocalDemo;

public class MyThreadLocal {

    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue()
        {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值null！");
            return null;
        }
    };

    public static void main(String[] args)
    {
        //开四个线程, 注意并非:对于MyIntegerTask,共享某一个value;MyStringTask共享另一个value
        //而是这底下new四个线程,但只有一个threadlocal<Object>,且threadLocalMap中的键是ThreadLocal,值类型是Object
        //每个线程从头到尾共享自己的数据
        //从输出结果看stringtask1;stringtask2并没有互相共享数据, 数据只在一个线程内共享,切记
        new Thread(new MyIntegerTask("IntegerTask1")).start();//IntegerTask1为线程名
        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable
    {
        private String name;

        MyIntegerTask(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                // ThreadLocal.get方法获取线程变量, 如果沒有設置,get方法底层会有
                //Thread t = Thread.currentThread();
                //ThreadLocalMap map = getMap(t);--进一步底层知ThreadLocalMap<ThreadLocal,Object>,并非t作为键
                //获取当前线程的map
                if(null == MyThreadLocal.threadLocal.get())
                {
                    // ThreadLocal.et方法设置线程变量,如果是Null,旧设置0
                    MyThreadLocal.threadLocal.set(0);
                    System.out.println("线程" + name + ": 0");
                }
                else
                {
                    int num = (Integer)MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(num + 1);
                    System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                    if(i == 3)
                    {
                        //remove了后,value=null了
                        //IntegerTask1,IntegerTask2运行到i=4时
                        //先调用get方法 get方法要么返回value(不为Null),要么返回setInitialValue(value==null)
                        //,setInitialValue底层又回调用initialValue()方法----sovalue!=null 不会执行initialValue();
                        //然后运行set(0)
                        MyThreadLocal.threadLocal.remove();
                    }
                }

                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }


    public static class MyStringTask implements Runnable
    {
        private String name;

        MyStringTask(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                if(null == MyThreadLocal.threadLocal.get())
                {
                    MyThreadLocal.threadLocal.set("a");
                    System.out.println("线程" + name + ": a");
                }
                else
                {
                    String str = (String)MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(str + "a");
                    System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                }
                try
                {
                    Thread.sleep(800);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
