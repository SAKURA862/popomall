package com.main.shopping.mapper;

import com.main.api.model.ShoppingCar;
import com.main.api.model.example.ShoppingCarExample;
import com.main.api.model.example.ShoppingCarExample.Criteria;
import com.main.api.model.example.ShoppingCarExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class ShoppingCarSqlProvider {
    public String countByExample(ShoppingCarExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("tbl_shopping_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ShoppingCarExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("tbl_shopping_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ShoppingCar record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tbl_shopping_car");

        if (record.getCarId() != null) {
            sql.VALUES("car_Id", "#{carId,jdbcType=BIGINT}");
        }

        if (record.getCarUserId() != null) {
            sql.VALUES("car_user_id", "#{carUserId,jdbcType=BIGINT}");
        }

        if (record.getCarCommId() != null) {
            sql.VALUES("car_comm_id", "#{carCommId,jdbcType=BIGINT}");
        }

        if (record.getCarCommNumber() != null) {
            sql.VALUES("car_comm_number", "#{carCommNumber,jdbcType=INTEGER}");
        }

        sql.VALUES("gmt_modified", "current_timestamp()");

        return sql.toString();
    }

    public String selectByExample(ShoppingCarExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("car_Id");
        } else {
            sql.SELECT("car_Id");
        }
        sql.SELECT("car_user_id");
        sql.SELECT("car_comm_id");
        sql.SELECT("car_comm_number");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modified");
        sql.FROM("tbl_shopping_car");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ShoppingCar record = (ShoppingCar) parameter.get("record");
        ShoppingCarExample example = (ShoppingCarExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("tbl_shopping_car");

        if (record.getCarId() != null) {
            sql.SET("car_Id = #{record.carId,jdbcType=BIGINT}");
        }

        if (record.getCarUserId() != null) {
            sql.SET("car_user_id = #{record.carUserId,jdbcType=BIGINT}");
        }

        if (record.getCarCommId() != null) {
            sql.SET("car_comm_id = #{record.carCommId,jdbcType=BIGINT}");
        }

        if (record.getCarCommNumber() != null) {
            sql.SET("car_comm_number = #{record.carCommNumber,jdbcType=INTEGER}");
        }

        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_shopping_car");

        sql.SET("car_Id = #{record.carId,jdbcType=BIGINT}");
        sql.SET("car_user_id = #{record.carUserId,jdbcType=BIGINT}");
        sql.SET("car_comm_id = #{record.carCommId,jdbcType=BIGINT}");
        sql.SET("car_comm_number = #{record.carCommNumber,jdbcType=INTEGER}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");

        ShoppingCarExample example = (ShoppingCarExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ShoppingCar record) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_shopping_car");

        if (record.getCarUserId() != null) {
            sql.SET("car_user_id = #{carUserId,jdbcType=BIGINT}");
        }

        if (record.getCarCommId() != null) {
            sql.SET("car_comm_id = #{carCommId,jdbcType=BIGINT}");
        }

        if (record.getCarCommNumber() != null) {
            sql.SET("car_comm_number = #{carCommNumber,jdbcType=INTEGER}");
        }

        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("car_Id = #{carId,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, ShoppingCarExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}