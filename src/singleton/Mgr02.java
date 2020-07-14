package singleton;

/**
 * 饿汉式采用静态块方式写
 */
public class Mgr02 {
    //静态变量为static
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    //构造方法私有化，是其他类不能够new
    private Mgr02() {
    }

    //其他类若想用本实例，需要调用getInstance方法，返回值永远是一个INSTANCE
    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("单例模式-饿汉式");
    }

    //测试验证
    public static void main(String[] args) {
        Mgr02 mgr02 = Mgr02.getInstance();
        Mgr02 mgr021 = Mgr02.getInstance();
        System.out.println(mgr02 == mgr02);

    }
}
