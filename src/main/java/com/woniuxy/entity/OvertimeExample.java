package com.woniuxy.entity;

import java.util.ArrayList;
import java.util.List;

public class OvertimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OvertimeExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(String value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(String value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(String value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(String value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(String value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(String value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLike(String value) {
            addCriterion("oid like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotLike(String value) {
            addCriterion("oid not like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<String> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<String> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(String value1, String value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(String value1, String value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOnameIsNull() {
            addCriterion("oname is null");
            return (Criteria) this;
        }

        public Criteria andOnameIsNotNull() {
            addCriterion("oname is not null");
            return (Criteria) this;
        }

        public Criteria andOnameEqualTo(String value) {
            addCriterion("oname =", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotEqualTo(String value) {
            addCriterion("oname <>", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThan(String value) {
            addCriterion("oname >", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThanOrEqualTo(String value) {
            addCriterion("oname >=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThan(String value) {
            addCriterion("oname <", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThanOrEqualTo(String value) {
            addCriterion("oname <=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLike(String value) {
            addCriterion("oname like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotLike(String value) {
            addCriterion("oname not like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameIn(List<String> values) {
            addCriterion("oname in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotIn(List<String> values) {
            addCriterion("oname not in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameBetween(String value1, String value2) {
            addCriterion("oname between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotBetween(String value1, String value2) {
            addCriterion("oname not between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNull() {
            addCriterion("submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(String value) {
            addCriterion("submitTime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(String value) {
            addCriterion("submitTime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(String value) {
            addCriterion("submitTime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(String value) {
            addCriterion("submitTime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(String value) {
            addCriterion("submitTime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(String value) {
            addCriterion("submitTime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLike(String value) {
            addCriterion("submitTime like", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotLike(String value) {
            addCriterion("submitTime not like", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<String> values) {
            addCriterion("submitTime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<String> values) {
            addCriterion("submitTime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(String value1, String value2) {
            addCriterion("submitTime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(String value1, String value2) {
            addCriterion("submitTime not between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andOtbeginIsNull() {
            addCriterion("otBegin is null");
            return (Criteria) this;
        }

        public Criteria andOtbeginIsNotNull() {
            addCriterion("otBegin is not null");
            return (Criteria) this;
        }

        public Criteria andOtbeginEqualTo(String value) {
            addCriterion("otBegin =", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginNotEqualTo(String value) {
            addCriterion("otBegin <>", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginGreaterThan(String value) {
            addCriterion("otBegin >", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginGreaterThanOrEqualTo(String value) {
            addCriterion("otBegin >=", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginLessThan(String value) {
            addCriterion("otBegin <", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginLessThanOrEqualTo(String value) {
            addCriterion("otBegin <=", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginLike(String value) {
            addCriterion("otBegin like", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginNotLike(String value) {
            addCriterion("otBegin not like", value, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginIn(List<String> values) {
            addCriterion("otBegin in", values, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginNotIn(List<String> values) {
            addCriterion("otBegin not in", values, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginBetween(String value1, String value2) {
            addCriterion("otBegin between", value1, value2, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtbeginNotBetween(String value1, String value2) {
            addCriterion("otBegin not between", value1, value2, "otbegin");
            return (Criteria) this;
        }

        public Criteria andOtoverIsNull() {
            addCriterion("otOver is null");
            return (Criteria) this;
        }

        public Criteria andOtoverIsNotNull() {
            addCriterion("otOver is not null");
            return (Criteria) this;
        }

        public Criteria andOtoverEqualTo(String value) {
            addCriterion("otOver =", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverNotEqualTo(String value) {
            addCriterion("otOver <>", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverGreaterThan(String value) {
            addCriterion("otOver >", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverGreaterThanOrEqualTo(String value) {
            addCriterion("otOver >=", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverLessThan(String value) {
            addCriterion("otOver <", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverLessThanOrEqualTo(String value) {
            addCriterion("otOver <=", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverLike(String value) {
            addCriterion("otOver like", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverNotLike(String value) {
            addCriterion("otOver not like", value, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverIn(List<String> values) {
            addCriterion("otOver in", values, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverNotIn(List<String> values) {
            addCriterion("otOver not in", values, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverBetween(String value1, String value2) {
            addCriterion("otOver between", value1, value2, "otover");
            return (Criteria) this;
        }

        public Criteria andOtoverNotBetween(String value1, String value2) {
            addCriterion("otOver not between", value1, value2, "otover");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNull() {
            addCriterion("discription is null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNotNull() {
            addCriterion("discription is not null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionEqualTo(String value) {
            addCriterion("discription =", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotEqualTo(String value) {
            addCriterion("discription <>", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThan(String value) {
            addCriterion("discription >", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("discription >=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThan(String value) {
            addCriterion("discription <", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThanOrEqualTo(String value) {
            addCriterion("discription <=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLike(String value) {
            addCriterion("discription like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotLike(String value) {
            addCriterion("discription not like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIn(List<String> values) {
            addCriterion("discription in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotIn(List<String> values) {
            addCriterion("discription not in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionBetween(String value1, String value2) {
            addCriterion("discription between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotBetween(String value1, String value2) {
            addCriterion("discription not between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andIsratifyIsNull() {
            addCriterion("isRatify is null");
            return (Criteria) this;
        }

        public Criteria andIsratifyIsNotNull() {
            addCriterion("isRatify is not null");
            return (Criteria) this;
        }

        public Criteria andIsratifyEqualTo(Integer value) {
            addCriterion("isRatify =", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyNotEqualTo(Integer value) {
            addCriterion("isRatify <>", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyGreaterThan(Integer value) {
            addCriterion("isRatify >", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("isRatify >=", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyLessThan(Integer value) {
            addCriterion("isRatify <", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyLessThanOrEqualTo(Integer value) {
            addCriterion("isRatify <=", value, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyIn(List<Integer> values) {
            addCriterion("isRatify in", values, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyNotIn(List<Integer> values) {
            addCriterion("isRatify not in", values, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyBetween(Integer value1, Integer value2) {
            addCriterion("isRatify between", value1, value2, "isratify");
            return (Criteria) this;
        }

        public Criteria andIsratifyNotBetween(Integer value1, Integer value2) {
            addCriterion("isRatify not between", value1, value2, "isratify");
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