package hsoft.yfzx.jlgs.business.im.model;

import java.util.ArrayList;
import java.util.List;

public class ChatcfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatcfgExample() {
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

        public Criteria andCHATCFGIDIsNull() {
            addCriterion("CHATCFGID is null");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDIsNotNull() {
            addCriterion("CHATCFGID is not null");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDEqualTo(String value) {
            addCriterion("CHATCFGID =", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDNotEqualTo(String value) {
            addCriterion("CHATCFGID <>", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDGreaterThan(String value) {
            addCriterion("CHATCFGID >", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDGreaterThanOrEqualTo(String value) {
            addCriterion("CHATCFGID >=", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDLessThan(String value) {
            addCriterion("CHATCFGID <", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDLessThanOrEqualTo(String value) {
            addCriterion("CHATCFGID <=", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDLike(String value) {
            addCriterion("CHATCFGID like", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDNotLike(String value) {
            addCriterion("CHATCFGID not like", value, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDIn(List<String> values) {
            addCriterion("CHATCFGID in", values, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDNotIn(List<String> values) {
            addCriterion("CHATCFGID not in", values, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDBetween(String value1, String value2) {
            addCriterion("CHATCFGID between", value1, value2, "CHATCFGID");
            return (Criteria) this;
        }

        public Criteria andCHATCFGIDNotBetween(String value1, String value2) {
            addCriterion("CHATCFGID not between", value1, value2, "CHATCFGID");
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

        public Criteria andOBJECTIDIsNull() {
            addCriterion("OBJECTID is null");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDIsNotNull() {
            addCriterion("OBJECTID is not null");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDEqualTo(String value) {
            addCriterion("OBJECTID =", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDNotEqualTo(String value) {
            addCriterion("OBJECTID <>", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDGreaterThan(String value) {
            addCriterion("OBJECTID >", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECTID >=", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDLessThan(String value) {
            addCriterion("OBJECTID <", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDLessThanOrEqualTo(String value) {
            addCriterion("OBJECTID <=", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDLike(String value) {
            addCriterion("OBJECTID like", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDNotLike(String value) {
            addCriterion("OBJECTID not like", value, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDIn(List<String> values) {
            addCriterion("OBJECTID in", values, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDNotIn(List<String> values) {
            addCriterion("OBJECTID not in", values, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDBetween(String value1, String value2) {
            addCriterion("OBJECTID between", value1, value2, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andOBJECTIDNotBetween(String value1, String value2) {
            addCriterion("OBJECTID not between", value1, value2, "OBJECTID");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSIsNull() {
            addCriterion("TOPSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSIsNotNull() {
            addCriterion("TOPSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSEqualTo(String value) {
            addCriterion("TOPSTATUS =", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSNotEqualTo(String value) {
            addCriterion("TOPSTATUS <>", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSGreaterThan(String value) {
            addCriterion("TOPSTATUS >", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSGreaterThanOrEqualTo(String value) {
            addCriterion("TOPSTATUS >=", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSLessThan(String value) {
            addCriterion("TOPSTATUS <", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSLessThanOrEqualTo(String value) {
            addCriterion("TOPSTATUS <=", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSLike(String value) {
            addCriterion("TOPSTATUS like", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSNotLike(String value) {
            addCriterion("TOPSTATUS not like", value, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSIn(List<String> values) {
            addCriterion("TOPSTATUS in", values, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSNotIn(List<String> values) {
            addCriterion("TOPSTATUS not in", values, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSBetween(String value1, String value2) {
            addCriterion("TOPSTATUS between", value1, value2, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andTOPSTATUSNotBetween(String value1, String value2) {
            addCriterion("TOPSTATUS not between", value1, value2, "TOPSTATUS");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEIsNull() {
            addCriterion("OBJECTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEIsNotNull() {
            addCriterion("OBJECTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEEqualTo(String value) {
            addCriterion("OBJECTTYPE =", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPENotEqualTo(String value) {
            addCriterion("OBJECTTYPE <>", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEGreaterThan(String value) {
            addCriterion("OBJECTTYPE >", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECTTYPE >=", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPELessThan(String value) {
            addCriterion("OBJECTTYPE <", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPELessThanOrEqualTo(String value) {
            addCriterion("OBJECTTYPE <=", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPELike(String value) {
            addCriterion("OBJECTTYPE like", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPENotLike(String value) {
            addCriterion("OBJECTTYPE not like", value, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEIn(List<String> values) {
            addCriterion("OBJECTTYPE in", values, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPENotIn(List<String> values) {
            addCriterion("OBJECTTYPE not in", values, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPEBetween(String value1, String value2) {
            addCriterion("OBJECTTYPE between", value1, value2, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andOBJECTTYPENotBetween(String value1, String value2) {
            addCriterion("OBJECTTYPE not between", value1, value2, "OBJECTTYPE");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDIsNull() {
            addCriterion("UNDISTURBED is null");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDIsNotNull() {
            addCriterion("UNDISTURBED is not null");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDEqualTo(String value) {
            addCriterion("UNDISTURBED =", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDNotEqualTo(String value) {
            addCriterion("UNDISTURBED <>", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDGreaterThan(String value) {
            addCriterion("UNDISTURBED >", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDGreaterThanOrEqualTo(String value) {
            addCriterion("UNDISTURBED >=", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDLessThan(String value) {
            addCriterion("UNDISTURBED <", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDLessThanOrEqualTo(String value) {
            addCriterion("UNDISTURBED <=", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDLike(String value) {
            addCriterion("UNDISTURBED like", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDNotLike(String value) {
            addCriterion("UNDISTURBED not like", value, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDIn(List<String> values) {
            addCriterion("UNDISTURBED in", values, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDNotIn(List<String> values) {
            addCriterion("UNDISTURBED not in", values, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDBetween(String value1, String value2) {
            addCriterion("UNDISTURBED between", value1, value2, "UNDISTURBED");
            return (Criteria) this;
        }

        public Criteria andUNDISTURBEDNotBetween(String value1, String value2) {
            addCriterion("UNDISTURBED not between", value1, value2, "UNDISTURBED");
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

        public Criteria andOBJECTNAMEIsNull() {
            addCriterion("OBJECTNAME is null");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEIsNotNull() {
            addCriterion("OBJECTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEEqualTo(String value) {
            addCriterion("OBJECTNAME =", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMENotEqualTo(String value) {
            addCriterion("OBJECTNAME <>", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEGreaterThan(String value) {
            addCriterion("OBJECTNAME >", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECTNAME >=", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMELessThan(String value) {
            addCriterion("OBJECTNAME <", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMELessThanOrEqualTo(String value) {
            addCriterion("OBJECTNAME <=", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMELike(String value) {
            addCriterion("OBJECTNAME like", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMENotLike(String value) {
            addCriterion("OBJECTNAME not like", value, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEIn(List<String> values) {
            addCriterion("OBJECTNAME in", values, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMENotIn(List<String> values) {
            addCriterion("OBJECTNAME not in", values, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMEBetween(String value1, String value2) {
            addCriterion("OBJECTNAME between", value1, value2, "OBJECTNAME");
            return (Criteria) this;
        }

        public Criteria andOBJECTNAMENotBetween(String value1, String value2) {
            addCriterion("OBJECTNAME not between", value1, value2, "OBJECTNAME");
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