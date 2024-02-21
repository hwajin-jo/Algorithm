package LCT;

public class MyClass {

    private final String name;
    private final int age;

    private MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void print() {
        System.out.println(name + " : " + age);
    }
}
