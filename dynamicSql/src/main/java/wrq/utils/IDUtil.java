package wrq.utils;

import java.util.UUID;

/**
 * @Author:wrq
 * @Date:2020/10/27 16:34
 */
public class IDUtil {
    public static String getId() {
        String uuid = UUID.randomUUID().toString().replace("-","");

        return uuid;
    }

}
