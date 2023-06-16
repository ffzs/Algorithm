package SimpleFactory;


import java.lang.reflect.InvocationTargetException;

public interface Fruit {
    void whatIm () throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, Exception;
}
