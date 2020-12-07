package com.wsk.Test;

import com.wsk.mapper.UsersMapper;
import com.wsk.pojo.Users;
import com.wsk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class slectUserByNameAndSexMapTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

        Map<String, String> map = new HashMap<>();
        map.put("keyname", "huahua1");
        map.put("keysex", "nice");

        List<Users> list = usersMapper.slectUserByNameAndSexMap(map);
        list.forEach(System.out::println);
    }


}
