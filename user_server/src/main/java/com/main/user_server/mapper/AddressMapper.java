package com.main.user_server.mapper;

import com.main.api.dto.user_server.UpdateAddressParm;
import com.main.api.model.Address;
import com.main.api.model.example.AddressExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface AddressMapper {
    @SelectProvider(type = AddressSqlProvider.class, method = "countByExample")
    long countByExample(AddressExample example);

    @DeleteProvider(type = AddressSqlProvider.class, method = "deleteByExample")
    int deleteByExample(AddressExample example);

    @Delete({
            "delete from tbl_address",
            "where addr_id = #{addrId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long addrId);

    @Delete({
            "delete from tbl_address",
            "where addr_id = #{addrId,jdbcType=BIGINT}",
            "and addr_user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByAddrIdAndUserId(@Param("addrId") Long addrId, @Param("userId") Long userId);

    @Insert({
            "insert into tbl_address (addr_user_id, ",
            "addr_info) ",
            "values (#{addrUserId,jdbcType=BIGINT}, ",
            "#{addrInfo,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "addr_id", keyProperty = "addrId")
    int insert(Address record);

    @InsertProvider(type = AddressSqlProvider.class, method = "insertSelective")
    int insertSelective(Address record);

    @SelectProvider(type = AddressSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "addr_id", property = "addrId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "addr_user_id", property = "addrUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "addr_info", property = "addrInfo", jdbcType = JdbcType.VARCHAR)
    })
    List<Address> selectByExample(AddressExample example);

    @Select({
            "select",
            "addr_id, addr_user_id, addr_info, gmt_create, gmt_modified",
            "from tbl_address",
            "where addr_id = #{addrId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "addr_id", property = "addrId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "addr_user_id", property = "addrUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "addr_info", property = "addrInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    Address selectByPrimaryKey(Long addrId);

    @Select({
            "select",
            "addr_id, addr_user_id, addr_info, gmt_create, gmt_modified",
            "from tbl_address",
            "where addr_user_id = #{addrUserId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "addr_id", property = "addrId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "addr_user_id", property = "addrUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "addr_info", property = "addrInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Address> selectByUserId(Long addrUserId);

    @UpdateProvider(type = AddressSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    @UpdateProvider(type = AddressSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    @UpdateProvider(type = AddressSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Address record);

    @Update({
            "update tbl_address",
            "set addr_info = #{addrInfo,jdbcType=VARCHAR},",
            "gmt_modified = current_timestamp()",
            "where addr_id = #{addrId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UpdateAddressParm record);

    @Update({
            "update tbl_address",
            "set addr_info = #{addrInfo,jdbcType=VARCHAR},",
            "gmt_modified = current_timestamp()",
            "where addr_id = #{addrId,jdbcType=BIGINT} ",
            "and addr_user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByUserIdAndAddressId(@Param("addrId") Long addrId, @Param("addrInfo") String addrInfo, @Param("userId") Long userId);
}