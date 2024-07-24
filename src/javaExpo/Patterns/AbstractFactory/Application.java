package javaExpo.Patterns.AbstractFactory;

import javaExpo.Patterns.AbstractFactory.NOSql.INoSQLDB;
import javaExpo.Patterns.AbstractFactory.RDMS.IRdbmsSQLDB;

public class Application {

    public static void main(String[] args) {

        AbstractFactory nosqlfctry = FactoryProducer.getFactory("noSQL");

        INoSQLDB cassendara = nosqlfctry.getNoSQLDB("Cassendara");
        cassendara.writeData();
        cassendara.getData();


        INoSQLDB mongodb = nosqlfctry.getNoSQLDB("Mopngodb");
        mongodb.writeData();
        mongodb.getData();

        //---------


        AbstractFactory rdbmsfactry = FactoryProducer.getFactory("rdbms");

        IRdbmsSQLDB oracle = rdbmsfactry.getRDBMSSqlDB("oracle");
        oracle.CreateTransaction();
        oracle.writeData();
        oracle.getData();

        IRdbmsSQLDB sqlserver =rdbmsfactry.getRDBMSSqlDB("sqlserver");
        sqlserver.CreateTransaction();
        sqlserver.writeData();
        sqlserver.getData();

    }
}
