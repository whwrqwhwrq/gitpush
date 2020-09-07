package Prototype.demo2;

import java.util.Date;

public class music implements Cloneable{
    private String name;
    private int during;
    private Date date;
    //深克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
//        进行深克隆操作
        music m = (music) object;
        m.date = (Date) this.date.clone();
        return object;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public music() {
    }

    public music(String name, int during) {
        this.name = name;
        this.during = during;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }

    @Override
    public String toString() {
        return "music{" +
                "name='" + name + '\'' +
                ", during=" + during +
                ", date=" + date +
                '}';
    }
}
