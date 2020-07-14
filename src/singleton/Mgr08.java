package singleton;

/**
 * 枚举单例
 * 不仅可以解决线程同步，还可以防止反序列化。
 * 枚举单例不会被反序列化原因是没有构造方法的
 *
 */
public enum Mgr08 {
    INSTANCE;

    public void m() {
    }

    public static void main(String[] args) {
        //        Mgr08 instance = Mgr08.getInstance();
//        Mgr08 instance1 = Mgr08.getInstance();
//        System.out.println(instance == instance1);
        //lamda表达式可以对一个匿名内部类只有一个方法简写
        for (int i = 0; i < 100; i++) {
            //同一类的不同对象hashcode值是不同的
            new Thread(() -> System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }
    }
}
