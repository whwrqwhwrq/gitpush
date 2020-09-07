package Prototype.demo2;

import java.util.Date;

public class Recorder {
    public static void main(String[] args) throws CloneNotSupportedException {
//原型对象
        Date date = new Date();
        music music = new music();
        music.setName("我曾");
        music.setDuring(180);
        music.setDate(date);
        System.out.println(music.toString()+"   "+music.hashCode());

        music music1 = (Prototype.demo2.music) music.clone();
        System.out.println(music1.toString()+"   "+music1.hashCode());
        System.out.println("---------------------------------------------");
//        music.setDate(new Date());
        date.setTime(32423423);
        music.setName("mmmm");
        System.out.println(music.toString());
        System.out.println(music1.toString());
    }
}
