package com.main.shopping.mapper;

import com.main.api.dto.shopping.ShoppingCarParm;
import com.main.api.model.ShoppingCar;
import com.main.api.model.example.ShoppingCarExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {
    @SelectProvider(type = ShoppingCarSqlProvider.class, method = "countByExample")
    long countByExample(ShoppingCarExample example);

    @DeleteProvider(type = ShoppingCarSqlProvider.class, method = "deleteByExample")
    int deleteByExample(ShoppingCarExample example);

    @Delete({
            "delete from tbl_shopping_car",
            "where car_Id = #{carId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long carId);


    @Delete({
            "delete from tbl_shopping_car",
            "where car_Id = #{carId,jdbcType=BIGINT}",
            "and car_user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByCarIdAndUserId(@Param("carId") Long carId, @Param("userId") Long userId);

    @Insert({
            "insert into tbl_shopping_car (car_user_id, ",
            "car_comm_id, car_comm_number, ",
            "gmt_create, gmt_modified)",
            "#{carUserId,jdbcType=BIGINT}, ",
            "#{carCommId,jdbcType=BIGINT}, #{carCommNumber,jdbcType=INTEGER}, "
    })
    @Options(useGeneratedKeys = true, keyColumn = "car_Id", keyProperty = "carId")
    int insert(ShoppingCar record);

    @InsertProvider(type = ShoppingCarSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyColumn = "car_Id", keyProperty = "carId")
    int insertSelective(ShoppingCarParm record);

    @SelectProvider(type = ShoppingCarSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "car_Id", property = "carId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "car_user_id", property = "carUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_id", property = "carCommId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_number", property = "carCommNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<ShoppingCar> selectByExample(ShoppingCarExample example);

    @Select({
            "select",
            "car_Id, car_user_id, car_comm_id, car_comm_number, gmt_create, gmt_modified",
            "from tbl_shopping_car",
            "where car_Id = #{carId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "car_Id", property = "carId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "car_user_id", property = "carUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_id", property = "carCommId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_number", property = "carCommNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCar selectByPrimaryKey(Long carId);

    @Select({
            "select",
            "car_Id, car_user_id, car_comm_id, car_comm_number, gmt_create, gmt_modified",
            "from tbl_shopping_car",
            "where car_Id = #{carId,jdbcType=BIGINT}",
            "where car_user_Id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "car_Id", property = "carId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "car_user_id", property = "carUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_id", property = "carCommId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_number", property = "carCommNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCar selectByCarIdAndUserId(@Param("carId") Long carId, @Param("userId") Long userId);


    @Select({
            "select",
            "car_Id, car_comm_id, car_comm_number",
            "from tbl_shopping_car",
            "where car_user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "car_Id", property = "carId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "car_comm_id", property = "carCommId", jdbcType = JdbcType.BIGINT),
            @Result(column = "car_comm_number", property = "carCommNumber", jdbcType = JdbcType.INTEGER)
    })
    List<ShoppingCarParm> selectByUserId(Long userId);


    @UpdateProvider(type = ShoppingCarSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    @UpdateProvider(type = ShoppingCarSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    @UpdateProvider(type = ShoppingCarSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShoppingCar record);

    @Update({
            "update tbl_shopping_car",
            "set car_comm_number = #{carCommNumber,jdbcType=INTEGER},",
            "gmt_modified = current_timestamp()",
            "where car_Id = #{carId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(@Param("carId") Long carId, @Param("carCommNumber") Integer carCommNumber);

    @Update({
            "update tbl_shopping_car",
            "set car_comm_number = #{carCommNumber,jdbcType=INTEGER},",
            "gmt_modified = current_timestamp()",
            "where car_Id = #{carId,jdbcType=BIGINT}",
            "and car_user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByCarIdAndUserId(@Param("carId") Long carId, @Param("UserId") Long userId, @Param("carCommNumber") Integer carCommNumber);
}