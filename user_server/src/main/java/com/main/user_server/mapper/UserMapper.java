package com.main.user_server.mapper;

import com.main.api.dto.user_server.UserDataParm;
import com.main.api.model.User;
import com.main.api.model.example.UserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type = UserSqlProvider.class, method = "deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
            "delete from tbl_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
            "insert into tbl_user (user_id, user_phone, ",
            "user_name, user_password, ",
            "user_info, user_role, ",
            "gmt_create, gmt_modified)",
            "values (#{userId,jdbcType=BIGINT}, #{userPhone,jdbcType=CHAR}, ",
            "#{userName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ",
            "#{userInfo,jdbcType=VARCHAR}, #{userRole,jdbcType=TINYINT}, ",
            "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
    int insert(User record);

    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
    int insertSelective(User record);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.CHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_info", property = "userInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_role", property = "userRole", jdbcType = JdbcType.TINYINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByExample(UserExample example);

    @Select({
            "select",
            "user_id, user_phone, user_name, user_password, user_info, user_role, gmt_create, gmt_modified",
            "from tbl_user",
            "where user_phone = #{userPhone,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_info", property = "userInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_role", property = "userRole", jdbcType = JdbcType.TINYINT),
            @Result(column = "user_role", property = "userRole", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_role", property = "userRole", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByUserPhoneNumber(String userPhone);

    @Select({
            "select",
            "user_id, user_phone, user_name, user_password, user_info, user_role, gmt_create, ",
            "gmt_modified",
            "from tbl_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_phone", property = "userPhone", jdbcType = JdbcType.CHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_info", property = "userInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_role", property = "userRole", jdbcType = JdbcType.TINYINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Long userId);

    @Select({
            "select user_role",
            "from tbl_user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "user_role", jdbcType = JdbcType.BIGINT, javaType = Byte.class)
    })
    Byte selectUserRoleByPrimaryKey(Long userId);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update tbl_user",
            "set user_phone = #{userPhone,jdbcType=CHAR},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "user_password = #{userPassword,jdbcType=VARCHAR},",
            "user_info = #{userInfo,jdbcType=VARCHAR},",
            "user_role = #{userRole,jdbcType=TINYINT},",
            "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
            "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);

    @Update({
            "update tbl_user",
            "set user_name = #{userName,jdbcType=VARCHAR},",
            "user_password = #{userPassword,jdbcType=VARCHAR},",
            "user_info = #{userInfo,jdbcType=VARCHAR},",
            "user_role = #{userRole,jdbcType=TINYINT}",
            "gmt_modified = current_timestamp()",
            "where user_phone = #{userPhone,jdbcType=VARCHAR}"
    })
    int updateByPhoneNumber(UserDataParm userDataParm);
}