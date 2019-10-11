package hsoft.yfzx.jlgs.business.basic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andFEEDBACKIDIsNull() {
            addCriterion("FEEDBACKID is null");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDIsNotNull() {
            addCriterion("FEEDBACKID is not null");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDEqualTo(String value) {
            addCriterion("FEEDBACKID =", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDNotEqualTo(String value) {
            addCriterion("FEEDBACKID <>", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDGreaterThan(String value) {
            addCriterion("FEEDBACKID >", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACKID >=", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDLessThan(String value) {
            addCriterion("FEEDBACKID <", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACKID <=", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDLike(String value) {
            addCriterion("FEEDBACKID like", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDNotLike(String value) {
            addCriterion("FEEDBACKID not like", value, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDIn(List<String> values) {
            addCriterion("FEEDBACKID in", values, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDNotIn(List<String> values) {
            addCriterion("FEEDBACKID not in", values, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDBetween(String value1, String value2) {
            addCriterion("FEEDBACKID between", value1, value2, "FEEDBACKID");
            return (Criteria) this;
        }

        public Criteria andFEEDBACKIDNotBetween(String value1, String value2) {
            addCriterion("FEEDBACKID not between", value1, value2, "FEEDBACKID");
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

        public Criteria andMANAGERIDIsNull() {
            addCriterion("MANAGERID is null");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDIsNotNull() {
            addCriterion("MANAGERID is not null");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDEqualTo(String value) {
            addCriterion("MANAGERID =", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDNotEqualTo(String value) {
            addCriterion("MANAGERID <>", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDGreaterThan(String value) {
            addCriterion("MANAGERID >", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGERID >=", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDLessThan(String value) {
            addCriterion("MANAGERID <", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDLessThanOrEqualTo(String value) {
            addCriterion("MANAGERID <=", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDLike(String value) {
            addCriterion("MANAGERID like", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDNotLike(String value) {
            addCriterion("MANAGERID not like", value, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDIn(List<String> values) {
            addCriterion("MANAGERID in", values, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDNotIn(List<String> values) {
            addCriterion("MANAGERID not in", values, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDBetween(String value1, String value2) {
            addCriterion("MANAGERID between", value1, value2, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andMANAGERIDNotBetween(String value1, String value2) {
            addCriterion("MANAGERID not between", value1, value2, "MANAGERID");
            return (Criteria) this;
        }

        public Criteria andEMAILIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEMAILIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEMAILEqualTo(String value) {
            addCriterion("EMAIL =", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILGreaterThan(String value) {
            addCriterion("EMAIL >", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLessThan(String value) {
            addCriterion("EMAIL <", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLike(String value) {
            addCriterion("EMAIL like", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotLike(String value) {
            addCriterion("EMAIL not like", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILIn(List<String> values) {
            addCriterion("EMAIL in", values, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andPHONEIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPHONEIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPHONEEqualTo(String value) {
            addCriterion("PHONE =", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotEqualTo(String value) {
            addCriterion("PHONE <>", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEGreaterThan(String value) {
            addCriterion("PHONE >", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELessThan(String value) {
            addCriterion("PHONE <", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELike(String value) {
            addCriterion("PHONE like", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotLike(String value) {
            addCriterion("PHONE not like", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEIn(List<String> values) {
            addCriterion("PHONE in", values, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotIn(List<String> values) {
            addCriterion("PHONE not in", values, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "PHONE");
            return (Criteria) this;
        }

        public Criteria andISDEALIsNull() {
            addCriterion("ISDEAL is null");
            return (Criteria) this;
        }

        public Criteria andISDEALIsNotNull() {
            addCriterion("ISDEAL is not null");
            return (Criteria) this;
        }

        public Criteria andISDEALEqualTo(String value) {
            addCriterion("ISDEAL =", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALNotEqualTo(String value) {
            addCriterion("ISDEAL <>", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALGreaterThan(String value) {
            addCriterion("ISDEAL >", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALGreaterThanOrEqualTo(String value) {
            addCriterion("ISDEAL >=", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALLessThan(String value) {
            addCriterion("ISDEAL <", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALLessThanOrEqualTo(String value) {
            addCriterion("ISDEAL <=", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALLike(String value) {
            addCriterion("ISDEAL like", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALNotLike(String value) {
            addCriterion("ISDEAL not like", value, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALIn(List<String> values) {
            addCriterion("ISDEAL in", values, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALNotIn(List<String> values) {
            addCriterion("ISDEAL not in", values, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALBetween(String value1, String value2) {
            addCriterion("ISDEAL between", value1, value2, "ISDEAL");
            return (Criteria) this;
        }

        public Criteria andISDEALNotBetween(String value1, String value2) {
            addCriterion("ISDEAL not between", value1, value2, "ISDEAL");
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

        public Criteria andCREATETIMEEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMELessThan(Date value) {
            addCriterion("CREATETIME <", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMELessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMEBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andCREATETIMENotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "CREATETIME");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEIsNull() {
            addCriterion("USERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEIsNotNull() {
            addCriterion("USERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEEqualTo(String value) {
            addCriterion("USERTYPE =", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPENotEqualTo(String value) {
            addCriterion("USERTYPE <>", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEGreaterThan(String value) {
            addCriterion("USERTYPE >", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("USERTYPE >=", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPELessThan(String value) {
            addCriterion("USERTYPE <", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPELessThanOrEqualTo(String value) {
            addCriterion("USERTYPE <=", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPELike(String value) {
            addCriterion("USERTYPE like", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPENotLike(String value) {
            addCriterion("USERTYPE not like", value, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEIn(List<String> values) {
            addCriterion("USERTYPE in", values, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPENotIn(List<String> values) {
            addCriterion("USERTYPE not in", values, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPEBetween(String value1, String value2) {
            addCriterion("USERTYPE between", value1, value2, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andUSERTYPENotBetween(String value1, String value2) {
            addCriterion("USERTYPE not between", value1, value2, "USERTYPE");
            return (Criteria) this;
        }

        public Criteria andTYPEIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTYPEIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTYPEEqualTo(String value) {
            addCriterion("TYPE =", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPENotEqualTo(String value) {
            addCriterion("TYPE <>", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPEGreaterThan(String value) {
            addCriterion("TYPE >", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPELessThan(String value) {
            addCriterion("TYPE <", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPELessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPELike(String value) {
            addCriterion("TYPE like", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPENotLike(String value) {
            addCriterion("TYPE not like", value, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPEIn(List<String> values) {
            addCriterion("TYPE in", values, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPENotIn(List<String> values) {
            addCriterion("TYPE not in", values, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPEBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "TYPE");
            return (Criteria) this;
        }

        public Criteria andTYPENotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "TYPE");
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