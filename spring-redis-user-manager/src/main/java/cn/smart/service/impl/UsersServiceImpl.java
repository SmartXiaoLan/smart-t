package cn.smart.service.impl;

import cn.smart.commons.JsonUtils;
import cn.smart.jedisdao.JedisDao;
import cn.smart.mapper.UsersMapper;
import cn.smart.pojo.Users;
import cn.smart.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private JedisDao jedisDao;

    @Autowired
    private UsersMapper usersMapper;

    //Customize prefix key
    @Value("${REDIS_USERS_PRIFX}")
    private String REDIS_USERS_PRIFX;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public Users queryUserById(Integer userid) {
        String rUser = null;
        try {
            //Query Cache for Redis
            rUser = this.jedisDao.get(this.REDIS_USERS_PRIFX + ":" + userid);
            //have cache data
            if (rUser != null && rUser.length() > 0) {
                //Have Data
                return JsonUtils.jsonToPojo(rUser, Users.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query MySQL or Other DataBase
        Users user = this.usersMapper.findUserById(userid);
        try {
            //add data to Redis
            this.jedisDao.set(this.REDIS_USERS_PRIFX + ":" + userid, JsonUtils.objectToJson(user));
            //setting redis key expire
            this.jedisDao.expire(this.REDIS_USERS_PRIFX + ":" + userid, 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void modifyUserById(Users users) {
        this.usersMapper.updateUser(users);
        try {
            //Sync redis data
            this.jedisDao.del(REDIS_USERS_PRIFX + ":" + users.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
