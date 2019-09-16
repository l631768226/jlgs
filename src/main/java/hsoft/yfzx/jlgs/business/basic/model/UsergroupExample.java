package hsoft.yfzx.jlgs.business.basic.model;

import java.util.ArrayList;
import java.util.List;

public class UsergroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsergroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGROUPIDIsNull() {
            addCriterion("GROUPID is null");
            return (Criteria) this;
        }

        public Criteria andGROUPIDIsNotNull() {
            addCriterion("GROUPID is not null");
            return (Criteria) this;
        }

        public Criteria andGROUPIDEqualTo(String value) {
            addCriterion("GROUPID =", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDNotEqualTo(String value) {
            addCriterion("GROUPID <>", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDGreaterThan(String value) {
            addCriterion("GROUPID >", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPID >=", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDLessThan(String value) {
            addCriterion("GROUPID <", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDLessThanOrEqualTo(String value) {
            addCriterion("GROUPID <=", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDLike(String value) {
            addCriterion("GROUPID like", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDNotLike(String value) {
            addCriterion("GROUPID not like", value, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDIn(List<String> values) {
            addCriterion("GROUPID in", values, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDNotIn(List<String> values) {
            addCriterion("GROUPID not in", values, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDBetween(String value1, String value2) {
            addCriterion("GROUPID between", value1, value2, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andGROUPIDNotBetween(String value1, String value2) {
            addCriterion("GROUPID not between", value1, value2, "GROUPID");
            return (Criteria) this;
        }

        public Criteria andUSERIDIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUSERIDIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUSERIDEqualTo(String value) {
            addCriterion("USERID =", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotEqualTo(String value) {
            addCriterion("USERID <>", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDGreaterThan(String value) {
            addCriterion("USERID >", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLessThan(String value) {
            addCriterion("USERID <", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLike(String value) {
            addCriterion("USERID like", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotLike(String value) {
            addCriterion("USERID not like", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDIn(List<String> values) {
            addCriterion("USERID in", values, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotIn(List<String> values) {
            addCriterion("USERID not in", values, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "USERID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDIsNull() {
            addCriterion("DEPTID is null");
            return (Criteria) this;
        }

        public Criteria andDEPTIDIsNotNull() {
            addCriterion("DEPTID is not null");
            return (Criteria) this;
        }

        public Criteria andDEPTIDEqualTo(String value) {
            addCriterion("DEPTID =", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDNotEqualTo(String value) {
            addCriterion("DEPTID <>", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDGreaterThan(String value) {
            addCriterion("DEPTID >", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDGreaterThanOrEqualTo(String value) {
            addCriterion("DEPTID >=", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDLessThan(String value) {
            addCriterion("DEPTID <", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDLessThanOrEqualTo(String value) {
            addCriterion("DEPTID <=", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDLike(String value) {
            addCriterion("DEPTID like", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDNotLike(String value) {
            addCriterion("DEPTID not like", value, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDIn(List<String> values) {
            addCriterion("DEPTID in", values, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDNotIn(List<String> values) {
            addCriterion("DEPTID not in", values, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDBetween(String value1, String value2) {
            addCriterion("DEPTID between", value1, value2, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andDEPTIDNotBetween(String value1, String value2) {
            addCriterion("DEPTID not between", value1, value2, "DEPTID");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELIsNull() {
            addCriterion("USER_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELIsNotNull() {
            addCriterion("USER_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELEqualTo(String value) {
            addCriterion("USER_LEVEL =", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELNotEqualTo(String value) {
            addCriterion("USER_LEVEL <>", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELGreaterThan(String value) {
            addCriterion("USER_LEVEL >", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELGreaterThanOrEqualTo(String value) {
            addCriterion("USER_LEVEL >=", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELLessThan(String value) {
            addCriterion("USER_LEVEL <", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELLessThanOrEqualTo(String value) {
            addCriterion("USER_LEVEL <=", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELLike(String value) {
            addCriterion("USER_LEVEL like", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELNotLike(String value) {
            addCriterion("USER_LEVEL not like", value, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELIn(List<String> values) {
            addCriterion("USER_LEVEL in", values, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELNotIn(List<String> values) {
            addCriterion("USER_LEVEL not in", values, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELBetween(String value1, String value2) {
            addCriterion("USER_LEVEL between", value1, value2, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andUSER_LEVELNotBetween(String value1, String value2) {
            addCriterion("USER_LEVEL not between", value1, value2, "USER_LEVEL");
            return (Criteria) this;
        }

        public Criteria andCARDIsNull() {
            addCriterion("CARD is null");
            return (Criteria) this;
        }

        public Criteria andCARDIsNotNull() {
            addCriterion("CARD is not null");
            return (Criteria) this;
        }

        public Criteria andCARDEqualTo(String value) {
            addCriterion("CARD =", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDNotEqualTo(String value) {
            addCriterion("CARD <>", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDGreaterThan(String value) {
            addCriterion("CARD >", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDGreaterThanOrEqualTo(String value) {
            addCriterion("CARD >=", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDLessThan(String value) {
            addCriterion("CARD <", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDLessThanOrEqualTo(String value) {
            addCriterion("CARD <=", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDLike(String value) {
            addCriterion("CARD like", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDNotLike(String value) {
            addCriterion("CARD not like", value, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDIn(List<String> values) {
            addCriterion("CARD in", values, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDNotIn(List<String> values) {
            addCriterion("CARD not in", values, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDBetween(String value1, String value2) {
            addCriterion("CARD between", value1, value2, "CARD");
            return (Criteria) this;
        }

        public Criteria andCARDNotBetween(String value1, String value2) {
            addCriterion("CARD not between", value1, value2, "CARD");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTIsNull() {
            addCriterion("POSITIONCODELIST is null");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTIsNotNull() {
            addCriterion("POSITIONCODELIST is not null");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTEqualTo(String value) {
            addCriterion("POSITIONCODELIST =", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTNotEqualTo(String value) {
            addCriterion("POSITIONCODELIST <>", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTGreaterThan(String value) {
            addCriterion("POSITIONCODELIST >", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTGreaterThanOrEqualTo(String value) {
            addCriterion("POSITIONCODELIST >=", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTLessThan(String value) {
            addCriterion("POSITIONCODELIST <", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTLessThanOrEqualTo(String value) {
            addCriterion("POSITIONCODELIST <=", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTLike(String value) {
            addCriterion("POSITIONCODELIST like", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTNotLike(String value) {
            addCriterion("POSITIONCODELIST not like", value, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTIn(List<String> values) {
            addCriterion("POSITIONCODELIST in", values, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTNotIn(List<String> values) {
            addCriterion("POSITIONCODELIST not in", values, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTBetween(String value1, String value2) {
            addCriterion("POSITIONCODELIST between", value1, value2, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andPOSITIONCODELISTNotBetween(String value1, String value2) {
            addCriterion("POSITIONCODELIST not between", value1, value2, "POSITIONCODELIST");
            return (Criteria) this;
        }

        public Criteria andSORTIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSORTIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSORTEqualTo(Short value) {
            addCriterion("SORT =", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTNotEqualTo(Short value) {
            addCriterion("SORT <>", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTGreaterThan(Short value) {
            addCriterion("SORT >", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTGreaterThanOrEqualTo(Short value) {
            addCriterion("SORT >=", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTLessThan(Short value) {
            addCriterion("SORT <", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTLessThanOrEqualTo(Short value) {
            addCriterion("SORT <=", value, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTIn(List<Short> values) {
            addCriterion("SORT in", values, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTNotIn(List<Short> values) {
            addCriterion("SORT not in", values, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTBetween(Short value1, Short value2) {
            addCriterion("SORT between", value1, value2, "SORT");
            return (Criteria) this;
        }

        public Criteria andSORTNotBetween(Short value1, Short value2) {
            addCriterion("SORT not between", value1, value2, "SORT");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPIsNull() {
            addCriterion("VERSIONSTAMP is null");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPIsNotNull() {
            addCriterion("VERSIONSTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPEqualTo(Long value) {
            addCriterion("VERSIONSTAMP =", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPNotEqualTo(Long value) {
            addCriterion("VERSIONSTAMP <>", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPGreaterThan(Long value) {
            addCriterion("VERSIONSTAMP >", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSIONSTAMP >=", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPLessThan(Long value) {
            addCriterion("VERSIONSTAMP <", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPLessThanOrEqualTo(Long value) {
            addCriterion("VERSIONSTAMP <=", value, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPIn(List<Long> values) {
            addCriterion("VERSIONSTAMP in", values, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPNotIn(List<Long> values) {
            addCriterion("VERSIONSTAMP not in", values, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPBetween(Long value1, Long value2) {
            addCriterion("VERSIONSTAMP between", value1, value2, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andVERSIONSTAMPNotBetween(Long value1, Long value2) {
            addCriterion("VERSIONSTAMP not between", value1, value2, "VERSIONSTAMP");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEEqualTo(Long value) {
            addCriterion("CREATETIME =", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotEqualTo(Long value) {
            addCriterion("CREATETIME <>", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEGreaterThan(Long value) {
            addCriterion("CREATETIME >", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATETIME >=", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMELessThan(Long value) {
            addCriterion("CREATETIME <", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMELessThanOrEqualTo(Long value) {
            addCriterion("CREATETIME <=", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEIn(List<Long> values) {
            addCriterion("CREATETIME in", values, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotIn(List<Long> values) {
            addCriterion("CREATETIME not in", values, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEBetween(Long value1, Long value2) {
            addCriterion("CREATETIME between", value1, value2, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotBetween(Long value1, Long value2) {
            addCriterion("CREATETIME not between", value1, value2, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andDELFLAGIsNull() {
            addCriterion("DELFLAG is null");
            return (Criteria) this;
        }

        public Criteria andDELFLAGIsNotNull() {
            addCriterion("DELFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDELFLAGEqualTo(String value) {
            addCriterion("DELFLAG =", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGNotEqualTo(String value) {
            addCriterion("DELFLAG <>", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGGreaterThan(String value) {
            addCriterion("DELFLAG >", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGGreaterThanOrEqualTo(String value) {
            addCriterion("DELFLAG >=", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGLessThan(String value) {
            addCriterion("DELFLAG <", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGLessThanOrEqualTo(String value) {
            addCriterion("DELFLAG <=", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGLike(String value) {
            addCriterion("DELFLAG like", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGNotLike(String value) {
            addCriterion("DELFLAG not like", value, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGIn(List<String> values) {
            addCriterion("DELFLAG in", values, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGNotIn(List<String> values) {
            addCriterion("DELFLAG not in", values, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGBetween(String value1, String value2) {
            addCriterion("DELFLAG between", value1, value2, "DELFLAG");
            return (Criteria) this;
        }

        public Criteria andDELFLAGNotBetween(String value1, String value2) {
            addCriterion("DELFLAG not between", value1, value2, "DELFLAG");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}