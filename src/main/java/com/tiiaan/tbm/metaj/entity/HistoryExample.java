package com.tiiaan.tbm.metaj.entity;

import java.util.ArrayList;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andIssueIdIsNull() {
            addCriterion("issue_id is null");
            return (Criteria) this;
        }

        public Criteria andIssueIdIsNotNull() {
            addCriterion("issue_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssueIdEqualTo(Long value) {
            addCriterion("issue_id =", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotEqualTo(Long value) {
            addCriterion("issue_id <>", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThan(Long value) {
            addCriterion("issue_id >", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("issue_id >=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThan(Long value) {
            addCriterion("issue_id <", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThanOrEqualTo(Long value) {
            addCriterion("issue_id <=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdIn(List<Long> values) {
            addCriterion("issue_id in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotIn(List<Long> values) {
            addCriterion("issue_id not in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdBetween(Long value1, Long value2) {
            addCriterion("issue_id between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotBetween(Long value1, Long value2) {
            addCriterion("issue_id not between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Long value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Long value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Long value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Long value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Long value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Long> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Long> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Long value1, Long value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Long value1, Long value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andMainTorqueIsNull() {
            addCriterion("main_torque is null");
            return (Criteria) this;
        }

        public Criteria andMainTorqueIsNotNull() {
            addCriterion("main_torque is not null");
            return (Criteria) this;
        }

        public Criteria andMainTorqueEqualTo(Double value) {
            addCriterion("main_torque =", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueNotEqualTo(Double value) {
            addCriterion("main_torque <>", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueGreaterThan(Double value) {
            addCriterion("main_torque >", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueGreaterThanOrEqualTo(Double value) {
            addCriterion("main_torque >=", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueLessThan(Double value) {
            addCriterion("main_torque <", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueLessThanOrEqualTo(Double value) {
            addCriterion("main_torque <=", value, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueIn(List<Double> values) {
            addCriterion("main_torque in", values, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueNotIn(List<Double> values) {
            addCriterion("main_torque not in", values, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueBetween(Double value1, Double value2) {
            addCriterion("main_torque between", value1, value2, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMainTorqueNotBetween(Double value1, Double value2) {
            addCriterion("main_torque not between", value1, value2, "mainTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueIsNull() {
            addCriterion("motor_torque is null");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueIsNotNull() {
            addCriterion("motor_torque is not null");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueEqualTo(Double value) {
            addCriterion("motor_torque =", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueNotEqualTo(Double value) {
            addCriterion("motor_torque <>", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueGreaterThan(Double value) {
            addCriterion("motor_torque >", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueGreaterThanOrEqualTo(Double value) {
            addCriterion("motor_torque >=", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueLessThan(Double value) {
            addCriterion("motor_torque <", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueLessThanOrEqualTo(Double value) {
            addCriterion("motor_torque <=", value, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueIn(List<Double> values) {
            addCriterion("motor_torque in", values, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueNotIn(List<Double> values) {
            addCriterion("motor_torque not in", values, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueBetween(Double value1, Double value2) {
            addCriterion("motor_torque between", value1, value2, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMotorTorqueNotBetween(Double value1, Double value2) {
            addCriterion("motor_torque not between", value1, value2, "motorTorque");
            return (Criteria) this;
        }

        public Criteria andMainForceIsNull() {
            addCriterion("main_force is null");
            return (Criteria) this;
        }

        public Criteria andMainForceIsNotNull() {
            addCriterion("main_force is not null");
            return (Criteria) this;
        }

        public Criteria andMainForceEqualTo(Double value) {
            addCriterion("main_force =", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceNotEqualTo(Double value) {
            addCriterion("main_force <>", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceGreaterThan(Double value) {
            addCriterion("main_force >", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceGreaterThanOrEqualTo(Double value) {
            addCriterion("main_force >=", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceLessThan(Double value) {
            addCriterion("main_force <", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceLessThanOrEqualTo(Double value) {
            addCriterion("main_force <=", value, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceIn(List<Double> values) {
            addCriterion("main_force in", values, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceNotIn(List<Double> values) {
            addCriterion("main_force not in", values, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceBetween(Double value1, Double value2) {
            addCriterion("main_force between", value1, value2, "mainForce");
            return (Criteria) this;
        }

        public Criteria andMainForceNotBetween(Double value1, Double value2) {
            addCriterion("main_force not between", value1, value2, "mainForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceIsNull() {
            addCriterion("bias_force is null");
            return (Criteria) this;
        }

        public Criteria andBiasForceIsNotNull() {
            addCriterion("bias_force is not null");
            return (Criteria) this;
        }

        public Criteria andBiasForceEqualTo(Double value) {
            addCriterion("bias_force =", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceNotEqualTo(Double value) {
            addCriterion("bias_force <>", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceGreaterThan(Double value) {
            addCriterion("bias_force >", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceGreaterThanOrEqualTo(Double value) {
            addCriterion("bias_force >=", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceLessThan(Double value) {
            addCriterion("bias_force <", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceLessThanOrEqualTo(Double value) {
            addCriterion("bias_force <=", value, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceIn(List<Double> values) {
            addCriterion("bias_force in", values, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceNotIn(List<Double> values) {
            addCriterion("bias_force not in", values, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceBetween(Double value1, Double value2) {
            addCriterion("bias_force between", value1, value2, "biasForce");
            return (Criteria) this;
        }

        public Criteria andBiasForceNotBetween(Double value1, Double value2) {
            addCriterion("bias_force not between", value1, value2, "biasForce");
            return (Criteria) this;
        }

        public Criteria andAsmPressureIsNull() {
            addCriterion("asm_pressure is null");
            return (Criteria) this;
        }

        public Criteria andAsmPressureIsNotNull() {
            addCriterion("asm_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andAsmPressureEqualTo(Double value) {
            addCriterion("asm_pressure =", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureNotEqualTo(Double value) {
            addCriterion("asm_pressure <>", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureGreaterThan(Double value) {
            addCriterion("asm_pressure >", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureGreaterThanOrEqualTo(Double value) {
            addCriterion("asm_pressure >=", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureLessThan(Double value) {
            addCriterion("asm_pressure <", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureLessThanOrEqualTo(Double value) {
            addCriterion("asm_pressure <=", value, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureIn(List<Double> values) {
            addCriterion("asm_pressure in", values, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureNotIn(List<Double> values) {
            addCriterion("asm_pressure not in", values, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureBetween(Double value1, Double value2) {
            addCriterion("asm_pressure between", value1, value2, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmPressureNotBetween(Double value1, Double value2) {
            addCriterion("asm_pressure not between", value1, value2, "asmPressure");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureIsNull() {
            addCriterion("asm_temperature is null");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureIsNotNull() {
            addCriterion("asm_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureEqualTo(Double value) {
            addCriterion("asm_temperature =", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureNotEqualTo(Double value) {
            addCriterion("asm_temperature <>", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureGreaterThan(Double value) {
            addCriterion("asm_temperature >", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("asm_temperature >=", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureLessThan(Double value) {
            addCriterion("asm_temperature <", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("asm_temperature <=", value, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureIn(List<Double> values) {
            addCriterion("asm_temperature in", values, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureNotIn(List<Double> values) {
            addCriterion("asm_temperature not in", values, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureBetween(Double value1, Double value2) {
            addCriterion("asm_temperature between", value1, value2, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andAsmTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("asm_temperature not between", value1, value2, "asmTemperature");
            return (Criteria) this;
        }

        public Criteria andPropPressureIsNull() {
            addCriterion("prop_pressure is null");
            return (Criteria) this;
        }

        public Criteria andPropPressureIsNotNull() {
            addCriterion("prop_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andPropPressureEqualTo(Double value) {
            addCriterion("prop_pressure =", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureNotEqualTo(Double value) {
            addCriterion("prop_pressure <>", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureGreaterThan(Double value) {
            addCriterion("prop_pressure >", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureGreaterThanOrEqualTo(Double value) {
            addCriterion("prop_pressure >=", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureLessThan(Double value) {
            addCriterion("prop_pressure <", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureLessThanOrEqualTo(Double value) {
            addCriterion("prop_pressure <=", value, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureIn(List<Double> values) {
            addCriterion("prop_pressure in", values, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureNotIn(List<Double> values) {
            addCriterion("prop_pressure not in", values, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureBetween(Double value1, Double value2) {
            addCriterion("prop_pressure between", value1, value2, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropPressureNotBetween(Double value1, Double value2) {
            addCriterion("prop_pressure not between", value1, value2, "propPressure");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureIsNull() {
            addCriterion("prop_temperature is null");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureIsNotNull() {
            addCriterion("prop_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureEqualTo(Double value) {
            addCriterion("prop_temperature =", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureNotEqualTo(Double value) {
            addCriterion("prop_temperature <>", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureGreaterThan(Double value) {
            addCriterion("prop_temperature >", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("prop_temperature >=", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureLessThan(Double value) {
            addCriterion("prop_temperature <", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("prop_temperature <=", value, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureIn(List<Double> values) {
            addCriterion("prop_temperature in", values, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureNotIn(List<Double> values) {
            addCriterion("prop_temperature not in", values, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureBetween(Double value1, Double value2) {
            addCriterion("prop_temperature between", value1, value2, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andPropTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("prop_temperature not between", value1, value2, "propTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureIsNull() {
            addCriterion("bear_temperature is null");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureIsNotNull() {
            addCriterion("bear_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureEqualTo(Double value) {
            addCriterion("bear_temperature =", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureNotEqualTo(Double value) {
            addCriterion("bear_temperature <>", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureGreaterThan(Double value) {
            addCriterion("bear_temperature >", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("bear_temperature >=", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureLessThan(Double value) {
            addCriterion("bear_temperature <", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("bear_temperature <=", value, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureIn(List<Double> values) {
            addCriterion("bear_temperature in", values, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureNotIn(List<Double> values) {
            addCriterion("bear_temperature not in", values, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureBetween(Double value1, Double value2) {
            addCriterion("bear_temperature between", value1, value2, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("bear_temperature not between", value1, value2, "bearTemperature");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainIsNull() {
            addCriterion("bear_bolt_strain is null");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainIsNotNull() {
            addCriterion("bear_bolt_strain is not null");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainEqualTo(Double value) {
            addCriterion("bear_bolt_strain =", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainNotEqualTo(Double value) {
            addCriterion("bear_bolt_strain <>", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainGreaterThan(Double value) {
            addCriterion("bear_bolt_strain >", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainGreaterThanOrEqualTo(Double value) {
            addCriterion("bear_bolt_strain >=", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainLessThan(Double value) {
            addCriterion("bear_bolt_strain <", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainLessThanOrEqualTo(Double value) {
            addCriterion("bear_bolt_strain <=", value, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainIn(List<Double> values) {
            addCriterion("bear_bolt_strain in", values, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainNotIn(List<Double> values) {
            addCriterion("bear_bolt_strain not in", values, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainBetween(Double value1, Double value2) {
            addCriterion("bear_bolt_strain between", value1, value2, "bearBoltStrain");
            return (Criteria) this;
        }

        public Criteria andBearBoltStrainNotBetween(Double value1, Double value2) {
            addCriterion("bear_bolt_strain not between", value1, value2, "bearBoltStrain");
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