package abstractfactory;

public class HuaweiFactory implements IProductFactory{
    @Override
    public IMobileProduct mobileProduct() {
        return new HuaweiPhone();
    }

    @Override
    public ITVProduct tvProduct() {
        return new HuaweiTV();
    }
}
