package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class slectUserByNameAndSexOrderTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> users = usersMapper.slectUserByNameAndSexOrder("LEFT","nice");
        users.forEach(System.out::println);
    }
}
