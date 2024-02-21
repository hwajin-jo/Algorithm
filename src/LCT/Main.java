package LCT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        final Class<MyClass> clazz = MyClass.class;

        final Constructor<MyClass> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        final MyClass myClass = constructor.newInstance("호랭", 10);

        final Method declaredMethod = clazz.getDeclaredMethod("print");
        declaredMethod.setAccessible(true);

        declaredMethod.invoke(myClass);
    }
}
