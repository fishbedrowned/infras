package com.infras.model.mappers;

import com.infras.model.projos.AdminRole;
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

public interface AdminRoleMapper {
    @Delete({
        "delete from AdminRole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into AdminRole (id, loginId, ",
        "roleId, deleted, updated, ",
        "created)",
        "values (#{id,jdbcType=INTEGER}, #{loginId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER}, #{deleted,jdbcType=BIT}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{created,jdbcType=TIMESTAMP})"
    })
    int insert(AdminRole record);

    @InsertProvider(type=AdminRoleSqlProvider.class, method="insertSelective")
    int insertSelective(AdminRole record);

    @Select({
        "select",
        "id, loginId, roleId, deleted, updated, created",
        "from AdminRole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="loginId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="roleId", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deleted", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    AdminRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdminRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminRole record);

    @Update({
        "update AdminRole",
        "set loginId = #{loginId,jdbcType=INTEGER},",
          "roleId = #{roleId,jdbcType=INTEGER},",
          "deleted = #{deleted,jdbcType=BIT},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdminRole record);
}