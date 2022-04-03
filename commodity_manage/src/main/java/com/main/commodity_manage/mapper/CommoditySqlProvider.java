package com.main.commodity_manage.mapper;

import com.main.api.model.CommodityWithBLOBs;
import com.main.api.model.example.CommodityExample;
import com.main.api.model.example.CommodityExample.Criteria;
import com.main.api.model.example.CommodityExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class CommoditySqlProvider {
    public String countByExample(CommodityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("tbl_commodity");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommodityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("tbl_commodity");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommodityWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tbl_commodity");

        if (record.getCommId() != null) {
            sql.VALUES("comm_id", "#{commId,jdbcType=BIGINT}");
        }

        if (record.getCommName() != null) {
            sql.VALUES("comm_name", "#{commName,jdbcType=VARCHAR}");
        }

        if (record.getCommStock() != null) {
            sql.VALUES("comm_stock", "#{commStock,jdbcType=INTEGER}");
        }

        if (record.getCommPrice() != null) {
            sql.VALUES("comm_price", "#{commPrice,jdbcType=DECIMAL}");
        }

        if (record.getCommDetail() != null) {
            sql.VALUES("comm_detail", "#{commDetail,jdbcType=VARCHAR}");
        }

        if (record.getCommType() != null) {
            sql.VALUES("comm_type", "#{commType,jdbcType=VARCHAR}");
        }

        if (record.getCommUserid() != null) {
            sql.VALUES("comm_userid", "#{commUserid,jdbcType=BIGINT}");
        }

        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }

        if (record.getCommPic() != null) {
            sql.VALUES("comm_pic", "#{commPic,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic1() != null) {
            sql.VALUES("comm_detailpic1", "#{commDetailpic1,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic2() != null) {
            sql.VALUES("comm_detailpic2", "#{commDetailpic2,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic3() != null) {
            sql.VALUES("comm_detailpic3", "#{commDetailpic3,jdbcType=LONGVARBINARY}");
        }

        return sql.toString();
    }

    public String selectByExampleWithBLOBs(CommodityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("comm_id");
        } else {
            sql.SELECT("comm_id");
        }
        sql.SELECT("comm_name");
        sql.SELECT("comm_stock");
        sql.SELECT("comm_price");
        sql.SELECT("comm_detail");
        sql.SELECT("comm_type");
        sql.SELECT("comm_userid");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modified");
        sql.SELECT("comm_pic");
        sql.SELECT("comm_detailpic1");
        sql.SELECT("comm_detailpic2");
        sql.SELECT("comm_detailpic3");
        sql.FROM("tbl_commodity");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String selectByExample(CommodityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("comm_id");
        } else {
            sql.SELECT("comm_id");
        }
        sql.SELECT("comm_name");
        sql.SELECT("comm_stock");
        sql.SELECT("comm_price");
        sql.SELECT("comm_detail");
        sql.SELECT("comm_type");
        sql.SELECT("comm_userid");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modified");
        sql.FROM("tbl_commodity");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommodityWithBLOBs record = (CommodityWithBLOBs) parameter.get("record");
        CommodityExample example = (CommodityExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("tbl_commodity");

        if (record.getCommId() != null) {
            sql.SET("comm_id = #{record.commId,jdbcType=BIGINT}");
        }

        if (record.getCommName() != null) {
            sql.SET("comm_name = #{record.commName,jdbcType=VARCHAR}");
        }

        if (record.getCommStock() != null) {
            sql.SET("comm_stock = #{record.commStock,jdbcType=INTEGER}");
        }

        if (record.getCommPrice() != null) {
            sql.SET("comm_price = #{record.commPrice,jdbcType=DECIMAL}");
        }

        if (record.getCommDetail() != null) {
            sql.SET("comm_detail = #{record.commDetail,jdbcType=VARCHAR}");
        }

        if (record.getCommType() != null) {
            sql.SET("comm_type = #{record.commType,jdbcType=VARCHAR}");
        }

        if (record.getCommUserid() != null) {
            sql.SET("comm_userid = #{record.commUserid,jdbcType=BIGINT}");
        }

        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");
        }

        if (record.getCommPic() != null) {
            sql.SET("comm_pic = #{record.commPic,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic1() != null) {
            sql.SET("comm_detailpic1 = #{record.commDetailpic1,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic2() != null) {
            sql.SET("comm_detailpic2 = #{record.commDetailpic2,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic3() != null) {
            sql.SET("comm_detailpic3 = #{record.commDetailpic3,jdbcType=LONGVARBINARY}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_commodity");

        sql.SET("comm_id = #{record.commId,jdbcType=BIGINT}");
        sql.SET("comm_name = #{record.commName,jdbcType=VARCHAR}");
        sql.SET("comm_stock = #{record.commStock,jdbcType=INTEGER}");
        sql.SET("comm_price = #{record.commPrice,jdbcType=DECIMAL}");
        sql.SET("comm_detail = #{record.commDetail,jdbcType=VARCHAR}");
        sql.SET("comm_type = #{record.commType,jdbcType=VARCHAR}");
        sql.SET("comm_userid = #{record.commUserid,jdbcType=BIGINT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");
        sql.SET("comm_pic = #{record.commPic,jdbcType=LONGVARBINARY}");
        sql.SET("comm_detailpic1 = #{record.commDetailpic1,jdbcType=LONGVARBINARY}");
        sql.SET("comm_detailpic2 = #{record.commDetailpic2,jdbcType=LONGVARBINARY}");
        sql.SET("comm_detailpic3 = #{record.commDetailpic3,jdbcType=LONGVARBINARY}");

        CommodityExample example = (CommodityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_commodity");

        sql.SET("comm_id = #{record.commId,jdbcType=BIGINT}");
        sql.SET("comm_name = #{record.commName,jdbcType=VARCHAR}");
        sql.SET("comm_stock = #{record.commStock,jdbcType=INTEGER}");
        sql.SET("comm_price = #{record.commPrice,jdbcType=DECIMAL}");
        sql.SET("comm_detail = #{record.commDetail,jdbcType=VARCHAR}");
        sql.SET("comm_type = #{record.commType,jdbcType=VARCHAR}");
        sql.SET("comm_userid = #{record.commUserid,jdbcType=BIGINT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");

        CommodityExample example = (CommodityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommodityWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_commodity");

        if (record.getCommName() != null) {
            sql.SET("comm_name = #{commName,jdbcType=VARCHAR}");
        }

        if (record.getCommStock() != null) {
            sql.SET("comm_stock = #{commStock,jdbcType=INTEGER}");
        }

        if (record.getCommPrice() != null) {
            sql.SET("comm_price = #{commPrice,jdbcType=DECIMAL}");
        }

        if (record.getCommDetail() != null) {
            sql.SET("comm_detail = #{commDetail,jdbcType=VARCHAR}");
        }

        if (record.getCommType() != null) {
            sql.SET("comm_type = #{commType,jdbcType=VARCHAR}");
        }

        if (record.getCommUserid() != null) {
            sql.SET("comm_userid = #{commUserid,jdbcType=BIGINT}");
        }

        sql.SET("gmt_modified = current_timestamp()");

        if (record.getCommPic() != null) {
            sql.SET("comm_pic = #{commPic,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic1() != null) {
            sql.SET("comm_detailpic1 = #{commDetailpic1,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic2() != null) {
            sql.SET("comm_detailpic2 = #{commDetailpic2,jdbcType=LONGVARBINARY}");
        }

        if (record.getCommDetailpic3() != null) {
            sql.SET("comm_detailpic3 = #{commDetailpic3,jdbcType=LONGVARBINARY}");
        }

        sql.WHERE("comm_id = #{commId,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommodityExample example, boolean includeExamplePhrase) {
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