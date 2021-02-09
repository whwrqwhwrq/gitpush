package wrq.mybatis.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/13 15:40
 */
public class CsfResponseObject implements Serializable {
    private List<Object> beans;

    public List getBeans() {
        return beans;
    }

    public void setBeans(List beans) {
        this.beans = beans;
    }
}
