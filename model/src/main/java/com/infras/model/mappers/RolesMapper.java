package com.infras.model.mappers;

import com.infras.model.projos.Roles;
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

public interface RolesMapper {
    @Delete({
        "delete from Roles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into Roles (id, name, ",
        "deleted, updated, ",
        "created)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{deleted,jdbcType=BIT}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{created,jdbcType=TIMESTAMP})"
    })
    int insert(Roles record);

    @InsertProvider(type=RolesSqlProvider.class, method="insertSelective")
    int insertSelective(Roles record);

    @Select({
        "select",
        "id, name, deleted, updated, created",
        "from Roles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="deleted", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="updated", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=OffsetDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Roles selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RolesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Roles record);

    @Update({
        "update Roles",
        "set name = #{name,jdbcType=VARCHAR},",
          "deleted = #{deleted,jdbcType=BIT},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Roles record);
}