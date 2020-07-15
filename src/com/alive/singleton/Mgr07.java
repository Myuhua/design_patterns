package com.alive.singleton;

/**
 * 静态内部类的方式(完美)
 * JVM 保证单例  虚拟机在加载时只加载一次
 * 加在外部类时不会加在内部类，这样可以实现懒加载
 */
public class Mgr07 {
    private Mgr07() {
    }

    //静态内部类
    private static class Mgr07Holder {
        //外部内访问不了，只有内部类内访问
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //测试验证
    public static void main(String[] args) {
//        Mgr07 instance = Mgr07.getInstance();
//        Mgr07 instance1 = Mgr07.getInstance();
//        System.out.println(instance == instance1);
        //lamda表达式可以对一个匿名内部类只有一个方法简写
        for (int i = 0; i < 100; i++) {
            //同一类的不同对象hashcode值是不同的
            new Thread(() -> System.out.println(Mgr07.getInstance().hashCode())).start();
        }
    }
}
