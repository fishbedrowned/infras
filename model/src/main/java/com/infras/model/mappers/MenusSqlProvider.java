package com.infras.model.mappers;

import com.infras.model.projos.Menus;
import org.apache.ibatis.jdbc.SQL;

public class MenusSqlProvider {

    public String insertSelective(Menus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("Menus");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLink() != null) {
            sql.VALUES("link", "#{link,jdbcType=VARCHAR}");
        }
        
        if (record.getParent() != null) {
            sql.VALUES("parent", "#{parent,jdbcType=INTEGER}");
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

    public String updateByPrimaryKeySelective(Menus record) {
        SQL sql = new SQL();
        sql.UPDATE("Menus");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{link,jdbcType=VARCHAR}");
        }
        
        if (record.getParent() != null) {
            sql.SET("parent = #{parent,jdbcType=INTEGER}");
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