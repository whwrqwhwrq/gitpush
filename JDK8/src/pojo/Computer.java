package pojo;

import java.util.Objects;

public class Computer {
    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Computer() {
    }

    public Computer(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return brand.equals(computer.brand) &&
                price.equals(computer.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price);
    }
}
