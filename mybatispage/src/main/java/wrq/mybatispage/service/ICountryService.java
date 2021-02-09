package wrq.mybatispage.service;

import wrq.mybatispage.pojo.Country;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/8 14:20
 */
public interface ICountryService {
    List<Country> getAllCountry(Integer pageNum, Integer pageSize);
    List<Country> getAllCountry();

    int insert(Country country) throws ArithmeticException;
}
