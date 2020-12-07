package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class selectUsersByIdMapperTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        //Users users = usersMapper.selectUsersByIdMapper(1);
        Users users = usersMapper.selectUsersByIdMapper1(1);
        System.out.println(users);
    }
}
