package factorymethod;

public class TestlaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Testla();
    }
}
