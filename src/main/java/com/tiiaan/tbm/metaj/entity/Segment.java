package com.tiiaan.tbm.metaj.entity;

import java.time.LocalDateTime;

public class Segment {
    private Long id;

    private Long instanceId;

    private Integer circleSeq;

    private Double longitude;

    private Double latitude;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    private Integer propPeriod;

    private Integer asmPeriod;

    private Integer stopPeriod;

    private Integer fillingAmount;

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

    public Integer getCircleSeq() {
        return circleSeq;
    }

    public void setCircleSeq(Integer circleSeq) {
        this.circleSeq = circleSeq;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getPropPeriod() {
        return propPeriod;
    }

    public void setPropPeriod(Integer propPeriod) {
        this.propPeriod = propPeriod;
    }

    public Integer getAsmPeriod() {
        return asmPeriod;
    }

    public void setAsmPeriod(Integer asmPeriod) {
        this.asmPeriod = asmPeriod;
    }

    public Integer getStopPeriod() {
        return stopPeriod;
    }

    public void setStopPeriod(Integer stopPeriod) {
        this.stopPeriod = stopPeriod;
    }

    public Integer getFillingAmount() {
        return fillingAmount;
    }

    public void setFillingAmount(Integer fillingAmount) {
        this.fillingAmount = fillingAmount;
    }
}