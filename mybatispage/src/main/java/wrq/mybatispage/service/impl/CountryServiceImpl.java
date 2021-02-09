package wrq.mybatispage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wrq.mybatispage.dao.CountryDao;
import wrq.mybatispage.pojo.Country;
import wrq.mybatispage.service.ICountryService;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/8 14:21
 */
@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryDao countryDao;
    @Override
    public List<Country> getAllCountry(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Country> allCountry = countryDao.getAllCountry();
        PageInfo<Country> countryPageInfo = new PageInfo<>(allCountry);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("总条数：");
        stringBuffer.append(countryPageInfo.getTotal()).append("  ");
        stringBuffer.append("总页数：");
        stringBuffer.append(countryPageInfo.getPages()).append("  ");
        stringBuffer.append("当前页：");
        stringBuffer.append(countryPageInfo.getPageNum()).append("  ");
        stringBuffer.append("一页的容量：");
        stringBuffer.append(countryPageInfo.getPageSize()).append("  ");

        System.out.println(stringBuffer.toString());
        return countryPageInfo.getList();
    }

    @Override
    public List<Country> getAllCountry() {
        return countryDao.getAllCountry();
    }

    @Override
    @Transactional
    public int insert(Country country) throws ArithmeticException{
        int flag = countryDao.insertCountry(country);
        System.out.println(flag);
        if (flag == 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

        int a = 1 / 0;
        return flag;
    }
}
