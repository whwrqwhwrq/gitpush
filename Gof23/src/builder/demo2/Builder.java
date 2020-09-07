package builder.demo2;


public abstract class Builder {
    abstract Builder hamburger(String msg); //汉堡
    abstract Builder french_fries(String msg);//薯条
    abstract Builder cola(String msg);//可乐

    //完工
    abstract Combo getCombo();
}
