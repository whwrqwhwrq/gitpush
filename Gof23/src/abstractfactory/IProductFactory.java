package abstractfactory;
//抽象工厂，用来生产手机   和 电视
public interface IProductFactory {
    //生产手机
    IMobileProduct mobileProduct();

    //生产电视
    ITVProduct tvProduct();
}
