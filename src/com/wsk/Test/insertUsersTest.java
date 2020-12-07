package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


public class insertUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        Users users = new Users();
        users.setUsername("xiaohong");
        users.setUsersex("nv");

        int flag = usersMapper.insertUsers(users);
        sqlSession.commit();
        System.out.println(flag);
    }
}
