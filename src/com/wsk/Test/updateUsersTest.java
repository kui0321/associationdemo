package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class updateUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("hong");
        users.setUsersex("nv");
        users.setUserid(17);
        int flag = usersMapper.updateUsers(users);
        sqlSession.commit();
        System.out.println(flag);
    }
}
