package javaExpo.DSPatterns.Factory;

public class ConcreteFactoryCreator extends AbstractFactoryCreator {

    @Override
    IDBFactory getMeDbFactory(DBList dbs) {
        switch (dbs) {
            case Mongodb:
                return new MongoDb();

            case PostgreSQL:
                return new PostgreSQL();
            default:
                return null;
        }
    }
}
