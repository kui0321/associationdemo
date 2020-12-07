package com.wsk.mapper;

import com.wsk.pojo.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from orders where user_id = #{userid}")
    List<Orders> selectOrdersByUserId(int userid);
}
