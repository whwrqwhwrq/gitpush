package bean;

/**
 * @Author:wrq
 * @Date:2020/10/28 11:12
 */
public class Person {
    private String name;
    private Integer gender;
    private String country;

    public Person(String name, Integer gender, String country) {
        this.name = name;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                '}';
    }
}
