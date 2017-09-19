package com.infras.model.mappers;

import com.infras.model.enums.AdminStatus;
import com.infras.model.enums.Gender;
import com.infras.model.projos.AdminLogin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.time.OffsetDateTime;

public interface AdminLoginMapper {
    @Delete({
        "delete from AdminLogin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into AdminLogin (id, password, ",
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
    int insert(AdminLogin record);

    @InsertProvider(type=AdminLoginSqlProvider.class, method="insertSelective")
    int insertSelective(AdminLogin record);

    @Select({
        "select",
        "id, password, phone, email, name, thumbnail, gender, birth, status, updated, ",
        "created",
        "from AdminLogin",
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
        @Arg(column="birth", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=AdminStatus.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    AdminLogin selectByPrimaryKey(Integer id);


    @Select("select * from AdminLogin where id = #{id} and status = #{status}")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="thumbnail", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=Gender.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="birth", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=AdminStatus.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    AdminLogin selectByLoginId(@Param("id") Integer loginId, @Param("status") AdminStatus status);


    @Select("select * from AdminLogin where phone = #{phone}")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="thumbnail", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=Gender.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="birth", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=AdminStatus.class, typeHandler=EnumOrdinalTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    AdminLogin selectByPhone(String phone);

    @UpdateProvider(type=AdminLoginSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminLogin record);

    @Update({
        "update AdminLogin",
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
    int updateByPrimaryKey(AdminLogin record);
}