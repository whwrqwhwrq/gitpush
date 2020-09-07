package abstractfactory;

public class XiaomiFactory implements IProductFactory{
    @Override
    public IMobileProduct mobileProduct() {
        return new XiaomiPhone();
    }

    @Override
    public ITVProduct tvProduct() {
        return new XiaomiTV();
    }
}
