package com.main.shopping.mapper;

import com.main.api.dto.shopping.OrderParm;
import com.main.api.model.Order;
import com.main.api.model.example.OrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface OrderMapper {
    @SelectProvider(type = OrderSqlProvider.class, method = "countByExample")
    long countByExample(OrderExample example);

    @DeleteProvider(type = OrderSqlProvider.class, method = "deleteByExample")
    int deleteByExample(OrderExample example);

    @Delete({
            "delete from tbl_order",
            "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long orderId);

    @Insert({
            "insert into tbl_order (order_id, order_seller_id, ",
            "order_buyer_id, order_off_count, ",
            "order_totle, order_commodity_id, ",
            "order_commodity_count, order_address, ",
            "order_state)",
            "values (#{orderId,jdbcType=BIGINT}, #{orderSellerId,jdbcType=BIGINT}, ",
            "#{orderBuyerId,jdbcType=BIGINT}, #{orderOffCount,jdbcType=DECIMAL}, ",
            "#{orderTotle,jdbcType=DECIMAL}, #{orderCommodityId,jdbcType=BIGINT}, ",
            "#{orderCommodityCount,jdbcType=INTEGER}, #{orderAddress,jdbcType=VARCHAR}, ",
            "#{orderState,jdbcType=TINYINT})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "order_id", keyProperty = "orderId")
    int insert(Order record);

    @InsertProvider(type = OrderSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyColumn = "order_id", keyProperty = "orderId")
    int insertSelective(OrderParm record);

    @SelectProvider(type = OrderSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "order_seller_id", property = "orderSellerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_buyer_id", property = "orderBuyerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_off_count", property = "orderOffCount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_totle", property = "orderTotle", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_commodity_id", property = "orderCommodityId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_commodity_count", property = "orderCommodityCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_address", property = "orderAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_state", property = "orderState", jdbcType = JdbcType.TINYINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Order> selectByExample(OrderExample example);

    @Select({
            "select",
            "order_id, order_seller_id, order_buyer_id, order_off_count, order_totle, order_commodity_id, ",
            "order_commodity_count, order_address, order_state, gmt_create, gmt_modified",
            "from tbl_order",
            "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "order_seller_id", property = "orderSellerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_buyer_id", property = "orderBuyerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_off_count", property = "orderOffCount", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_totle", property = "orderTotle", jdbcType = JdbcType.DECIMAL),
            @Result(column = "order_commodity_id", property = "orderCommodityId", jdbcType = JdbcType.BIGINT),
            @Result(column = "order_commodity_count", property = "orderCommodityCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "order_address", property = "orderAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_state", property = "orderState", jdbcType = JdbcType.TINYINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    Order selectByPrimaryKey(Long orderId);


    @Select({
            "select",
            "order_commodity_count",
            "from tbl_order",
            "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "order_commodity_count", jdbcType = JdbcType.INTEGER, javaType = Integer.class)
    })
    Integer selectCommodityCountByPrimaryKey(Long orderId);


    @Select({
            "select order_state from tbl_order",
            "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "order_state", jdbcType = JdbcType.TINYINT, javaType = Byte.class)
    })
    Byte selectStateByPrimaryKey(Long orderId);


    @UpdateProvider(type = OrderSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type = OrderSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type = OrderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
            "update tbl_order",
            "set order_seller_id = #{orderSellerId,jdbcType=BIGINT},",
            "order_buyer_id = #{orderBuyerId,jdbcType=BIGINT},",
            "order_off_count = #{orderOffCount,jdbcType=DECIMAL},",
            "order_totle = #{orderTotle,jdbcType=DECIMAL},",
            "order_commodity_id = #{orderCommodityId,jdbcType=BIGINT},",
            "order_commodity_count = #{orderCommodityCount,jdbcType=INTEGER},",
            "order_address = #{orderAddress,jdbcType=VARCHAR},",
            "order_state = #{orderState,jdbcType=TINYINT},",
            "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
            "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
            "where order_id = #{orderId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Order record);
}