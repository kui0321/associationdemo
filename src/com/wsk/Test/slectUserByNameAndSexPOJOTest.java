package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class slectUserByNameAndSexPOJOTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("limin");
        users.setUsersex("nan");
        List<Users> list = usersMapper.slectUserByNameAndSexPOJO(users);
        list.forEach(System.out::println);
    }
}
