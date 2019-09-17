package hsoft.yfzx.jlgs.business.basic.model;

import java.util.ArrayList;
import java.util.List;

public class FreqgroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FreqgroupExample() {
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

        public Criteria andOWNERIDIsNull() {
            addCriterion("OWNERID is null");
            return (Criteria) this;
        }

        public Criteria andOWNERIDIsNotNull() {
            addCriterion("OWNERID is not null");
            return (Criteria) this;
        }

        public Criteria andOWNERIDEqualTo(String value) {
            addCriterion("OWNERID =", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDNotEqualTo(String value) {
            addCriterion("OWNERID <>", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDGreaterThan(String value) {
            addCriterion("OWNERID >", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDGreaterThanOrEqualTo(String value) {
            addCriterion("OWNERID >=", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDLessThan(String value) {
            addCriterion("OWNERID <", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDLessThanOrEqualTo(String value) {
            addCriterion("OWNERID <=", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDLike(String value) {
            addCriterion("OWNERID like", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDNotLike(String value) {
            addCriterion("OWNERID not like", value, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDIn(List<String> values) {
            addCriterion("OWNERID in", values, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDNotIn(List<String> values) {
            addCriterion("OWNERID not in", values, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDBetween(String value1, String value2) {
            addCriterion("OWNERID between", value1, value2, "OWNERID");
            return (Criteria) this;
        }

        public Criteria andOWNERIDNotBetween(String value1, String value2) {
            addCriterion("OWNERID not between", value1, value2, "OWNERID");
            return (Criteria) this;
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