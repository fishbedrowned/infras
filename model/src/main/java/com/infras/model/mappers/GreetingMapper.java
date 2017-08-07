package com.infras.model.mappers;

import com.infras.model.demo.Greeting;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhaoheng on 2017/7/7.
 */
public interface GreetingMapper {

    @Insert("insert into Greeting(name, age) values(#{name},#{age})")
    int insert(Greeting geet);

    @Select("select * from Greeting where id = #{id}")
    Greeting getGreetings(Integer id);
}
