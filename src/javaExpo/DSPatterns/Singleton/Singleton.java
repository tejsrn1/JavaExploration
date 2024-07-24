package javaExpo.DSPatterns.Singleton;

public class Singleton {

    private static Singleton privateInstance;
    private static Object lockObj = new Object();

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
