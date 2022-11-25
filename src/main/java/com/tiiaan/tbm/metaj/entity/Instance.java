package com.tiiaan.tbm.metaj.entity;

import java.time.LocalDateTime;

public class Instance {
    private Long id;

    private String name;

    private String project;

    private Integer segments;

    private Long mileage;

    private Byte health;

    private Integer currentSegment;

    private Integer issues;

    private Integer unsolvedIssues;

    private Integer watching;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public Integer getSegments() {
        return segments;
    }

    public void setSegments(Integer segments) {
        this.segments = segments;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Byte getHealth() {
        return health;
    }

    public void setHealth(Byte health) {
        this.health = health;
    }

    public Integer getCurrentSegment() {
        return currentSegment;
    }

    public void setCurrentSegment(Integer currentSegment) {
        this.currentSegment = currentSegment;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }

    public Integer getUnsolvedIssues() {
        return unsolvedIssues;
    }

    public void setUnsolvedIssues(Integer unsolvedIssues) {
        this.unsolvedIssues = unsolvedIssues;
    }

    public Integer getWatching() {
        return watching;
    }

    public void setWatching(Integer watching) {
        this.watching = watching;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}