package javaExpo.Patterns.Factory;

public interface IDBFactory {

    void connect();

    void save();

    int get();

    void delete();
}
