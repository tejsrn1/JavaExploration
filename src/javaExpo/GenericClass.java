package javaExpo;

// T used inside the angle bracket <> indicates the type parameter
public class GenericClass<T> {

    // variable of T type
    private T data;

    public GenericClass(T data) {
        this.data = data;
    }

    // method that return T type variable
    public T getData() {
        return data;
    }



    public <T> void genericMethods(T data){
        System.out.println("data received is " + data);

    }
}
