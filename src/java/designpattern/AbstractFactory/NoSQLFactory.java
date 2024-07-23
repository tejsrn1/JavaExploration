package aa_learning.java.designpattern.AbstractFactory;

import aa_learning.java.designpattern.AbstractFactory.NOSql.CassendraDB;
import aa_learning.java.designpattern.AbstractFactory.NOSql.INoSQLDB;
import aa_learning.java.designpattern.AbstractFactory.NOSql.MongoDb;
import aa_learning.java.designpattern.AbstractFactory.RDMS.IRdbmsSQLDB;

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
