package com.main.browse.mapper;

import com.main.api.dto.browse.QueryCommodityParmTmp;
import com.main.api.model.Commodity;
import com.main.api.model.CommodityWithBLOBs;
import com.main.api.model.example.CommodityExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @SelectProvider(type = CommoditySqlProvider.class, method = "countByExample")
    long countByExample(CommodityExample example);

    @DeleteProvider(type = CommoditySqlProvider.class, method = "deleteByExample")
    int deleteByExample(CommodityExample example);

    @Delete({
            "delete from tbl_commodity",
            "where comm_id = #{commId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long commId);

    @Insert({
            "insert into tbl_commodity (comm_id, comm_name, ",
            "comm_stock, comm_price, ",
            "comm_detail, comm_type, ",
            "comm_userid, comm_pic, ",
            "comm_detailpic1, comm_detailpic2, ",
            "comm_detailpic3)",
            "values (#{commId,jdbcType=BIGINT}, #{commName,jdbcType=VARCHAR}, ",
            "#{commStock,jdbcType=INTEGER}, #{commPrice,jdbcType=DECIMAL}, ",
            "#{commDetail,jdbcType=VARCHAR}, #{commType,jdbcType=VARCHAR}, ",
            "#{commUserid,jdbcType=BIGINT}, #{commPic,jdbcType=LONGVARBINARY}, ",
            "#{commDetailpic1,jdbcType=LONGVARBINARY}, #{commDetailpic2,jdbcType=LONGVARBINARY}, ",
            "#{commDetailpic3,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "comm_id", keyProperty = "commId")
    int insert(CommodityWithBLOBs record);

    @InsertProvider(type = CommoditySqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyColumn = "comm_id", keyProperty = "commId")
    int insertSelective(CommodityWithBLOBs record);

    @SelectProvider(type = CommoditySqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comm_name", property = "commName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_stock", property = "commStock", jdbcType = JdbcType.INTEGER),
            @Result(column = "comm_price", property = "commPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "comm_detail", property = "commDetail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_type", property = "commType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_userid", property = "commUserid", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comm_pic", property = "commPic", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic1", property = "commDetailpic1", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic2", property = "commDetailpic2", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic3", property = "commDetailpic3", jdbcType = JdbcType.LONGVARBINARY)
    })
    List<CommodityWithBLOBs> selectByExampleWithBLOBs(CommodityExample example);


    @Select({
            "select comm_id, comm_name, ",
            "comm_price, comm_type, ",
            "comm_type, comm_userid, ",
            "comm_pic from tbl_commodity"
    })
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comm_name", property = "commName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_price", property = "commPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "comm_type", property = "commType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_userid", property = "commUserid", jdbcType = JdbcType.BIGINT),
            @Result(column = "comm_pic", property = "commPic", jdbcType = JdbcType.LONGVARBINARY),
    })
    List<QueryCommodityParmTmp> selectAllCommodity();

    @Select({
            "select comm_id from tbl_commodity"
    })
    @Results({
            @Result(column = "comm_id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true)
    })
    List<Long> selectAllCommodityId();


    @SelectProvider(type = CommoditySqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comm_name", property = "commName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_stock", property = "commStock", jdbcType = JdbcType.INTEGER),
            @Result(column = "comm_price", property = "commPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "comm_detail", property = "commDetail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_type", property = "commType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_userid", property = "commUserid", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Commodity> selectByExample(CommodityExample example);


    @Select({
            "select",
            "comm_id, comm_name, comm_stock, comm_price, comm_detail, comm_type, comm_userid, ",
            "gmt_create, gmt_modified, comm_pic, comm_detailpic1, comm_detailpic2, comm_detailpic3",
            "from tbl_commodity",
            "where comm_userid = #{sellerId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comm_name", property = "commName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_stock", property = "commStock", jdbcType = JdbcType.INTEGER),
            @Result(column = "comm_price", property = "commPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "comm_detail", property = "commDetail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_type", property = "commType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_userid", property = "commUserid", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comm_pic", property = "commPic", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic1", property = "commDetailpic1", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic2", property = "commDetailpic2", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic3", property = "commDetailpic3", jdbcType = JdbcType.LONGVARBINARY)
    })
    List<CommodityWithBLOBs> selectBySellerId(Long sellerId);

    @Select({
            "select",
            "comm_id, comm_name, comm_stock, comm_price, comm_detail, comm_type, comm_userid, ",
            "gmt_create, gmt_modified, comm_pic, comm_detailpic1, comm_detailpic2, comm_detailpic3",
            "from tbl_commodity",
            "where comm_id = #{commId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comm_name", property = "commName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_stock", property = "commStock", jdbcType = JdbcType.INTEGER),
            @Result(column = "comm_price", property = "commPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "comm_detail", property = "commDetail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_type", property = "commType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comm_userid", property = "commUserid", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comm_pic", property = "commPic", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic1", property = "commDetailpic1", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic2", property = "commDetailpic2", jdbcType = JdbcType.LONGVARBINARY),
            @Result(column = "comm_detailpic3", property = "commDetailpic3", jdbcType = JdbcType.LONGVARBINARY)
    })
    CommodityWithBLOBs selectByPrimaryKey(Long commId);

    @UpdateProvider(type = CommoditySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommodityWithBLOBs record, @Param("example") CommodityExample example);

    @UpdateProvider(type = CommoditySqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CommodityWithBLOBs record, @Param("example") CommodityExample example);

    @UpdateProvider(type = CommoditySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    @UpdateProvider(type = CommoditySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommodityWithBLOBs record);

    @Update({
            "update tbl_commodity",
            "set comm_name = #{commName,jdbcType=VARCHAR},",
            "comm_stock = #{commStock,jdbcType=INTEGER},",
            "comm_price = #{commPrice,jdbcType=DECIMAL},",
            "comm_detail = #{commDetail,jdbcType=VARCHAR},",
            "comm_type = #{commType,jdbcType=VARCHAR},",
            "comm_userid = #{commUserid,jdbcType=BIGINT},",
            "gmt_modified = current_timestamp(),",
            "comm_pic = #{commPic,jdbcType=LONGVARBINARY},",
            "comm_detailpic1 = #{commDetailpic1,jdbcType=LONGVARBINARY},",
            "comm_detailpic2 = #{commDetailpic2,jdbcType=LONGVARBINARY},",
            "comm_detailpic3 = #{commDetailpic3,jdbcType=LONGVARBINARY}",
            "where comm_id = #{commId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CommodityWithBLOBs record);

    @Update({
            "update tbl_commodity",
            "set comm_name = #{commName,jdbcType=VARCHAR},",
            "comm_stock = #{commStock,jdbcType=INTEGER},",
            "comm_price = #{commPrice,jdbcType=DECIMAL},",
            "comm_detail = #{commDetail,jdbcType=VARCHAR},",
            "comm_type = #{commType,jdbcType=VARCHAR},",
            "comm_userid = #{commUserid,jdbcType=BIGINT},",
            "gmt_modified = current_timestamp()",
            "where comm_id = #{commId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Commodity record);
}