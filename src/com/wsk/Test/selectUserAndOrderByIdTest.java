package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Orders;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectUserAndOrderByIdTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUserAndOrderById(2);
        System.out.println(users);
        List<Orders> list = users.getOrders();
        list.forEach(System.out::println);
    }
}
