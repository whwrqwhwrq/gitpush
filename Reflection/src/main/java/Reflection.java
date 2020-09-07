

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的  class 对象
        Class class1 = Class.forName("Student");
        Class class2 = Class.forName("Student");
        Class class3 = Class.forName("Student");
        Class class4 = Class.forName("Student");

        System.out.println(class1.hashCode());
        System.out.println(class2.hashCode());
        System.out.println(class3.hashCode());
        System.out.println(class4.hashCode());
        //hashcode都一样，内存中只有一个class对象。一个类被加载后，类的整个结构会被封装在Class对象中。

    }

}

class Student {
    private String name;
    private String gender;
    private String school;

    public Student(String name, String gender, String school) {
        this.name = name;
        this.gender = gender;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student() {
    }
}