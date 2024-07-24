package javaExpo.Patterns.AbstractFactory;

import javaExpo.Patterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.Patterns.AbstractFactory.RDMS.IRdbmsSQLDB;
import javaExpo.Patterns.AbstractFactory.RDMS.Oracle;
import javaExpo.Patterns.AbstractFactory.RDMS.SQLSERVER;

public class RDBMSFactory extends AbstractFactory {
    @Override
    public INoSQLDB getNoSQLDB(String DbName) {
        // throw new NotImplementedException();
        return null;
    }

    @Override
    public IRdbmsSQLDB getRDBMSSqlDB(String DbName) {
        switch (DbName) {
            case "SQLServer":
                return new SQLSERVER();

            case "Oracle":
                return new Oracle();
            default:
                return null;
        }
    }
}
