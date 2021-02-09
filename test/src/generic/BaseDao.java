package generic;

import java.util.List;

public interface BaseDao <T> {
    List<T> getAll();
    Boolean delete();

    Boolean update(T t);

    Boolean copy(T[] n, List<? extends Number> nList);
}
