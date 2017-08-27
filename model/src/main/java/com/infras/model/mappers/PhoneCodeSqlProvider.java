package com.infras.model.mappers;

import com.infras.model.projos.PhoneCode;
import org.apache.ibatis.jdbc.SQL;

public class PhoneCodeSqlProvider {

    public String insertSelective(PhoneCode record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("PhoneCode");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRetry() != null) {
            sql.VALUES("isRetry", "#{isRetry,jdbcType=BIT}");
        }
        
        if (record.getTriedTimes() != null) {
            sql.VALUES("triedTimes", "#{triedTimes,jdbcType=INTEGER}");
        }
        
        if (record.getCreated() != null) {
            sql.VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PhoneCode record) {
        SQL sql = new SQL();
        sql.UPDATE("PhoneCode");
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRetry() != null) {
            sql.SET("isRetry = #{isRetry,jdbcType=BIT}");
        }
        
        if (record.getTriedTimes() != null) {
            sql.SET("triedTimes = #{triedTimes,jdbcType=INTEGER}");
        }
        
        if (record.getCreated() != null) {
            sql.SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}