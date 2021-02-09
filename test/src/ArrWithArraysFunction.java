import java.util.Arrays;

public class ArrWithArraysFunction {
    public static void main(String[] args) {
        double[] doubles = new double[]{0.2, 3.312, 3, 545.342, 44, 354.2};
        double[] doubles1 = new double[100];

        Arrays.parallelSort(doubles);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

        System.out.println("_____________________________________________");

        Arrays.parallelPrefix(doubles, (a, b) -> {
            return a * b + 1;
        });
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

        System.out.println("_____________________________________________");

        Arrays.parallelSetAll(doubles1, (value) -> {
            //value 参数代表数组元素的索引 从0 到 length - 1
            return (value / 2 + 0.9);
        });
        //每行输出十八个
        int rowCount = 18;
        int currentNo = 1;
        for (double aDouble : doubles1) {
            System.out.print(aDouble);
            System.out.print("  ");
            if (currentNo % rowCount == 0) {
                System.out.println();
            }
            currentNo++;
        }
    }
}
