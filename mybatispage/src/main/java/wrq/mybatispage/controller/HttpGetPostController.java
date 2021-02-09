package wrq.mybatispage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wrq.mybatispage.manager.IFirstManager;
import wrq.mybatispage.pojo.Country;
import wrq.mybatispage.response.Response;

/**
 * @Author:wrq
 * @Date:2021/1/8 15:44
 */
@RestController
public class HttpGetPostController {
    @Autowired
    private IFirstManager firstManager;

    @PostMapping("/post")
    public Response test(@RequestBody Country country) {
        System.out.println(country.getName());
        System.out.println(country.getCapital());
        System.out.println(country.getContinent());
        System.out.println(country);
        return firstManager.getGoogleCollect();
    }

    @GetMapping("")
    public Response test() {
        return firstManager.getGoogleCollect();
    }

    @GetMapping("/fill/fields/restful")
    public Response test1() {
        return firstManager.fillPlayFields();
    }
    @GetMapping("/fill/fields/noRestful")
    public Response test2() {
        return firstManager.fillPlayFields0();
    }

}
