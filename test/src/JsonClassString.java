import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/11/19 14:35
 */
public class JsonClassString {
    public static void main(String[] args) {


        Installment installment = new Installment();
        installment.setInstallmenttype("1");
        installment.setInstallmentnum("2");
        GoodInfo goodInfo = new GoodInfo();
        goodInfo.setId("1");
        goodInfo.setName("2");
        ArrayList<GoodInfo> goodsInfo = new ArrayList<>();
        goodsInfo.add(goodInfo);
        RiskInfo riskInfo = new RiskInfo();
        ReceiverInfo receiverInfo = new ReceiverInfo();

        CustInfo custInfo = new CustInfo();
        custInfo.setInstallment(installment);
        custInfo.setGoodsInfo(goodsInfo);
        custInfo.setRiskInfo(riskInfo);
        custInfo.setReceiverInfo(receiverInfo);


        String custInfoJson = JSON.toJSONString(custInfo);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","a");
        jsonObject.put("b",custInfo);
        jsonObject.put("c",custInfoJson);
        System.out.println(jsonObject.toString());

        System.out.println(custInfo);

        System.out.println(custInfoJson);
    }

    static class Installment {
        private String installmenttype;
        private String installmentnum;

        public String getInstallmenttype() {
            return installmenttype;
        }

        public void setInstallmenttype(String installmenttype) {
            this.installmenttype = installmenttype;
        }

        public String getInstallmentnum() {
            return installmentnum;
        }

        public void setInstallmentnum(String installmentnum) {
            this.installmentnum = installmentnum;
        }

        @Override
        public String toString() {
            return "Installment{" +
                    "installmenttype='" + installmenttype + '\'' +
                    ", installmentnum='" + installmentnum + '\'' +
                    '}';
        }
    }

    static class GoodInfo {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "GoodInfo{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class RiskInfo {
        private Integer a;
        private String b;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "RiskInfo{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }
    static class ReceiverInfo {
        private Integer a;
        private String b;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "ReceiverInfo{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

    static class CustInfo {
        private Installment installment;
        private List<GoodInfo> goodsInfo;
        private RiskInfo riskInfo;
        private ReceiverInfo receiverInfo;

        public Installment getInstallment() {
            return installment;
        }

        public void setInstallment(Installment installment) {
            this.installment = installment;
        }

        public List<GoodInfo> getGoodsInfo() {
            return goodsInfo;
        }

        public void setGoodsInfo(List<GoodInfo> goodsInfo) {
            this.goodsInfo = goodsInfo;
        }

        public RiskInfo getRiskInfo() {
            return riskInfo;
        }

        public void setRiskInfo(RiskInfo riskInfo) {
            this.riskInfo = riskInfo;
        }

        public ReceiverInfo getReceiverInfo() {
            return receiverInfo;
        }

        public void setReceiverInfo(ReceiverInfo receiverInfo) {
            this.receiverInfo = receiverInfo;
        }

        @Override
        public String toString() {
            return "CustInfo{" +
                    "installment=" + installment +
                    ", goodsInfo=" + goodsInfo +
                    ", riskInfo=" + riskInfo +
                    ", receiverInfo=" + receiverInfo +
                    '}';
        }
    }

}
