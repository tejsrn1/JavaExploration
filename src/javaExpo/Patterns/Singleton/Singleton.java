package javaExpo.Patterns.Singleton;

public class Singleton {

    private static Singleton privateInstance;
    private static final Object lockObj = new Object();

    private Singleton() {
    }


    public static Singleton getSingletonInstance() {

        synchronized (lockObj) {
            if (privateInstance == null) {
                privateInstance = new Singleton();

            }
            return privateInstance;
        }

    }
}
