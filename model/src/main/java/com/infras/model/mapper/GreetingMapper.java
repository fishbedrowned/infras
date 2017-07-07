package com.infras.model.mapper;

import com.infras.model.demo.Greeting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhaoheng on 2017/7/7.
 */
public interface GreetingMapper {

    @Insert("insert into Greeting(id,name) values(#{id},#{name})")
    int insert(Greeting geet);

    @Select("select id, name from Greeting where id = #{id}")
    Greeting getGreetings(Integer id);
}
