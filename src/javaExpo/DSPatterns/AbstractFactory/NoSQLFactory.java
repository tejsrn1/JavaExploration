package javaExpo.DSPatterns.AbstractFactory;

import javaExpo.DSPatterns.AbstractFactory.NOSql.CassendraDB;
import javaExpo.DSPatterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.DSPatterns.AbstractFactory.NOSql.MongoDb;
import javaExpo.DSPatterns.AbstractFactory.RDMS.IRdbmsSQLDB;

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
