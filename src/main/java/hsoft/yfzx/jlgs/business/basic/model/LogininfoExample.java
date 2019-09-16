package hsoft.yfzx.jlgs.business.basic.model;

import java.util.ArrayList;
import java.util.List;

public class LogininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogininfoExample() {
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

        public Criteria andDEVICETYPEIsNull() {
            addCriterion("DEVICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEIsNotNull() {
            addCriterion("DEVICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEEqualTo(String value) {
            addCriterion("DEVICETYPE =", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPENotEqualTo(String value) {
            addCriterion("DEVICETYPE <>", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEGreaterThan(String value) {
            addCriterion("DEVICETYPE >", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICETYPE >=", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPELessThan(String value) {
            addCriterion("DEVICETYPE <", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPELessThanOrEqualTo(String value) {
            addCriterion("DEVICETYPE <=", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPELike(String value) {
            addCriterion("DEVICETYPE like", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPENotLike(String value) {
            addCriterion("DEVICETYPE not like", value, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEIn(List<String> values) {
            addCriterion("DEVICETYPE in", values, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPENotIn(List<String> values) {
            addCriterion("DEVICETYPE not in", values, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPEBetween(String value1, String value2) {
            addCriterion("DEVICETYPE between", value1, value2, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andDEVICETYPENotBetween(String value1, String value2) {
            addCriterion("DEVICETYPE not between", value1, value2, "DEVICETYPE");
            return (Criteria) this;
        }

        public Criteria andIMEIIsNull() {
            addCriterion("IMEI is null");
            return (Criteria) this;
        }

        public Criteria andIMEIIsNotNull() {
            addCriterion("IMEI is not null");
            return (Criteria) this;
        }

        public Criteria andIMEIEqualTo(String value) {
            addCriterion("IMEI =", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEINotEqualTo(String value) {
            addCriterion("IMEI <>", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEIGreaterThan(String value) {
            addCriterion("IMEI >", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEIGreaterThanOrEqualTo(String value) {
            addCriterion("IMEI >=", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEILessThan(String value) {
            addCriterion("IMEI <", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEILessThanOrEqualTo(String value) {
            addCriterion("IMEI <=", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEILike(String value) {
            addCriterion("IMEI like", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEINotLike(String value) {
            addCriterion("IMEI not like", value, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEIIn(List<String> values) {
            addCriterion("IMEI in", values, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEINotIn(List<String> values) {
            addCriterion("IMEI not in", values, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEIBetween(String value1, String value2) {
            addCriterion("IMEI between", value1, value2, "IMEI");
            return (Criteria) this;
        }

        public Criteria andIMEINotBetween(String value1, String value2) {
            addCriterion("IMEI not between", value1, value2, "IMEI");
            return (Criteria) this;
        }

        public Criteria andTOKENIsNull() {
            addCriterion("TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andTOKENIsNotNull() {
            addCriterion("TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andTOKENEqualTo(String value) {
            addCriterion("TOKEN =", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENNotEqualTo(String value) {
            addCriterion("TOKEN <>", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENGreaterThan(String value) {
            addCriterion("TOKEN >", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN >=", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENLessThan(String value) {
            addCriterion("TOKEN <", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENLessThanOrEqualTo(String value) {
            addCriterion("TOKEN <=", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENLike(String value) {
            addCriterion("TOKEN like", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENNotLike(String value) {
            addCriterion("TOKEN not like", value, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENIn(List<String> values) {
            addCriterion("TOKEN in", values, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENNotIn(List<String> values) {
            addCriterion("TOKEN not in", values, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENBetween(String value1, String value2) {
            addCriterion("TOKEN between", value1, value2, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andTOKENNotBetween(String value1, String value2) {
            addCriterion("TOKEN not between", value1, value2, "TOKEN");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEIsNull() {
            addCriterion("LASTLOGINTIME is null");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEIsNotNull() {
            addCriterion("LASTLOGINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEEqualTo(Long value) {
            addCriterion("LASTLOGINTIME =", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMENotEqualTo(Long value) {
            addCriterion("LASTLOGINTIME <>", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEGreaterThan(Long value) {
            addCriterion("LASTLOGINTIME >", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEGreaterThanOrEqualTo(Long value) {
            addCriterion("LASTLOGINTIME >=", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMELessThan(Long value) {
            addCriterion("LASTLOGINTIME <", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMELessThanOrEqualTo(Long value) {
            addCriterion("LASTLOGINTIME <=", value, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEIn(List<Long> values) {
            addCriterion("LASTLOGINTIME in", values, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMENotIn(List<Long> values) {
            addCriterion("LASTLOGINTIME not in", values, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMEBetween(Long value1, Long value2) {
            addCriterion("LASTLOGINTIME between", value1, value2, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andLASTLOGINTIMENotBetween(Long value1, Long value2) {
            addCriterion("LASTLOGINTIME not between", value1, value2, "LASTLOGINTIME");
            return (Criteria) this;
        }

        public Criteria andPICIDIsNull() {
            addCriterion("PICID is null");
            return (Criteria) this;
        }

        public Criteria andPICIDIsNotNull() {
            addCriterion("PICID is not null");
            return (Criteria) this;
        }

        public Criteria andPICIDEqualTo(String value) {
            addCriterion("PICID =", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDNotEqualTo(String value) {
            addCriterion("PICID <>", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDGreaterThan(String value) {
            addCriterion("PICID >", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDGreaterThanOrEqualTo(String value) {
            addCriterion("PICID >=", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDLessThan(String value) {
            addCriterion("PICID <", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDLessThanOrEqualTo(String value) {
            addCriterion("PICID <=", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDLike(String value) {
            addCriterion("PICID like", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDNotLike(String value) {
            addCriterion("PICID not like", value, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDIn(List<String> values) {
            addCriterion("PICID in", values, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDNotIn(List<String> values) {
            addCriterion("PICID not in", values, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDBetween(String value1, String value2) {
            addCriterion("PICID between", value1, value2, "PICID");
            return (Criteria) this;
        }

        public Criteria andPICIDNotBetween(String value1, String value2) {
            addCriterion("PICID not between", value1, value2, "PICID");
            return (Criteria) this;
        }

        public Criteria andREALNAMEIsNull() {
            addCriterion("REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andREALNAMEIsNotNull() {
            addCriterion("REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andREALNAMEEqualTo(String value) {
            addCriterion("REALNAME =", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMENotEqualTo(String value) {
            addCriterion("REALNAME <>", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMEGreaterThan(String value) {
            addCriterion("REALNAME >", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("REALNAME >=", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMELessThan(String value) {
            addCriterion("REALNAME <", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMELessThanOrEqualTo(String value) {
            addCriterion("REALNAME <=", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMELike(String value) {
            addCriterion("REALNAME like", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMENotLike(String value) {
            addCriterion("REALNAME not like", value, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMEIn(List<String> values) {
            addCriterion("REALNAME in", values, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMENotIn(List<String> values) {
            addCriterion("REALNAME not in", values, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMEBetween(String value1, String value2) {
            addCriterion("REALNAME between", value1, value2, "REALNAME");
            return (Criteria) this;
        }

        public Criteria andREALNAMENotBetween(String value1, String value2) {
            addCriterion("REALNAME not between", value1, value2, "REALNAME");
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