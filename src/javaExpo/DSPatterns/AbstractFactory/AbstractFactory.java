package javaExpo.DSPatterns.AbstractFactory;

import javaExpo.DSPatterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.DSPatterns.AbstractFactory.RDMS.IRdbmsSQLDB;

public abstract class AbstractFactory {
    public abstract INoSQLDB getNoSQLDB(String DbName);
    public abstract IRdbmsSQLDB getRDBMSSqlDB(String DbName);
}
