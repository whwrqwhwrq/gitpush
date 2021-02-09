package wrq.mybatispage.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wrq.mybatispage.pojo.Country;
import wrq.mybatispage.response.Response;
import wrq.mybatispage.service.ICountryService;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/1/8 14:19
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/get/all/{pageNum}/{pageSize}")
    public List<Country> getAllCountry(@PathVariable Integer pageNum,
                                       @PathVariable Integer pageSize) {
        return countryService.getAllCountry(pageNum, pageSize);
    }


    @GetMapping("get/all")
    public List<Country> getAllCountryWithoutPage() {
        return countryService.getAllCountry();
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody Country country) {
        System.out.println(country);
        int flag = 0;
        try {
            flag = countryService.insert(country);
        } catch (ArithmeticException arithmeticException) {
            return Response.buildFailureResponse("服务器业务逻辑异常");
        }
        if (flag == 1) {
            return Response.buildSuccessResponse("执行成功");
        } else {
            return Response.buildFailureResponse("执行失败");
        }
    }

    @PutMapping("/testPut")
    public Response testPut(@RequestBody Country country) {
        System.out.println(country);
        return Response.buildSuccessResponse("测试");
    }

    @GetMapping("/testGetObj")
    public Response testGetObj(Country country) {
        System.out.println(country);
        return Response.buildSuccessResponse("test success");
    }

    @GetMapping("/testPathvariable/{param}")
    public Response testPathvariable(@PathVariable("param") String param) {
        Country country = JSON.parseObject(param, Country.class);
        System.out.println(country);
        return Response.buildSuccessResponse("test success");
    }

}
