package com.tiiaan.tbm.metaj.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstanceExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andSegmentsIsNull() {
            addCriterion("segments is null");
            return (Criteria) this;
        }

        public Criteria andSegmentsIsNotNull() {
            addCriterion("segments is not null");
            return (Criteria) this;
        }

        public Criteria andSegmentsEqualTo(Integer value) {
            addCriterion("segments =", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsNotEqualTo(Integer value) {
            addCriterion("segments <>", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsGreaterThan(Integer value) {
            addCriterion("segments >", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("segments >=", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsLessThan(Integer value) {
            addCriterion("segments <", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsLessThanOrEqualTo(Integer value) {
            addCriterion("segments <=", value, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsIn(List<Integer> values) {
            addCriterion("segments in", values, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsNotIn(List<Integer> values) {
            addCriterion("segments not in", values, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsBetween(Integer value1, Integer value2) {
            addCriterion("segments between", value1, value2, "segments");
            return (Criteria) this;
        }

        public Criteria andSegmentsNotBetween(Integer value1, Integer value2) {
            addCriterion("segments not between", value1, value2, "segments");
            return (Criteria) this;
        }

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(Long value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(Long value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(Long value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(Long value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(Long value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(Long value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<Long> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<Long> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(Long value1, Long value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(Long value1, Long value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andHealthIsNull() {
            addCriterion("health is null");
            return (Criteria) this;
        }

        public Criteria andHealthIsNotNull() {
            addCriterion("health is not null");
            return (Criteria) this;
        }

        public Criteria andHealthEqualTo(Byte value) {
            addCriterion("health =", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotEqualTo(Byte value) {
            addCriterion("health <>", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThan(Byte value) {
            addCriterion("health >", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThanOrEqualTo(Byte value) {
            addCriterion("health >=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThan(Byte value) {
            addCriterion("health <", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThanOrEqualTo(Byte value) {
            addCriterion("health <=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthIn(List<Byte> values) {
            addCriterion("health in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotIn(List<Byte> values) {
            addCriterion("health not in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthBetween(Byte value1, Byte value2) {
            addCriterion("health between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotBetween(Byte value1, Byte value2) {
            addCriterion("health not between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentIsNull() {
            addCriterion("current_segment is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentIsNotNull() {
            addCriterion("current_segment is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentEqualTo(Integer value) {
            addCriterion("current_segment =", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentNotEqualTo(Integer value) {
            addCriterion("current_segment <>", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentGreaterThan(Integer value) {
            addCriterion("current_segment >", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_segment >=", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentLessThan(Integer value) {
            addCriterion("current_segment <", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentLessThanOrEqualTo(Integer value) {
            addCriterion("current_segment <=", value, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentIn(List<Integer> values) {
            addCriterion("current_segment in", values, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentNotIn(List<Integer> values) {
            addCriterion("current_segment not in", values, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentBetween(Integer value1, Integer value2) {
            addCriterion("current_segment between", value1, value2, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andCurrentSegmentNotBetween(Integer value1, Integer value2) {
            addCriterion("current_segment not between", value1, value2, "currentSegment");
            return (Criteria) this;
        }

        public Criteria andIssuesIsNull() {
            addCriterion("issues is null");
            return (Criteria) this;
        }

        public Criteria andIssuesIsNotNull() {
            addCriterion("issues is not null");
            return (Criteria) this;
        }

        public Criteria andIssuesEqualTo(Integer value) {
            addCriterion("issues =", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotEqualTo(Integer value) {
            addCriterion("issues <>", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesGreaterThan(Integer value) {
            addCriterion("issues >", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesGreaterThanOrEqualTo(Integer value) {
            addCriterion("issues >=", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesLessThan(Integer value) {
            addCriterion("issues <", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesLessThanOrEqualTo(Integer value) {
            addCriterion("issues <=", value, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesIn(List<Integer> values) {
            addCriterion("issues in", values, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotIn(List<Integer> values) {
            addCriterion("issues not in", values, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesBetween(Integer value1, Integer value2) {
            addCriterion("issues between", value1, value2, "issues");
            return (Criteria) this;
        }

        public Criteria andIssuesNotBetween(Integer value1, Integer value2) {
            addCriterion("issues not between", value1, value2, "issues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesIsNull() {
            addCriterion("unsolved_issues is null");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesIsNotNull() {
            addCriterion("unsolved_issues is not null");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesEqualTo(Integer value) {
            addCriterion("unsolved_issues =", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesNotEqualTo(Integer value) {
            addCriterion("unsolved_issues <>", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesGreaterThan(Integer value) {
            addCriterion("unsolved_issues >", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesGreaterThanOrEqualTo(Integer value) {
            addCriterion("unsolved_issues >=", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesLessThan(Integer value) {
            addCriterion("unsolved_issues <", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesLessThanOrEqualTo(Integer value) {
            addCriterion("unsolved_issues <=", value, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesIn(List<Integer> values) {
            addCriterion("unsolved_issues in", values, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesNotIn(List<Integer> values) {
            addCriterion("unsolved_issues not in", values, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesBetween(Integer value1, Integer value2) {
            addCriterion("unsolved_issues between", value1, value2, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andUnsolvedIssuesNotBetween(Integer value1, Integer value2) {
            addCriterion("unsolved_issues not between", value1, value2, "unsolvedIssues");
            return (Criteria) this;
        }

        public Criteria andWatchingIsNull() {
            addCriterion("watching is null");
            return (Criteria) this;
        }

        public Criteria andWatchingIsNotNull() {
            addCriterion("watching is not null");
            return (Criteria) this;
        }

        public Criteria andWatchingEqualTo(Integer value) {
            addCriterion("watching =", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingNotEqualTo(Integer value) {
            addCriterion("watching <>", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingGreaterThan(Integer value) {
            addCriterion("watching >", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingGreaterThanOrEqualTo(Integer value) {
            addCriterion("watching >=", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingLessThan(Integer value) {
            addCriterion("watching <", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingLessThanOrEqualTo(Integer value) {
            addCriterion("watching <=", value, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingIn(List<Integer> values) {
            addCriterion("watching in", values, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingNotIn(List<Integer> values) {
            addCriterion("watching not in", values, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingBetween(Integer value1, Integer value2) {
            addCriterion("watching between", value1, value2, "watching");
            return (Criteria) this;
        }

        public Criteria andWatchingNotBetween(Integer value1, Integer value2) {
            addCriterion("watching not between", value1, value2, "watching");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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