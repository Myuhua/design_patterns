package singleton;


/**
 * 懒汉式单例（懒加载）
 * 虽然达到了按需初始化的目的，但是多线程访问会有问题
 */
public class Mgr03 {
    //这儿不能加final，final必须得初始化
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            //增加线程打断机会
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //测试验证
    public static void main(String[] args) {
//        Mgr03 instance = Mgr03.getInstance();
//        Mgr03 instance1 = Mgr03.getInstance();
//        System.out.println(instance == instance1);
        //lamda表达式可以对一个匿名内部类只有一个方法简写
        for (int i = 0; i < 100; i++) {
            //同一类的不同对象hashcode值是不同的
            new Thread(()-> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
