package f;



//  枚举类 不支持  lombok
public enum games {

    LOL(1,"英雄联盟"),CSGO(2,"反恐精英：全球攻势");
    private int index;
    private String name;

    games(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "games{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
