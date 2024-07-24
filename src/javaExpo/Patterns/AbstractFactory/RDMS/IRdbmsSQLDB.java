package javaExpo.Patterns.AbstractFactory.RDMS;

public interface IRdbmsSQLDB {
    void  getData();
    void  writeData();
    void  CreateTransaction();
}
