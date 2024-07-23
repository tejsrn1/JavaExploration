package aa_learning.java.designpattern.Factory;


public abstract class AbstractFactoryCreator {

    abstract IDBFactory getMeDbFactory(DBList dbs);

    public enum DBList {
        Mongodb,
        PostgreSQL;
    }
}
