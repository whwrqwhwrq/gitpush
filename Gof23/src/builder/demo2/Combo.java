package builder.demo2;

public class Combo {
    private String hamburger = "普通汉堡";
    private String french_fries = "小份薯条";
    private String cola = "小份可乐";

    public String getHamburger() {
        return hamburger;
    }

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public String getFrench_fries() {
        return french_fries;
    }

    public void setFrench_fries(String french_fries) {
        this.french_fries = french_fries;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "hamburger='" + hamburger + '\'' +
                ", french_fries='" + french_fries + '\'' +
                ", cola='" + cola + '\'' +
                '}';
    }
}
