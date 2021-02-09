package wrq.mybatispage.manager;

import wrq.mybatispage.response.Response;

/**
 * @Author:wrq
 * @Date:2021/1/8 15:37
 */
public interface IFirstManager {
   Response getGoogleCollect();

   Response fillPlayFields();
   Response fillPlayFields0();
}
