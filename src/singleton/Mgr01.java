package singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 推荐使用
 * 唯一缺点：不管用到与否，类装载时就定成实例化
 */
public class Mgr01 {
    //静态变量为static
    private static final Mgr01 INSTANCE = new Mgr01();

    //构造方法私有化，是其他类不能够new
    private Mgr01() {
    }

    //其他类若想用本实例，需要调用getInstance方法，返回值永远是一个INSTANCE
    public static Mgr01 getInstance() {
        return INSTANCE;
    }
    //yw1fangfa
    public void m() {
        System.out.println("单例模式-饿汉式");
    }
    //测试验证
    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr011 = Mgr01.getInstance();
        System.out.println(mgr01 == mgr011);

    }
}
