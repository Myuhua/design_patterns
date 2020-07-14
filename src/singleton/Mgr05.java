package singleton;

/**
 * 懒汉式（懒加载）
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {

    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //试图用如下方式优化Mgr05的问题，但是将锁加在这不能保证线程安全。相当于没加锁。
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //测试验证
    public static void main(String[] args) {
//        Mgr05 instance = Mgr05.getInstance();
//        Mgr05 instance1 = Mgr05.getInstance();
//        System.out.println(instance == instance1);
        //lamda表达式可以对一个匿名内部类只有一个方法简写
        for (int i = 0; i < 100; i++) {
            //同一类的不同对象hashcode值是不同的
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }
}
