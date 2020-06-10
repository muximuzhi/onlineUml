package com.onlineUml.item.service;

import com.onlineUml.item.mapper.UserMapper;
import com.onlineUml.item.pojo.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 注册用户
     * @param name
     * @param password
     */
    public void addUser(String name, String password) {
        User tempUser = new User();
        tempUser.setName(name);
        tempUser.setHead_pic("src/main/resources/defaultHead.jpeg");
        tempUser.setPassword(password);
        this.userMapper.insertSelective(tempUser);
    }

    /**
     * 登录，成功返回1，失败返回0
     * @param name
     * @param password
     * @return
     */
    public boolean checkUser(String name, String password) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", name).
                andEqualTo("password", password);
        if(this.userMapper.selectCountByExample(example) != 0) return true;
        else return false;
    }
}
