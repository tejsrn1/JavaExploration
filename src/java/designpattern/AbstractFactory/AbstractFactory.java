package aa_learning.java.designpattern.AbstractFactory;

import aa_learning.java.designpattern.AbstractFactory.NOSql.INoSQLDB;
import aa_learning.java.designpattern.AbstractFactory.RDMS.IRdbmsSQLDB;

public abstract class AbstractFactory {
    public abstract INoSQLDB getNoSQLDB(String DbName);
    public abstract IRdbmsSQLDB getRDBMSSqlDB(String DbName);
}
