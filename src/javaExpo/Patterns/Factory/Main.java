package javaExpo.Patterns.Factory;

public class Main {

    public static void main(String[] args) {
        AbstractFactoryCreator factory = new ConcreteFactoryCreator();
        IDBFactory mdb = factory.getMeDbFactory(AbstractFactoryCreator.DBList.Mongodb);
        IDBFactory pdb = factory.getMeDbFactory(AbstractFactoryCreator.DBList.PostgreSQL);
    }
}
