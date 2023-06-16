package design;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void single () {
        Singleton5 instance = Singleton5.getInstance();
        instance.say();
    }
}

class Singleton {

    private static Singleton single = new Singleton();
    private Singleton() {}

    public static Singleton getInstance() {
        return single;
    }

    public void say() {
        System.out.println("饿汉单例");
    }

}

class Singleton2 {

    private static Singleton2 single = null;
    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }

    public void say() {
        System.out.println("懒汉单例");
    }

}

class Singleton3 {

    private static Singleton3 single = null;
    private Singleton3() {}

    public synchronized static Singleton3 getInstance() {
        if (single == null) {
            single = new Singleton3();
        }
        return single;
    }

    public void say() {
        System.out.println("方法加锁懒汉单例");
    }

}

class Singleton4 {

    private volatile static Singleton4 single = null;
    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (single == null) {
            synchronized (Singleton4.class) {
                if (single == null)
                    single = new Singleton4();
            }
        }
        return single;
    }

    public void say() {
        System.out.println("双重检查锁懒汉单例");
    }

}


class Singleton5 {
    private static class InnerObject {
        static Singleton5 single = new Singleton5();
    }
    private Singleton5() {
    }

    static Singleton5 getInstance () {
        return InnerObject.single;
    }

    public void say() {
        System.out.println("静态内部类懒汉单例");
    }
}

