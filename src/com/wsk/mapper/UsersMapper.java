package com.wsk.mapper;

import com.wsk.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    List<Users> selectUsersAll();
    Users selectUsersAndRoles(int userid);
    Users selectUsersAndOrders(int userid);
    Users selectUsersAndOrdersAndItems(int userid);
    Users selectUsersByIdLazy(int userid);


    //Mybatis注解的使用
    //    使用注解查询
    @Select("select * from users")
    List<Users> selectUserAll();

//    注解开发的传参方式
    //顺序传参法
    @Select("select * from users where username=#{param1} and usersex = #{param2}")
    List<Users> slectUserByNameAndSexOrder(String username,String usersex);

    @Select("select * from users where username=#{name} and usersex = #{sex}")
    List<Users> slectUserByNameAndSexOrder2(@Param("name") String usernaem, @Param("sex") String usersex);

    //POJO传参法
    @Select("select * from users where username=#{username} and usersex = #{usersex}")
    List<Users> slectUserByNameAndSexPOJO(Users users);

    //Map传参法
    @Select("select * from users where username=#{keyname} and usersex = #{keysex}")
    List<Users> slectUserByNameAndSexMap(Map<String, String> map);

    //用户添加
    @Insert("insert into users values (default, #{username},#{usersex})")
    int insertUsers(Users users);

    //更新用户
    @Update("update users set username=#{username}, usersex=#{usersex} where userid = #{userid}")
    int updateUsers(Users users);

    //删除用户
    @Delete("delete from users where userid = #{userid}")
    int deleteUsersById(int userid);

    //使用动态SQL的方式查询数据
    @Select("<script>select * from users where 1 = 1 <if test=\"username != null and username != ''\"> and username = #{username}</if> <if test=\"usersex != null and usersex != ''\"> and usersex = #{usersex}</if></script>")
    List<Users> selectUserByIdProperty(Users users);

    //在方法中构建SQL语句
    @SelectProvider(type = UserMapperProvider.class , method = "selectUserByIdPropertySql")
    List<Users> selectUserByIdPropertyProvider(Users users);
    class UserMapperProvider{
        /**
         * 生成 动态SQL语句
         */
        public String selectUserByIdPropertySql(Users users){
            StringBuffer sb = new StringBuffer("select * from users where 1=1");
            if (users.getUsername() != null && users.getUsername() != ""){
                sb.append(" and username = #{username}");
            }
            if (users.getUsersex() != null && users.getUsersex() !=""){
                sb.append(" and usersex = #{usersex}");
            }
            return sb.toString();
        }
    }

    @Select("select userid as id ,username as name,usersex as sex from users where userid = #{userid}")
    @Results(id = "UsersMapper" ,value = {
            @Result(id = true,property = "userid",column = "id"),
            @Result(property = "username",column = "name"),
            @Result(property = "usersex",column = "sex")
    })
    Users selectUsersByIdMapper(int userid);


    @Select("select userid as id ,username as name,usersex as sex from users where userid = #{userid}")
            @ResultMap(value = {"UsersMapper"})
    Users selectUsersByIdMapper1(int userid);

    //注解方式实现一对多关联查询
    @Select("select * from users where userid = #{userid}")
    @Results(id = "RolesMapper" ,value = {
            @Result(id = true,property = "userid",column = "userid"),
            @Result(property = "username",column = "username"),
            @Result(property = "usersex",column = "usersex"),
            @Result(property = "roles", column = "userid", one = @One(select = "com.wsk.mapper.RolesMapper.selectRolesByUsersId" ,fetchType = FetchType.LAZY))
    })
    Users selectUserAndRolesByUserId(int userid);


    //注解方式实现一对多的关联查询
    @Select("select * from users where userid = #{userid}")
    @Results(id = "OrderMapper" ,value = {
            @Result(id = true,property = "userid",column = "userid"),
            @Result(property = "username",column = "username"),
            @Result(property = "usersex",column = "usersex"),
            @Result(property = "orders", column = "userid", many = @Many(select = "com.wsk.mapper.OrderMapper.selectOrdersByUserId", fetchType = FetchType.LAZY))
    })
     Users selectUserAndOrderById(int userid);
}
