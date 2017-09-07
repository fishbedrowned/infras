package com.infras.model.mappers;

import com.infras.model.projos.RoleMenus;
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

public interface RoleMenusMapper {
    @Delete({
        "delete from RoleMenus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into RoleMenus (id, roleId, ",
        "menuId, deleted, updated, ",
        "created)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{menuId,jdbcType=INTEGER}, #{deleted,jdbcType=BIT}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{created,jdbcType=TIMESTAMP})"
    })
    int insert(RoleMenus record);

    @InsertProvider(type=RoleMenusSqlProvider.class, method="insertSelective")
    int insertSelective(RoleMenus record);

    @Select({
        "select",
        "id, roleId, menuId, deleted, updated, created",
        "from RoleMenus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="roleId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="menuId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deleted", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    RoleMenus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RoleMenusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleMenus record);

    @Update({
        "update RoleMenus",
        "set roleId = #{roleId,jdbcType=INTEGER},",
          "menuId = #{menuId,jdbcType=INTEGER},",
          "deleted = #{deleted,jdbcType=BIT},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleMenus record);
}