package wrq.mybatispage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import wrq.mybatispage.pojo.Country;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/8 14:08
 */
@Repository
@Mapper
public interface CountryDao {
    List<Country> getAllCountry();

    int insertCountry(Country country);

    int testInsert(Country country);
}
