package hsoft.yfzx.jlgs.business.basic.model;

import java.util.ArrayList;
import java.util.List;

public class GroupinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupinfoExample() {
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

        public Criteria andGROUPNAMEIsNull() {
            addCriterion("GROUPNAME is null");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEIsNotNull() {
            addCriterion("GROUPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEEqualTo(String value) {
            addCriterion("GROUPNAME =", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMENotEqualTo(String value) {
            addCriterion("GROUPNAME <>", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEGreaterThan(String value) {
            addCriterion("GROUPNAME >", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPNAME >=", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMELessThan(String value) {
            addCriterion("GROUPNAME <", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMELessThanOrEqualTo(String value) {
            addCriterion("GROUPNAME <=", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMELike(String value) {
            addCriterion("GROUPNAME like", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMENotLike(String value) {
            addCriterion("GROUPNAME not like", value, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEIn(List<String> values) {
            addCriterion("GROUPNAME in", values, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMENotIn(List<String> values) {
            addCriterion("GROUPNAME not in", values, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMEBetween(String value1, String value2) {
            addCriterion("GROUPNAME between", value1, value2, "GROUPNAME");
            return (Criteria) this;
        }

        public Criteria andGROUPNAMENotBetween(String value1, String value2) {
            addCriterion("GROUPNAME not between", value1, value2, "GROUPNAME");
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

        public Criteria andNOTICEIsNull() {
            addCriterion("NOTICE is null");
            return (Criteria) this;
        }

        public Criteria andNOTICEIsNotNull() {
            addCriterion("NOTICE is not null");
            return (Criteria) this;
        }

        public Criteria andNOTICEEqualTo(String value) {
            addCriterion("NOTICE =", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICENotEqualTo(String value) {
            addCriterion("NOTICE <>", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICEGreaterThan(String value) {
            addCriterion("NOTICE >", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICEGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE >=", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICELessThan(String value) {
            addCriterion("NOTICE <", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICELessThanOrEqualTo(String value) {
            addCriterion("NOTICE <=", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICELike(String value) {
            addCriterion("NOTICE like", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICENotLike(String value) {
            addCriterion("NOTICE not like", value, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICEIn(List<String> values) {
            addCriterion("NOTICE in", values, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICENotIn(List<String> values) {
            addCriterion("NOTICE not in", values, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICEBetween(String value1, String value2) {
            addCriterion("NOTICE between", value1, value2, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andNOTICENotBetween(String value1, String value2) {
            addCriterion("NOTICE not between", value1, value2, "NOTICE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEIsNull() {
            addCriterion("INTRODUCE is null");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEIsNotNull() {
            addCriterion("INTRODUCE is not null");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEEqualTo(String value) {
            addCriterion("INTRODUCE =", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCENotEqualTo(String value) {
            addCriterion("INTRODUCE <>", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEGreaterThan(String value) {
            addCriterion("INTRODUCE >", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEGreaterThanOrEqualTo(String value) {
            addCriterion("INTRODUCE >=", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCELessThan(String value) {
            addCriterion("INTRODUCE <", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCELessThanOrEqualTo(String value) {
            addCriterion("INTRODUCE <=", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCELike(String value) {
            addCriterion("INTRODUCE like", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCENotLike(String value) {
            addCriterion("INTRODUCE not like", value, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEIn(List<String> values) {
            addCriterion("INTRODUCE in", values, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCENotIn(List<String> values) {
            addCriterion("INTRODUCE not in", values, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCEBetween(String value1, String value2) {
            addCriterion("INTRODUCE between", value1, value2, "INTRODUCE");
            return (Criteria) this;
        }

        public Criteria andINTRODUCENotBetween(String value1, String value2) {
            addCriterion("INTRODUCE not between", value1, value2, "INTRODUCE");
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