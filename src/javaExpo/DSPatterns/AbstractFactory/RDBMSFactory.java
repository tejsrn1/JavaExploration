package javaExpo.DSPatterns.AbstractFactory;

import javaExpo.DSPatterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.DSPatterns.AbstractFactory.RDMS.IRdbmsSQLDB;
import javaExpo.DSPatterns.AbstractFactory.RDMS.Oracle;
import javaExpo.DSPatterns.AbstractFactory.RDMS.SQLSERVER;

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
