package interfaceStudy;


public class PImpl implements PrivateMethodInInterface {
    public static void main(String[] args) {
        String[] strings = new String[]{"f","s","k"};

        PImpl p = new PImpl();
        p.printStr(strings);

        PrivateMethodInInterface.sout();
    }
}
