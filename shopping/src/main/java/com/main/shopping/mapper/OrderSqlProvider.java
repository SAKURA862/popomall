package com.main.shopping.mapper;

import com.main.api.dto.shopping.OrderParm;
import com.main.api.model.Order;
import com.main.api.model.example.OrderExample;
import com.main.api.model.example.OrderExample.Criteria;
import com.main.api.model.example.OrderExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OrderSqlProvider {
    public String countByExample(OrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("tbl_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("tbl_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderParm record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tbl_order");

        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }

        if (record.getOrderBuyerId() != null) {
            sql.VALUES("order_buyer_id", "#{orderBuyerId,jdbcType=BIGINT}");
        }

        if (record.getOrderSellerId() != null) {
            sql.VALUES("order_seller_id", "#{orderSellerId,jdbcType=BIGINT}");
        }

        if (record.getOrderOffCount() != null) {
            sql.VALUES("order_off_count", "#{orderOffCount,jdbcType=DECIMAL}");
        }

        if (record.getOrderTotle() != null) {
            sql.VALUES("order_totle", "#{orderTotle,jdbcType=DECIMAL}");
        }

        if (record.getOrderCommodityId() != null) {
            sql.VALUES("order_commodity_id", "#{orderCommodityId,jdbcType=BIGINT}");
        }

        if (record.getOrderCommodityCount() != null) {
            sql.VALUES("order_commodity_count", "#{orderCommodityCount,jdbcType=INTEGER}");
        }

        if (record.getOrderAddress() != null) {
            sql.VALUES("order_address", "#{orderAddress,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(OrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("order_id");
        } else {
            sql.SELECT("order_id");
        }
        sql.SELECT("order_seller_id");
        sql.SELECT("order_buyer_id");
        sql.SELECT("order_off_count");
        sql.SELECT("order_totle");
        sql.SELECT("order_commodity_id");
        sql.SELECT("order_commodity_count");
        sql.SELECT("order_address");
        sql.SELECT("order_state");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modified");
        sql.FROM("tbl_order");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderExample example = (OrderExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("tbl_order");

        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }

        if (record.getOrderSellerId() != null) {
            sql.SET("order_seller_id = #{record.orderSellerId,jdbcType=BIGINT}");
        }

        if (record.getOrderBuyerId() != null) {
            sql.SET("order_buyer_id = #{record.orderBuyerId,jdbcType=BIGINT}");
        }

        if (record.getOrderOffCount() != null) {
            sql.SET("order_off_count = #{record.orderOffCount,jdbcType=DECIMAL}");
        }

        if (record.getOrderTotle() != null) {
            sql.SET("order_totle = #{record.orderTotle,jdbcType=DECIMAL}");
        }

        if (record.getOrderCommodityId() != null) {
            sql.SET("order_commodity_id = #{record.orderCommodityId,jdbcType=BIGINT}");
        }

        if (record.getOrderCommodityCount() != null) {
            sql.SET("order_commodity_count = #{record.orderCommodityCount,jdbcType=INTEGER}");
        }

        if (record.getOrderAddress() != null) {
            sql.SET("order_address = #{record.orderAddress,jdbcType=VARCHAR}");
        }

        if (record.getOrderState() != null) {
            sql.SET("order_state = #{record.orderState,jdbcType=TINYINT}");
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
        sql.UPDATE("tbl_order");

        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("order_seller_id = #{record.orderSellerId,jdbcType=BIGINT}");
        sql.SET("order_buyer_id = #{record.orderBuyerId,jdbcType=BIGINT}");
        sql.SET("order_off_count = #{record.orderOffCount,jdbcType=DECIMAL}");
        sql.SET("order_totle = #{record.orderTotle,jdbcType=DECIMAL}");
        sql.SET("order_commodity_id = #{record.orderCommodityId,jdbcType=BIGINT}");
        sql.SET("order_commodity_count = #{record.orderCommodityCount,jdbcType=INTEGER}");
        sql.SET("order_address = #{record.orderAddress,jdbcType=VARCHAR}");
        sql.SET("order_state = #{record.orderState,jdbcType=TINYINT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");

        OrderExample example = (OrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_order");

        if (record.getOrderSellerId() != null) {
            sql.SET("order_seller_id = #{orderSellerId,jdbcType=BIGINT}");
        }

        if (record.getOrderBuyerId() != null) {
            sql.SET("order_buyer_id = #{orderBuyerId,jdbcType=BIGINT}");
        }

        if (record.getOrderOffCount() != null) {
            sql.SET("order_off_count = #{orderOffCount,jdbcType=DECIMAL}");
        }

        if (record.getOrderTotle() != null) {
            sql.SET("order_totle = #{orderTotle,jdbcType=DECIMAL}");
        }

        if (record.getOrderCommodityId() != null) {
            sql.SET("order_commodity_id = #{orderCommodityId,jdbcType=BIGINT}");
        }

        if (record.getOrderCommodityCount() != null) {
            sql.SET("order_commodity_count = #{orderCommodityCount,jdbcType=INTEGER}");
        }

        if (record.getOrderAddress() != null) {
            sql.SET("order_address = #{orderAddress,jdbcType=VARCHAR}");
        }

        if (record.getOrderState() != null) {
            sql.SET("order_state = #{orderState,jdbcType=TINYINT}");
        }

        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("order_id = #{orderId,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderExample example, boolean includeExamplePhrase) {
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