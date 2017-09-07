package com.infras.model.mappers;

import com.infras.model.projos.Menus;
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

public interface MenusMapper {
    @Delete({
        "delete from Menus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into Menus (id, name, ",
        "link, parent, deleted, ",
        "updated, created)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{link,jdbcType=VARCHAR}, #{parent,jdbcType=INTEGER}, #{deleted,jdbcType=BIT}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{created,jdbcType=TIMESTAMP})"
    })
    int insert(Menus record);

    @InsertProvider(type=MenusSqlProvider.class, method="insertSelective")
    int insertSelective(Menus record);

    @Select({
        "select",
        "id, name, link, parent, deleted, updated, created",
        "from Menus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="link", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parent", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deleted", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Menus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MenusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menus record);

    @Update({
        "update Menus",
        "set name = #{name,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=INTEGER},",
          "deleted = #{deleted,jdbcType=BIT},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menus record);
}