package com.tiiaan.tbm.metaj.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SegmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SegmentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(Long value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(Long value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(Long value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(Long value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(Long value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<Long> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<Long> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(Long value1, Long value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(Long value1, Long value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andCircleSeqIsNull() {
            addCriterion("circle_seq is null");
            return (Criteria) this;
        }

        public Criteria andCircleSeqIsNotNull() {
            addCriterion("circle_seq is not null");
            return (Criteria) this;
        }

        public Criteria andCircleSeqEqualTo(Integer value) {
            addCriterion("circle_seq =", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqNotEqualTo(Integer value) {
            addCriterion("circle_seq <>", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqGreaterThan(Integer value) {
            addCriterion("circle_seq >", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("circle_seq >=", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqLessThan(Integer value) {
            addCriterion("circle_seq <", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqLessThanOrEqualTo(Integer value) {
            addCriterion("circle_seq <=", value, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqIn(List<Integer> values) {
            addCriterion("circle_seq in", values, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqNotIn(List<Integer> values) {
            addCriterion("circle_seq not in", values, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqBetween(Integer value1, Integer value2) {
            addCriterion("circle_seq between", value1, value2, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andCircleSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("circle_seq not between", value1, value2, "circleSeq");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(LocalDateTime value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(LocalDateTime value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(LocalDateTime value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(LocalDateTime value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<LocalDateTime> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<LocalDateTime> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(LocalDateTime value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(LocalDateTime value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(LocalDateTime value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(LocalDateTime value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<LocalDateTime> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<LocalDateTime> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andPropPeriodIsNull() {
            addCriterion("prop_period is null");
            return (Criteria) this;
        }

        public Criteria andPropPeriodIsNotNull() {
            addCriterion("prop_period is not null");
            return (Criteria) this;
        }

        public Criteria andPropPeriodEqualTo(Integer value) {
            addCriterion("prop_period =", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodNotEqualTo(Integer value) {
            addCriterion("prop_period <>", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodGreaterThan(Integer value) {
            addCriterion("prop_period >", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_period >=", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodLessThan(Integer value) {
            addCriterion("prop_period <", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("prop_period <=", value, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodIn(List<Integer> values) {
            addCriterion("prop_period in", values, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodNotIn(List<Integer> values) {
            addCriterion("prop_period not in", values, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodBetween(Integer value1, Integer value2) {
            addCriterion("prop_period between", value1, value2, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andPropPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_period not between", value1, value2, "propPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodIsNull() {
            addCriterion("asm_period is null");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodIsNotNull() {
            addCriterion("asm_period is not null");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodEqualTo(Integer value) {
            addCriterion("asm_period =", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodNotEqualTo(Integer value) {
            addCriterion("asm_period <>", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodGreaterThan(Integer value) {
            addCriterion("asm_period >", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("asm_period >=", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodLessThan(Integer value) {
            addCriterion("asm_period <", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("asm_period <=", value, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodIn(List<Integer> values) {
            addCriterion("asm_period in", values, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodNotIn(List<Integer> values) {
            addCriterion("asm_period not in", values, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodBetween(Integer value1, Integer value2) {
            addCriterion("asm_period between", value1, value2, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andAsmPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("asm_period not between", value1, value2, "asmPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodIsNull() {
            addCriterion("stop_period is null");
            return (Criteria) this;
        }

        public Criteria andStopPeriodIsNotNull() {
            addCriterion("stop_period is not null");
            return (Criteria) this;
        }

        public Criteria andStopPeriodEqualTo(Integer value) {
            addCriterion("stop_period =", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodNotEqualTo(Integer value) {
            addCriterion("stop_period <>", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodGreaterThan(Integer value) {
            addCriterion("stop_period >", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("stop_period >=", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodLessThan(Integer value) {
            addCriterion("stop_period <", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("stop_period <=", value, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodIn(List<Integer> values) {
            addCriterion("stop_period in", values, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodNotIn(List<Integer> values) {
            addCriterion("stop_period not in", values, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodBetween(Integer value1, Integer value2) {
            addCriterion("stop_period between", value1, value2, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andStopPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("stop_period not between", value1, value2, "stopPeriod");
            return (Criteria) this;
        }

        public Criteria andFillingAmountIsNull() {
            addCriterion("filling_amount is null");
            return (Criteria) this;
        }

        public Criteria andFillingAmountIsNotNull() {
            addCriterion("filling_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFillingAmountEqualTo(Integer value) {
            addCriterion("filling_amount =", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountNotEqualTo(Integer value) {
            addCriterion("filling_amount <>", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountGreaterThan(Integer value) {
            addCriterion("filling_amount >", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("filling_amount >=", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountLessThan(Integer value) {
            addCriterion("filling_amount <", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountLessThanOrEqualTo(Integer value) {
            addCriterion("filling_amount <=", value, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountIn(List<Integer> values) {
            addCriterion("filling_amount in", values, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountNotIn(List<Integer> values) {
            addCriterion("filling_amount not in", values, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountBetween(Integer value1, Integer value2) {
            addCriterion("filling_amount between", value1, value2, "fillingAmount");
            return (Criteria) this;
        }

        public Criteria andFillingAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("filling_amount not between", value1, value2, "fillingAmount");
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