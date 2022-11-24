package com.tiiaan.tbm.metaj.entity;

import java.time.LocalDateTime;

public class InstanceDataEntity {
    private Long id;

    private Long instanceId;

    private LocalDateTime timestamp;

    private Double mainTorque;

    private Double motorTorque;

    private Double mainForce;

    private Double biasForce;

    private Double asmPressure;

    private Double asmTemperature;

    private Double propPressure;

    private Double propTemperature;

    private Double bearTemperature;

    private Double bearBoltStrain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getMainTorque() {
        return mainTorque;
    }

    public void setMainTorque(Double mainTorque) {
        this.mainTorque = mainTorque;
    }

    public Double getMotorTorque() {
        return motorTorque;
    }

    public void setMotorTorque(Double motorTorque) {
        this.motorTorque = motorTorque;
    }

    public Double getMainForce() {
        return mainForce;
    }

    public void setMainForce(Double mainForce) {
        this.mainForce = mainForce;
    }

    public Double getBiasForce() {
        return biasForce;
    }

    public void setBiasForce(Double biasForce) {
        this.biasForce = biasForce;
    }

    public Double getAsmPressure() {
        return asmPressure;
    }

    public void setAsmPressure(Double asmPressure) {
        this.asmPressure = asmPressure;
    }

    public Double getAsmTemperature() {
        return asmTemperature;
    }

    public void setAsmTemperature(Double asmTemperature) {
        this.asmTemperature = asmTemperature;
    }

    public Double getPropPressure() {
        return propPressure;
    }

    public void setPropPressure(Double propPressure) {
        this.propPressure = propPressure;
    }

    public Double getPropTemperature() {
        return propTemperature;
    }

    public void setPropTemperature(Double propTemperature) {
        this.propTemperature = propTemperature;
    }

    public Double getBearTemperature() {
        return bearTemperature;
    }

    public void setBearTemperature(Double bearTemperature) {
        this.bearTemperature = bearTemperature;
    }

    public Double getBearBoltStrain() {
        return bearBoltStrain;
    }

    public void setBearBoltStrain(Double bearBoltStrain) {
        this.bearBoltStrain = bearBoltStrain;
    }
}