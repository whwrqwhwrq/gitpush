public class Reflection_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Animal animal = new Dog();
        System.out.println("这只动物是"+animal.name);

        //方式一  ， 通过对象获得
        Class c1 = animal.getClass();
        //方式二 ，forName方法获得
        Class c2 = Class.forName("Dog");
        //方式三，通过类名.class获得
        Class c3 = Dog.class;
        //特殊方式：基本内置类型的包装类，可以用type属性获得类
        Class c4 = Integer.TYPE;
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
        System.out.println(c4);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}

class Animal {
    public String name;

    public Animal() {
    }
    public Animal(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

}

class Dog extends Animal{
    public Dog() {
        this.name = "小狗";
    }
}
class Cat extends Animal{
    public Cat() {
        this.name = "小猫";
    }
}