package cn.smart.service.impl;

import cn.smart.pojo.Users;
import cn.smart.service.UserService;
import cn.smart.util.HttpClientUtil;
import cn.smart.util.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(Users users) {
        String code = HttpClientUtil.doPostJson("http://localhost:80/user/insertUser", JsonUtils.objectToJson(users));
        Map<String,Integer> map = JsonUtils.jsonToPojo(code,Map.class);
        assert map != null;
        Integer var = map.get("code");
        if (var == 500){
            System.out.println("出错了");
        }else {
            System.out.println("添加成功");
        }
    }

    @Override
    public List<Users> findUserAll() {
        String users = HttpClientUtil.doPost("http://localhost:80/user/selectUserAll");
        return JsonUtils.jsonToList(users,Users.class);
    }
}
