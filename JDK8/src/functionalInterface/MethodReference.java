package functionalInterface;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 对象::实例方法
 * 类::静态方法
 * 类::实例方法
 * 类::new
 *
 * 是lambda表达式的简化
 */
public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("fasdfkljskladf");

        Consumer<String> consumer1 = System.out::println;
        consumer.accept("fboioi");

        Comparator<Integer> comparator = (a1,a2) -> Integer.compare(a1,a2);
        int compare = comparator.compare(3, 2);
        System.out.println(compare);

        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator1.compare(3, 2);
        System.out.println(compare1);

        Function<LocalDate, Integer> function = LocalDate::getDayOfMonth;
        Integer apply = function.apply(LocalDate.now());
        System.out.println(apply);

        Supplier<BankImpl> supplier = () -> new BankImpl();
        Supplier<BankImpl> supplier1 = BankImpl::new;
        System.out.println(supplier.get().hashCode());
        System.out.println(supplier1.get().hashCode());

    }
}
