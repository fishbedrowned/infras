package com.infras.model.mappers;

import com.infras.model.projos.PhoneCode;
import java.time.OffsetDateTime;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PhoneCodeMapper {
    @Delete({
        "delete from PhoneCode",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into PhoneCode (id, phone, ",
        "code, isRetry, triedTimes, ",
        "created)",
        "values (#{id,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{isRetry,jdbcType=BIT}, #{triedTimes,jdbcType=INTEGER}, ",
        "#{created,jdbcType=TIMESTAMP})"
    })
    int insert(PhoneCode record);

    @InsertProvider(type=PhoneCodeSqlProvider.class, method="insertSelective")
    int insertSelective(PhoneCode record);

    @Select({
        "select",
        "id, phone, code, isRetry, triedTimes, created",
        "from PhoneCode",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="isRetry", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="triedTimes", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    PhoneCode selectByPrimaryKey(Integer id);

    @Select("select * from PhoneCode where phone= #{phone} order by id desc limit 0,1")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="isRetry", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="triedTimes", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    PhoneCode selectByPhone(String phone);

    @UpdateProvider(type=PhoneCodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PhoneCode record);

    @Update({
        "update PhoneCode",
        "set phone = #{phone,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "isRetry = #{isRetry,jdbcType=BIT},",
          "triedTimes = #{triedTimes,jdbcType=INTEGER},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PhoneCode record);
}