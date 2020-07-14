package singleton;

/**
 * 针对Mgr04事例中线程不安全的问题可用synchronized解决，但是又会带来性能问题
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }
    //synchronized锁定的事Mgr04.Class对象
    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            //增加线程打断机会
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //测试验证
    public static void main(String[] args) {
//        Mgr04 instance = Mgr04.getInstance();
//        Mgr04 instance1 = Mgr04.getInstance();
//        System.out.println(instance == instance1);
        //lamda表达式可以对一个匿名内部类只有一个方法简写
        for (int i = 0; i < 100; i++) {
            //同一类的不同对象hashcode值是不同的
            new Thread(()-> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
