package singleton;

/**
 * 懒汉式
 * 双重判空
 */
public class Mgr06 {
    //这里需要加上volatile，原因是java虚拟机内部执行的时候对于java汇编语言进行优化，会产生指令重排（jit编译成本地语言），如果不加volatile会产生问题，当前并没有
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {

    }

    public static Mgr06 getInstance() {
        //双重检查
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if(INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
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
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
