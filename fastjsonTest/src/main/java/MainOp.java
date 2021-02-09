import bean.Person;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2020/10/28 11:14
 */

public class MainOp {
    public static void main(String[] args) {
        Person person = new Person("a", 0, "中国");
        Person person2 = new Person("b", 1, "美国");
        Person person3 = new Person("c", 1, "日本");


        ArrayList<Person> people = new ArrayList<Person>();
        Map<String, Object> personMap = new HashMap<String, Object>();

        people.add(person);
        people.add(person2);
        people.add(person3);
        String toJSONString = JSON.toJSONString(people);

        personMap.put(person.getName(),person);
        personMap.put(person2.getName(),person2);
        personMap.put(person3.getName(),person3);

        String jsonString = JSON.toJSONString(personMap);

        System.out.println(jsonString);
        System.out.println(toJSONString);
    }
}
