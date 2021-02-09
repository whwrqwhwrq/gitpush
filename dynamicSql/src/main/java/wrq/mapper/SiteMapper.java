package wrq.mapper;

import org.springframework.stereotype.Repository;
import wrq.beans.Site;

import java.util.List;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2020/10/27 16:29
 */
@Repository
public interface SiteMapper {
    int insert(Site site);

    List<Site> queryIf(Map map);

    List<Site> queryWhereChoose(Map map);

    int updateSite(Map map);

    List<Site> queryForeach(List<Long> pvList);

}
