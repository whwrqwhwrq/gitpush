package functionalInterface;

public class BankImpl {
    public static void main(String[] args) {
        IBank AliPay = new IBank() {
            @Override
            public void service() {
                System.out.println("支付宝接入银行");
            }
        };
        AliPay.service();

        IBank AliPay1 = () -> System.out.println("支付宝接入银行1");

        AliPay1.service();

    }
}
