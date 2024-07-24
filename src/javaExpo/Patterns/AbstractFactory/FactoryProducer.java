package javaExpo.Patterns.AbstractFactory;

//This is Factory of other factories. and makes pattern.
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equals("NosQLFactory")) {
            return new NoSQLFactory();
        }
        if (factoryName.equals("RDBMSFactory")) {
            return new RDBMSFactory();
        }
        return null;

    }
}
