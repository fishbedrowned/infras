package com.infras.model.mappers;

import com.infras.model.projos.RoleMenus;
import org.apache.ibatis.jdbc.SQL;

public class RoleMenusSqlProvider {

    public String insertSelective(RoleMenus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("RoleMenus");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("roleId", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getMenuId() != null) {
            sql.VALUES("menuId", "#{menuId,jdbcType=INTEGER}");
        }
        
        if (record.getDeleted() != null) {
            sql.VALUES("deleted", "#{deleted,jdbcType=BIT}");
        }
        
        if (record.getUpdated() != null) {
            sql.VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated() != null) {
            sql.VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RoleMenus record) {
        SQL sql = new SQL();
        sql.UPDATE("RoleMenus");
        
        if (record.getRoleId() != null) {
            sql.SET("roleId = #{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getMenuId() != null) {
            sql.SET("menuId = #{menuId,jdbcType=INTEGER}");
        }
        
        if (record.getDeleted() != null) {
            sql.SET("deleted = #{deleted,jdbcType=BIT}");
        }
        
        if (record.getUpdated() != null) {
            sql.SET("updated = #{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated() != null) {
            sql.SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}