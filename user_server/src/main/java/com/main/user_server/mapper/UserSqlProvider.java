package com.main.user_server.mapper;

import com.main.api.model.User;
import com.main.api.model.example.UserExample;
import com.main.api.model.example.UserExample.Criteria;
import com.main.api.model.example.UserExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class UserSqlProvider {
    public String countByExample(UserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("tbl_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("tbl_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tbl_user");

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getUserPhone() != null) {
            sql.VALUES("user_phone", "#{userPhone,jdbcType=CHAR}");
        }

        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUserInfo() != null) {
            sql.VALUES("user_info", "#{userInfo,jdbcType=VARCHAR}");
        }

        if (record.getUserRole() != null) {
            sql.VALUES("user_role", "#{userRole,jdbcType=TINYINT}");
        }

        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    public String selectByExample(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("user_id");
        } else {
            sql.SELECT("user_id");
        }
        sql.SELECT("user_phone");
        sql.SELECT("user_name");
        sql.SELECT("user_password");
        sql.SELECT("user_info");
        sql.SELECT("user_role");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modified");
        sql.FROM("tbl_user");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("tbl_user");

        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }

        if (record.getUserPhone() != null) {
            sql.SET("user_phone = #{record.userPhone,jdbcType=CHAR}");
        }

        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUserInfo() != null) {
            sql.SET("user_info = #{record.userInfo,jdbcType=VARCHAR}");
        }

        if (record.getUserRole() != null) {
            sql.SET("user_role = #{record.userRole,jdbcType=TINYINT}");
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
        sql.UPDATE("tbl_user");

        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("user_phone = #{record.userPhone,jdbcType=CHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        sql.SET("user_info = #{record.userInfo,jdbcType=VARCHAR}");
        sql.SET("user_role = #{record.userRole,jdbcType=TINYINT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modified = #{record.gmtModified,jdbcType=TIMESTAMP}");

        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("tbl_user");

        if (record.getUserPhone() != null) {
            sql.SET("user_phone = #{userPhone,jdbcType=CHAR}");
        }

        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUserInfo() != null) {
            sql.SET("user_info = #{userInfo,jdbcType=VARCHAR}");
        }

        if (record.getUserRole() != null) {
            sql.SET("user_role = #{userRole,jdbcType=TINYINT}");
        }

        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }

        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("user_id = #{userId,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserExample example, boolean includeExamplePhrase) {
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