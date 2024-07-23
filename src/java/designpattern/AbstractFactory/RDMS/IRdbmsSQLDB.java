package aa_learning.java.designpattern.AbstractFactory.RDMS;

public interface IRdbmsSQLDB {
    void  getData();
    void  writeData();
    void  CreateTransaction();
}
