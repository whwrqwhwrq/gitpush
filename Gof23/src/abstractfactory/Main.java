package abstractfactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("华为手机：");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IMobileProduct iMobileProduct = huaweiFactory.mobileProduct();
        iMobileProduct.start();
        iMobileProduct.call();
        iMobileProduct.playGames();
        iMobileProduct.shutdown();
        System.out.println("-------------------------------------------------------------");
        System.out.println("小米手机：");
        IMobileProduct iMobileProduct1 = new XiaomiFactory().mobileProduct();
        iMobileProduct1.start();
        iMobileProduct1.call();
        iMobileProduct1.playGames();
        iMobileProduct1.shutdown();
        System.out.println("-------------------------------------------------------------");
        System.out.println("华为电视：");
        ITVProduct itvProduct = new HuaweiFactory().tvProduct();
        itvProduct.start();
        itvProduct.playVideo();
        itvProduct.connectPS4();
        itvProduct.shutdown();
        System.out.println("-------------------------------------------------------------");
        System.out.println("小米电视：");
        ITVProduct itvProduct1 = new XiaomiFactory().tvProduct();
        itvProduct1.start();
        itvProduct1.playVideo();
        itvProduct1.connectPS4();
        itvProduct1.shutdown();
    }
}
