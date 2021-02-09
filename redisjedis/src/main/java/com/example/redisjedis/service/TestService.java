package com.example.redisjedis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.redisjedis.bean.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/12/7 11:32
 */
@Service
public class TestService {
    private final Player player = new Player();

    private void a() {
        player.setGender("male");
        player.setName("wrq");
    }

    private void b() {
        player.setGender("female");
        player.setName("Lucy");
    }
    private void c() {
        player.setGender("male");
        player.setName("Jack");
    }
    public void main() {
        a();
        System.out.println(player);
        b();
        System.out.println(player);
        c();
        System.out.println(player);
    }

    public List<NameCls> testJSONArray() {
        ArrayList<NameCls> nameClsList = new ArrayList<>();

        String json = "{\n" +
                "\n" +
                "\"employees\": [\n" +
                "\n" +
                "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },\n" +
                "\n" +
                "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },\n" +
                "\n" +
                "{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray employees = jsonObject.getJSONArray("employees");
        for (int i = 0; i < employees.size(); i++) {
            String em = employees.get(i).toString();
            NameCls nameCls = JSON.parseObject(em, new TypeReference<NameCls>() {
            });
            System.out.println(nameCls);
            nameClsList.add(nameCls);
        }
        return nameClsList;
    }
    public static class NameCls {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "NameCls{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
