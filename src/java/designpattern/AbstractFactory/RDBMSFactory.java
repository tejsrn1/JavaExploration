package aa_learning.java.designpattern.AbstractFactory;

import aa_learning.java.designpattern.AbstractFactory.NOSql.INoSQLDB;
import aa_learning.java.designpattern.AbstractFactory.RDMS.IRdbmsSQLDB;
import aa_learning.java.designpattern.AbstractFactory.RDMS.Oracle;
import aa_learning.java.designpattern.AbstractFactory.RDMS.SQLSERVER;

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
