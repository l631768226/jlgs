package hsoft.yfzx.jlgs.business.im.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLike(String value) {
            addCriterion("ID like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotLike(String value) {
            addCriterion("ID not like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<String> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<String> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDIsNull() {
            addCriterion("COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDIsNotNull() {
            addCriterion("COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDEqualTo(String value) {
            addCriterion("COMPANY_ID =", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDNotEqualTo(String value) {
            addCriterion("COMPANY_ID <>", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDGreaterThan(String value) {
            addCriterion("COMPANY_ID >", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID >=", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDLessThan(String value) {
            addCriterion("COMPANY_ID <", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID <=", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDLike(String value) {
            addCriterion("COMPANY_ID like", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDNotLike(String value) {
            addCriterion("COMPANY_ID not like", value, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDIn(List<String> values) {
            addCriterion("COMPANY_ID in", values, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDNotIn(List<String> values) {
            addCriterion("COMPANY_ID not in", values, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDBetween(String value1, String value2) {
            addCriterion("COMPANY_ID between", value1, value2, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andCOMPANY_IDNotBetween(String value1, String value2) {
            addCriterion("COMPANY_ID not between", value1, value2, "COMPANY_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDIsNull() {
            addCriterion("OFFICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDIsNotNull() {
            addCriterion("OFFICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDEqualTo(String value) {
            addCriterion("OFFICE_ID =", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDNotEqualTo(String value) {
            addCriterion("OFFICE_ID <>", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDGreaterThan(String value) {
            addCriterion("OFFICE_ID >", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDGreaterThanOrEqualTo(String value) {
            addCriterion("OFFICE_ID >=", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDLessThan(String value) {
            addCriterion("OFFICE_ID <", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDLessThanOrEqualTo(String value) {
            addCriterion("OFFICE_ID <=", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDLike(String value) {
            addCriterion("OFFICE_ID like", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDNotLike(String value) {
            addCriterion("OFFICE_ID not like", value, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDIn(List<String> values) {
            addCriterion("OFFICE_ID in", values, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDNotIn(List<String> values) {
            addCriterion("OFFICE_ID not in", values, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDBetween(String value1, String value2) {
            addCriterion("OFFICE_ID between", value1, value2, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andOFFICE_IDNotBetween(String value1, String value2) {
            addCriterion("OFFICE_ID not between", value1, value2, "OFFICE_ID");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEIsNull() {
            addCriterion("LOGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEIsNotNull() {
            addCriterion("LOGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEEqualTo(String value) {
            addCriterion("LOGIN_NAME =", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMENotEqualTo(String value) {
            addCriterion("LOGIN_NAME <>", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEGreaterThan(String value) {
            addCriterion("LOGIN_NAME >", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_NAME >=", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMELessThan(String value) {
            addCriterion("LOGIN_NAME <", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMELessThanOrEqualTo(String value) {
            addCriterion("LOGIN_NAME <=", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMELike(String value) {
            addCriterion("LOGIN_NAME like", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMENotLike(String value) {
            addCriterion("LOGIN_NAME not like", value, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEIn(List<String> values) {
            addCriterion("LOGIN_NAME in", values, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMENotIn(List<String> values) {
            addCriterion("LOGIN_NAME not in", values, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMEBetween(String value1, String value2) {
            addCriterion("LOGIN_NAME between", value1, value2, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andLOGIN_NAMENotBetween(String value1, String value2) {
            addCriterion("LOGIN_NAME not between", value1, value2, "LOGIN_NAME");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLike(String value) {
            addCriterion("PASSWORD like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotLike(String value) {
            addCriterion("PASSWORD not like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIn(List<String> values) {
            addCriterion("PASSWORD in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andNOIsNull() {
            addCriterion("NO is null");
            return (Criteria) this;
        }

        public Criteria andNOIsNotNull() {
            addCriterion("NO is not null");
            return (Criteria) this;
        }

        public Criteria andNOEqualTo(String value) {
            addCriterion("NO =", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNONotEqualTo(String value) {
            addCriterion("NO <>", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOGreaterThan(String value) {
            addCriterion("NO >", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOGreaterThanOrEqualTo(String value) {
            addCriterion("NO >=", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOLessThan(String value) {
            addCriterion("NO <", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOLessThanOrEqualTo(String value) {
            addCriterion("NO <=", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOLike(String value) {
            addCriterion("NO like", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNONotLike(String value) {
            addCriterion("NO not like", value, "NO");
            return (Criteria) this;
        }

        public Criteria andNOIn(List<String> values) {
            addCriterion("NO in", values, "NO");
            return (Criteria) this;
        }

        public Criteria andNONotIn(List<String> values) {
            addCriterion("NO not in", values, "NO");
            return (Criteria) this;
        }

        public Criteria andNOBetween(String value1, String value2) {
            addCriterion("NO between", value1, value2, "NO");
            return (Criteria) this;
        }

        public Criteria andNONotBetween(String value1, String value2) {
            addCriterion("NO not between", value1, value2, "NO");
            return (Criteria) this;
        }

        public Criteria andNAMEIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNAMEIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNAMEEqualTo(String value) {
            addCriterion("NAME =", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotEqualTo(String value) {
            addCriterion("NAME <>", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEGreaterThan(String value) {
            addCriterion("NAME >", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELessThan(String value) {
            addCriterion("NAME <", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELike(String value) {
            addCriterion("NAME like", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotLike(String value) {
            addCriterion("NAME not like", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEIn(List<String> values) {
            addCriterion("NAME in", values, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotIn(List<String> values) {
            addCriterion("NAME not in", values, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "NAME");
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

        public Criteria andMOBILEIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMOBILEIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMOBILEEqualTo(String value) {
            addCriterion("MOBILE =", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILENotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILEGreaterThan(String value) {
            addCriterion("MOBILE >", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILEGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILELessThan(String value) {
            addCriterion("MOBILE <", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILELessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILELike(String value) {
            addCriterion("MOBILE like", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILENotLike(String value) {
            addCriterion("MOBILE not like", value, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILEIn(List<String> values) {
            addCriterion("MOBILE in", values, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILENotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILEBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andMOBILENotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "MOBILE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPENotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPELessThan(String value) {
            addCriterion("USER_TYPE <", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPELessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPELike(String value) {
            addCriterion("USER_TYPE like", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPENotLike(String value) {
            addCriterion("USER_TYPE not like", value, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPENotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPEBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andUSER_TYPENotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "USER_TYPE");
            return (Criteria) this;
        }

        public Criteria andPHOTOIsNull() {
            addCriterion("PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andPHOTOIsNotNull() {
            addCriterion("PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andPHOTOEqualTo(String value) {
            addCriterion("PHOTO =", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotEqualTo(String value) {
            addCriterion("PHOTO <>", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOGreaterThan(String value) {
            addCriterion("PHOTO >", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO >=", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLessThan(String value) {
            addCriterion("PHOTO <", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLessThanOrEqualTo(String value) {
            addCriterion("PHOTO <=", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLike(String value) {
            addCriterion("PHOTO like", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotLike(String value) {
            addCriterion("PHOTO not like", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOIn(List<String> values) {
            addCriterion("PHOTO in", values, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotIn(List<String> values) {
            addCriterion("PHOTO not in", values, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOBetween(String value1, String value2) {
            addCriterion("PHOTO between", value1, value2, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotBetween(String value1, String value2) {
            addCriterion("PHOTO not between", value1, value2, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLike(String value) {
            addCriterion("LOGIN_IP like", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIsNull() {
            addCriterion("LOGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIsNotNull() {
            addCriterion("LOGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEEqualTo(Date value) {
            addCriterion("LOGIN_DATE =", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotEqualTo(Date value) {
            addCriterion("LOGIN_DATE <>", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEGreaterThan(Date value) {
            addCriterion("LOGIN_DATE >", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGIN_DATE >=", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATELessThan(Date value) {
            addCriterion("LOGIN_DATE <", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATELessThanOrEqualTo(Date value) {
            addCriterion("LOGIN_DATE <=", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIn(List<Date> values) {
            addCriterion("LOGIN_DATE in", values, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotIn(List<Date> values) {
            addCriterion("LOGIN_DATE not in", values, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEBetween(Date value1, Date value2) {
            addCriterion("LOGIN_DATE between", value1, value2, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotBetween(Date value1, Date value2) {
            addCriterion("LOGIN_DATE not between", value1, value2, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGIsNull() {
            addCriterion("LOGIN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGIsNotNull() {
            addCriterion("LOGIN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGEqualTo(String value) {
            addCriterion("LOGIN_FLAG =", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGNotEqualTo(String value) {
            addCriterion("LOGIN_FLAG <>", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGGreaterThan(String value) {
            addCriterion("LOGIN_FLAG >", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_FLAG >=", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGLessThan(String value) {
            addCriterion("LOGIN_FLAG <", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_FLAG <=", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGLike(String value) {
            addCriterion("LOGIN_FLAG like", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGNotLike(String value) {
            addCriterion("LOGIN_FLAG not like", value, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGIn(List<String> values) {
            addCriterion("LOGIN_FLAG in", values, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGNotIn(List<String> values) {
            addCriterion("LOGIN_FLAG not in", values, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGBetween(String value1, String value2) {
            addCriterion("LOGIN_FLAG between", value1, value2, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andLOGIN_FLAGNotBetween(String value1, String value2) {
            addCriterion("LOGIN_FLAG not between", value1, value2, "LOGIN_FLAG");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYLessThan(String value) {
            addCriterion("CREATE_BY <", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYLike(String value) {
            addCriterion("CREATE_BY like", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_BYNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "CREATE_BY");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATELessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATELessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYLike(String value) {
            addCriterion("UPDATE_BY like", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_BYNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "UPDATE_BY");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATELessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATELessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andREMARKSIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andREMARKSIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andREMARKSEqualTo(String value) {
            addCriterion("REMARKS =", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSGreaterThan(String value) {
            addCriterion("REMARKS >", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSLessThan(String value) {
            addCriterion("REMARKS <", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSLike(String value) {
            addCriterion("REMARKS like", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSNotLike(String value) {
            addCriterion("REMARKS not like", value, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSIn(List<String> values) {
            addCriterion("REMARKS in", values, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andREMARKSNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "REMARKS");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLike(String value) {
            addCriterion("DEL_FLAG like", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andQRCODEIsNull() {
            addCriterion("QRCODE is null");
            return (Criteria) this;
        }

        public Criteria andQRCODEIsNotNull() {
            addCriterion("QRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andQRCODEEqualTo(String value) {
            addCriterion("QRCODE =", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODENotEqualTo(String value) {
            addCriterion("QRCODE <>", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODEGreaterThan(String value) {
            addCriterion("QRCODE >", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODEGreaterThanOrEqualTo(String value) {
            addCriterion("QRCODE >=", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODELessThan(String value) {
            addCriterion("QRCODE <", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODELessThanOrEqualTo(String value) {
            addCriterion("QRCODE <=", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODELike(String value) {
            addCriterion("QRCODE like", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODENotLike(String value) {
            addCriterion("QRCODE not like", value, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODEIn(List<String> values) {
            addCriterion("QRCODE in", values, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODENotIn(List<String> values) {
            addCriterion("QRCODE not in", values, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODEBetween(String value1, String value2) {
            addCriterion("QRCODE between", value1, value2, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andQRCODENotBetween(String value1, String value2) {
            addCriterion("QRCODE not between", value1, value2, "QRCODE");
            return (Criteria) this;
        }

        public Criteria andSIGNIsNull() {
            addCriterion("SIGN is null");
            return (Criteria) this;
        }

        public Criteria andSIGNIsNotNull() {
            addCriterion("SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andSIGNEqualTo(String value) {
            addCriterion("SIGN =", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNNotEqualTo(String value) {
            addCriterion("SIGN <>", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNGreaterThan(String value) {
            addCriterion("SIGN >", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN >=", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNLessThan(String value) {
            addCriterion("SIGN <", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNLessThanOrEqualTo(String value) {
            addCriterion("SIGN <=", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNLike(String value) {
            addCriterion("SIGN like", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNNotLike(String value) {
            addCriterion("SIGN not like", value, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNIn(List<String> values) {
            addCriterion("SIGN in", values, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNNotIn(List<String> values) {
            addCriterion("SIGN not in", values, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNBetween(String value1, String value2) {
            addCriterion("SIGN between", value1, value2, "SIGN");
            return (Criteria) this;
        }

        public Criteria andSIGNNotBetween(String value1, String value2) {
            addCriterion("SIGN not between", value1, value2, "SIGN");
            return (Criteria) this;
        }

        public Criteria andGENDERIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGENDERIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGENDEREqualTo(String value) {
            addCriterion("GENDER =", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERGreaterThan(String value) {
            addCriterion("GENDER >", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERLessThan(String value) {
            addCriterion("GENDER <", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERLike(String value) {
            addCriterion("GENDER like", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERNotLike(String value) {
            addCriterion("GENDER not like", value, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERIn(List<String> values) {
            addCriterion("GENDER in", values, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "GENDER");
            return (Criteria) this;
        }

        public Criteria andGENDERNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "GENDER");
            return (Criteria) this;
        }

        public Criteria andPOSITIONIsNull() {
            addCriterion("POSITION is null");
            return (Criteria) this;
        }

        public Criteria andPOSITIONIsNotNull() {
            addCriterion("POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andPOSITIONEqualTo(String value) {
            addCriterion("POSITION =", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONNotEqualTo(String value) {
            addCriterion("POSITION <>", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONGreaterThan(String value) {
            addCriterion("POSITION >", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION >=", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONLessThan(String value) {
            addCriterion("POSITION <", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONLessThanOrEqualTo(String value) {
            addCriterion("POSITION <=", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONLike(String value) {
            addCriterion("POSITION like", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONNotLike(String value) {
            addCriterion("POSITION not like", value, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONIn(List<String> values) {
            addCriterion("POSITION in", values, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONNotIn(List<String> values) {
            addCriterion("POSITION not in", values, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONBetween(String value1, String value2) {
            addCriterion("POSITION between", value1, value2, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITIONNotBetween(String value1, String value2) {
            addCriterion("POSITION not between", value1, value2, "POSITION");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKIsNull() {
            addCriterion("POSITION_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKIsNotNull() {
            addCriterion("POSITION_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKEqualTo(String value) {
            addCriterion("POSITION_REMARK =", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKNotEqualTo(String value) {
            addCriterion("POSITION_REMARK <>", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKGreaterThan(String value) {
            addCriterion("POSITION_REMARK >", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_REMARK >=", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKLessThan(String value) {
            addCriterion("POSITION_REMARK <", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKLessThanOrEqualTo(String value) {
            addCriterion("POSITION_REMARK <=", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKLike(String value) {
            addCriterion("POSITION_REMARK like", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKNotLike(String value) {
            addCriterion("POSITION_REMARK not like", value, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKIn(List<String> values) {
            addCriterion("POSITION_REMARK in", values, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKNotIn(List<String> values) {
            addCriterion("POSITION_REMARK not in", values, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKBetween(String value1, String value2) {
            addCriterion("POSITION_REMARK between", value1, value2, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andPOSITION_REMARKNotBetween(String value1, String value2) {
            addCriterion("POSITION_REMARK not between", value1, value2, "POSITION_REMARK");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYEqualTo(Date value) {
            addCriterion("BIRTHDAY =", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotEqualTo(Date value) {
            addCriterion("BIRTHDAY <>", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYGreaterThan(Date value) {
            addCriterion("BIRTHDAY >", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYGreaterThanOrEqualTo(Date value) {
            addCriterion("BIRTHDAY >=", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYLessThan(Date value) {
            addCriterion("BIRTHDAY <", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYLessThanOrEqualTo(Date value) {
            addCriterion("BIRTHDAY <=", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIn(List<Date> values) {
            addCriterion("BIRTHDAY in", values, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotIn(List<Date> values) {
            addCriterion("BIRTHDAY not in", values, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYBetween(Date value1, Date value2) {
            addCriterion("BIRTHDAY between", value1, value2, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotBetween(Date value1, Date value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSIsNull() {
            addCriterion("WORK_YEARS is null");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSIsNotNull() {
            addCriterion("WORK_YEARS is not null");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSEqualTo(Date value) {
            addCriterion("WORK_YEARS =", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSNotEqualTo(Date value) {
            addCriterion("WORK_YEARS <>", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSGreaterThan(Date value) {
            addCriterion("WORK_YEARS >", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSGreaterThanOrEqualTo(Date value) {
            addCriterion("WORK_YEARS >=", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSLessThan(Date value) {
            addCriterion("WORK_YEARS <", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSLessThanOrEqualTo(Date value) {
            addCriterion("WORK_YEARS <=", value, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSIn(List<Date> values) {
            addCriterion("WORK_YEARS in", values, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSNotIn(List<Date> values) {
            addCriterion("WORK_YEARS not in", values, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSBetween(Date value1, Date value2) {
            addCriterion("WORK_YEARS between", value1, value2, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_YEARSNotBetween(Date value1, Date value2) {
            addCriterion("WORK_YEARS not between", value1, value2, "WORK_YEARS");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEIsNull() {
            addCriterion("WORK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEIsNotNull() {
            addCriterion("WORK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEEqualTo(String value) {
            addCriterion("WORK_STATE =", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATENotEqualTo(String value) {
            addCriterion("WORK_STATE <>", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEGreaterThan(String value) {
            addCriterion("WORK_STATE >", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_STATE >=", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATELessThan(String value) {
            addCriterion("WORK_STATE <", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATELessThanOrEqualTo(String value) {
            addCriterion("WORK_STATE <=", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATELike(String value) {
            addCriterion("WORK_STATE like", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATENotLike(String value) {
            addCriterion("WORK_STATE not like", value, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEIn(List<String> values) {
            addCriterion("WORK_STATE in", values, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATENotIn(List<String> values) {
            addCriterion("WORK_STATE not in", values, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATEBetween(String value1, String value2) {
            addCriterion("WORK_STATE between", value1, value2, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andWORK_STATENotBetween(String value1, String value2) {
            addCriterion("WORK_STATE not between", value1, value2, "WORK_STATE");
            return (Criteria) this;
        }

        public Criteria andDUTYIsNull() {
            addCriterion("DUTY is null");
            return (Criteria) this;
        }

        public Criteria andDUTYIsNotNull() {
            addCriterion("DUTY is not null");
            return (Criteria) this;
        }

        public Criteria andDUTYEqualTo(String value) {
            addCriterion("DUTY =", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYNotEqualTo(String value) {
            addCriterion("DUTY <>", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYGreaterThan(String value) {
            addCriterion("DUTY >", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYGreaterThanOrEqualTo(String value) {
            addCriterion("DUTY >=", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYLessThan(String value) {
            addCriterion("DUTY <", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYLessThanOrEqualTo(String value) {
            addCriterion("DUTY <=", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYLike(String value) {
            addCriterion("DUTY like", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYNotLike(String value) {
            addCriterion("DUTY not like", value, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYIn(List<String> values) {
            addCriterion("DUTY in", values, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYNotIn(List<String> values) {
            addCriterion("DUTY not in", values, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYBetween(String value1, String value2) {
            addCriterion("DUTY between", value1, value2, "DUTY");
            return (Criteria) this;
        }

        public Criteria andDUTYNotBetween(String value1, String value2) {
            addCriterion("DUTY not between", value1, value2, "DUTY");
            return (Criteria) this;
        }

        public Criteria andPOLITICSIsNull() {
            addCriterion("POLITICS is null");
            return (Criteria) this;
        }

        public Criteria andPOLITICSIsNotNull() {
            addCriterion("POLITICS is not null");
            return (Criteria) this;
        }

        public Criteria andPOLITICSEqualTo(String value) {
            addCriterion("POLITICS =", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSNotEqualTo(String value) {
            addCriterion("POLITICS <>", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSGreaterThan(String value) {
            addCriterion("POLITICS >", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSGreaterThanOrEqualTo(String value) {
            addCriterion("POLITICS >=", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSLessThan(String value) {
            addCriterion("POLITICS <", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSLessThanOrEqualTo(String value) {
            addCriterion("POLITICS <=", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSLike(String value) {
            addCriterion("POLITICS like", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSNotLike(String value) {
            addCriterion("POLITICS not like", value, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSIn(List<String> values) {
            addCriterion("POLITICS in", values, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSNotIn(List<String> values) {
            addCriterion("POLITICS not in", values, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSBetween(String value1, String value2) {
            addCriterion("POLITICS between", value1, value2, "POLITICS");
            return (Criteria) this;
        }

        public Criteria andPOLITICSNotBetween(String value1, String value2) {
            addCriterion("POLITICS not between", value1, value2, "POLITICS");
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