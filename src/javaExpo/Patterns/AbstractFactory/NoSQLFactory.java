package javaExpo.Patterns.AbstractFactory;

import javaExpo.Patterns.AbstractFactory.NOSql.CassendraDB;
import javaExpo.Patterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.Patterns.AbstractFactory.NOSql.MongoDb;
import javaExpo.Patterns.AbstractFactory.RDMS.IRdbmsSQLDB;

public class NoSQLFactory extends AbstractFactory {
    @Override
    public INoSQLDB getNoSQLDB(String DbName) {
        switch (DbName) {
            case "Mongodb":
                return new MongoDb();

            case "Cassendra":
                return new CassendraDB();
            default:
                return null;
        }
    }

    @Override
    public IRdbmsSQLDB getRDBMSSqlDB(String DbName) {
//        throw new NotImplementedException();
        return  null;
    }
}
