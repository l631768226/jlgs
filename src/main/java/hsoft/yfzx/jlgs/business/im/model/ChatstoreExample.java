package hsoft.yfzx.jlgs.business.im.model;

import java.util.ArrayList;
import java.util.List;

public class ChatstoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatstoreExample() {
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

        public Criteria andCHATSTOREIDIsNull() {
            addCriterion("CHATSTOREID is null");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDIsNotNull() {
            addCriterion("CHATSTOREID is not null");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDEqualTo(String value) {
            addCriterion("CHATSTOREID =", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDNotEqualTo(String value) {
            addCriterion("CHATSTOREID <>", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDGreaterThan(String value) {
            addCriterion("CHATSTOREID >", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDGreaterThanOrEqualTo(String value) {
            addCriterion("CHATSTOREID >=", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDLessThan(String value) {
            addCriterion("CHATSTOREID <", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDLessThanOrEqualTo(String value) {
            addCriterion("CHATSTOREID <=", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDLike(String value) {
            addCriterion("CHATSTOREID like", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDNotLike(String value) {
            addCriterion("CHATSTOREID not like", value, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDIn(List<String> values) {
            addCriterion("CHATSTOREID in", values, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDNotIn(List<String> values) {
            addCriterion("CHATSTOREID not in", values, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDBetween(String value1, String value2) {
            addCriterion("CHATSTOREID between", value1, value2, "CHATSTOREID");
            return (Criteria) this;
        }

        public Criteria andCHATSTOREIDNotBetween(String value1, String value2) {
            addCriterion("CHATSTOREID not between", value1, value2, "CHATSTOREID");
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

        public Criteria andSENDERIDIsNull() {
            addCriterion("SENDERID is null");
            return (Criteria) this;
        }

        public Criteria andSENDERIDIsNotNull() {
            addCriterion("SENDERID is not null");
            return (Criteria) this;
        }

        public Criteria andSENDERIDEqualTo(String value) {
            addCriterion("SENDERID =", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDNotEqualTo(String value) {
            addCriterion("SENDERID <>", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDGreaterThan(String value) {
            addCriterion("SENDERID >", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDGreaterThanOrEqualTo(String value) {
            addCriterion("SENDERID >=", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDLessThan(String value) {
            addCriterion("SENDERID <", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDLessThanOrEqualTo(String value) {
            addCriterion("SENDERID <=", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDLike(String value) {
            addCriterion("SENDERID like", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDNotLike(String value) {
            addCriterion("SENDERID not like", value, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDIn(List<String> values) {
            addCriterion("SENDERID in", values, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDNotIn(List<String> values) {
            addCriterion("SENDERID not in", values, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDBetween(String value1, String value2) {
            addCriterion("SENDERID between", value1, value2, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERIDNotBetween(String value1, String value2) {
            addCriterion("SENDERID not between", value1, value2, "SENDERID");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEIsNull() {
            addCriterion("SENDERNAME is null");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEIsNotNull() {
            addCriterion("SENDERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEEqualTo(String value) {
            addCriterion("SENDERNAME =", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMENotEqualTo(String value) {
            addCriterion("SENDERNAME <>", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEGreaterThan(String value) {
            addCriterion("SENDERNAME >", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("SENDERNAME >=", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMELessThan(String value) {
            addCriterion("SENDERNAME <", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMELessThanOrEqualTo(String value) {
            addCriterion("SENDERNAME <=", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMELike(String value) {
            addCriterion("SENDERNAME like", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMENotLike(String value) {
            addCriterion("SENDERNAME not like", value, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEIn(List<String> values) {
            addCriterion("SENDERNAME in", values, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMENotIn(List<String> values) {
            addCriterion("SENDERNAME not in", values, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMEBetween(String value1, String value2) {
            addCriterion("SENDERNAME between", value1, value2, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andSENDERNAMENotBetween(String value1, String value2) {
            addCriterion("SENDERNAME not between", value1, value2, "SENDERNAME");
            return (Criteria) this;
        }

        public Criteria andRECEIDIsNull() {
            addCriterion("RECEID is null");
            return (Criteria) this;
        }

        public Criteria andRECEIDIsNotNull() {
            addCriterion("RECEID is not null");
            return (Criteria) this;
        }

        public Criteria andRECEIDEqualTo(String value) {
            addCriterion("RECEID =", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDNotEqualTo(String value) {
            addCriterion("RECEID <>", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDGreaterThan(String value) {
            addCriterion("RECEID >", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDGreaterThanOrEqualTo(String value) {
            addCriterion("RECEID >=", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDLessThan(String value) {
            addCriterion("RECEID <", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDLessThanOrEqualTo(String value) {
            addCriterion("RECEID <=", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDLike(String value) {
            addCriterion("RECEID like", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDNotLike(String value) {
            addCriterion("RECEID not like", value, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDIn(List<String> values) {
            addCriterion("RECEID in", values, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDNotIn(List<String> values) {
            addCriterion("RECEID not in", values, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDBetween(String value1, String value2) {
            addCriterion("RECEID between", value1, value2, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECEIDNotBetween(String value1, String value2) {
            addCriterion("RECEID not between", value1, value2, "RECEID");
            return (Criteria) this;
        }

        public Criteria andRECENAMEIsNull() {
            addCriterion("RECENAME is null");
            return (Criteria) this;
        }

        public Criteria andRECENAMEIsNotNull() {
            addCriterion("RECENAME is not null");
            return (Criteria) this;
        }

        public Criteria andRECENAMEEqualTo(String value) {
            addCriterion("RECENAME =", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMENotEqualTo(String value) {
            addCriterion("RECENAME <>", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMEGreaterThan(String value) {
            addCriterion("RECENAME >", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMEGreaterThanOrEqualTo(String value) {
            addCriterion("RECENAME >=", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMELessThan(String value) {
            addCriterion("RECENAME <", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMELessThanOrEqualTo(String value) {
            addCriterion("RECENAME <=", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMELike(String value) {
            addCriterion("RECENAME like", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMENotLike(String value) {
            addCriterion("RECENAME not like", value, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMEIn(List<String> values) {
            addCriterion("RECENAME in", values, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMENotIn(List<String> values) {
            addCriterion("RECENAME not in", values, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMEBetween(String value1, String value2) {
            addCriterion("RECENAME between", value1, value2, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andRECENAMENotBetween(String value1, String value2) {
            addCriterion("RECENAME not between", value1, value2, "RECENAME");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEIsNull() {
            addCriterion("MSGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEIsNotNull() {
            addCriterion("MSGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEEqualTo(String value) {
            addCriterion("MSGTYPE =", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPENotEqualTo(String value) {
            addCriterion("MSGTYPE <>", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEGreaterThan(String value) {
            addCriterion("MSGTYPE >", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTYPE >=", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPELessThan(String value) {
            addCriterion("MSGTYPE <", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPELessThanOrEqualTo(String value) {
            addCriterion("MSGTYPE <=", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPELike(String value) {
            addCriterion("MSGTYPE like", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPENotLike(String value) {
            addCriterion("MSGTYPE not like", value, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEIn(List<String> values) {
            addCriterion("MSGTYPE in", values, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPENotIn(List<String> values) {
            addCriterion("MSGTYPE not in", values, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPEBetween(String value1, String value2) {
            addCriterion("MSGTYPE between", value1, value2, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andMSGTYPENotBetween(String value1, String value2) {
            addCriterion("MSGTYPE not between", value1, value2, "MSGTYPE");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEIsNull() {
            addCriterion("SENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEIsNotNull() {
            addCriterion("SENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEEqualTo(Long value) {
            addCriterion("SENDTIME =", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMENotEqualTo(Long value) {
            addCriterion("SENDTIME <>", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEGreaterThan(Long value) {
            addCriterion("SENDTIME >", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEGreaterThanOrEqualTo(Long value) {
            addCriterion("SENDTIME >=", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMELessThan(Long value) {
            addCriterion("SENDTIME <", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMELessThanOrEqualTo(Long value) {
            addCriterion("SENDTIME <=", value, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEIn(List<Long> values) {
            addCriterion("SENDTIME in", values, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMENotIn(List<Long> values) {
            addCriterion("SENDTIME not in", values, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMEBetween(Long value1, Long value2) {
            addCriterion("SENDTIME between", value1, value2, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDTIMENotBetween(Long value1, Long value2) {
            addCriterion("SENDTIME not between", value1, value2, "SENDTIME");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSIsNull() {
            addCriterion("SENDSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSIsNotNull() {
            addCriterion("SENDSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSEqualTo(String value) {
            addCriterion("SENDSTATUS =", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSNotEqualTo(String value) {
            addCriterion("SENDSTATUS <>", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSGreaterThan(String value) {
            addCriterion("SENDSTATUS >", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSGreaterThanOrEqualTo(String value) {
            addCriterion("SENDSTATUS >=", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSLessThan(String value) {
            addCriterion("SENDSTATUS <", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSLessThanOrEqualTo(String value) {
            addCriterion("SENDSTATUS <=", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSLike(String value) {
            addCriterion("SENDSTATUS like", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSNotLike(String value) {
            addCriterion("SENDSTATUS not like", value, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSIn(List<String> values) {
            addCriterion("SENDSTATUS in", values, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSNotIn(List<String> values) {
            addCriterion("SENDSTATUS not in", values, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSBetween(String value1, String value2) {
            addCriterion("SENDSTATUS between", value1, value2, "SENDSTATUS");
            return (Criteria) this;
        }

        public Criteria andSENDSTATUSNotBetween(String value1, String value2) {
            addCriterion("SENDSTATUS not between", value1, value2, "SENDSTATUS");
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