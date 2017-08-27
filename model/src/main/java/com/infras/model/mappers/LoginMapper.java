package com.infras.model.mappers;

import com.infras.model.enums.Gender;
import com.infras.model.enums.Status;
import com.infras.model.projos.Login;
import java.time.OffsetDateTime;
import java.util.Date;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;

public interface LoginMapper {
    @Delete({
        "delete from Login",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into Login (id, password, ",
        "phone, email, name, ",
        "thumbnail, gender, ",
        "birth, status, ",
        "updated, created)",
        "values (#{id,jdbcType=INTEGER}, #{password,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{thumbnail,jdbcType=VARCHAR}, #{gender,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}, ",
        "#{birth,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{created,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true)
    int insert(Login record);

    @InsertProvider(type=LoginSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true)
    int insertSelective(Login record);

    @Select({
        "select",
        "id, password, phone, email, name, thumbnail, gender, birth, status, updated, ",
        "created",
        "from Login",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="thumbnail", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=Gender.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="birth", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=Status.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Login selectByPrimaryKey(Integer id);

    @Select("select * from Login where phone = #{phone}")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="thumbnail", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=Gender.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="birth", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=Status.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Login selectByPhone(String phone);

    @UpdateProvider(type=LoginSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Login record);

    @Update({
        "update Login",
        "set password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "thumbnail = #{thumbnail,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler},",
          "birth = #{birth,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Login record);
}