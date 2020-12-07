package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Orders;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectUsersByIdLazyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUsersByIdLazy(1);
        System.out.println(users);
        List<Orders> orders = users.getOrders();
        orders.forEach(System.out::println);
    }
}
