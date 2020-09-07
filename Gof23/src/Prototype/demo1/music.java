package Prototype.demo1;

import java.util.Date;

public class music implements Cloneable{
    private String name;
    private int during;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
