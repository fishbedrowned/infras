package com.infras.model.mappers;

import com.infras.model.projos.AdminLogin;
import org.apache.ibatis.jdbc.SQL;

public class AdminLoginSqlProvider {

    public String insertSelective(AdminLogin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("AdminLogin");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getThumbnail() != null) {
            sql.VALUES("thumbnail", "#{thumbnail,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.VALUES("gender", "#{gender,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}");
        }
        
        if (record.getBirth() != null) {
            sql.VALUES("birth", "#{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}");
        }
        
        if (record.getUpdated() != null) {
            sql.VALUES("updated", "#{updated,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreated() != null) {
            sql.VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AdminLogin record) {
        SQL sql = new SQL();
        sql.UPDATE("AdminLogin");
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getThumbnail() != null) {
            sql.SET("thumbnail = #{thumbnail,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.SET("gender = #{gender,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}");
        }
        
        if (record.getBirth() != null) {
            sql.SET("birth = #{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}");
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