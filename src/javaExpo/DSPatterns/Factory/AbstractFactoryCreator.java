package javaExpo.DSPatterns.Factory;


public abstract class AbstractFactoryCreator {

    abstract IDBFactory getMeDbFactory(DBList dbs);

    public enum DBList {
        Mongodb,
        PostgreSQL;
    }
}
