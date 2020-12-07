package com.wsk.mapper;

import com.wsk.pojo.Roles;
import org.apache.ibatis.annotations.Select;

public interface RolesMapper {
    @Select("select * from roles where user_id = #{userid}")
    Roles selectRolesByUsersId(int userid);
}
