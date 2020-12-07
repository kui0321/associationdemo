package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Roles;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class selectUsersAndRolesTest {
    /**
     * 一对一关联查询映射
     */
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUsersAndRoles(2);
        System.out.println(users);
        Roles roles = users.getRoles();
        System.out.println(roles);
    }
}
