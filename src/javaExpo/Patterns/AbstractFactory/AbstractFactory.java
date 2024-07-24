package javaExpo.Patterns.AbstractFactory;

import javaExpo.Patterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.Patterns.AbstractFactory.RDMS.IRdbmsSQLDB;

public abstract class AbstractFactory {
    public abstract INoSQLDB getNoSQLDB(String DbName);

    public abstract IRdbmsSQLDB getRDBMSSqlDB(String DbName);
}
