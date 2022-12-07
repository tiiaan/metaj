package com.tiiaan.tbm.metaj.common;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public enum ProgressEnum {

    PUBLISH("报告发布成功"),
    SOLVED("故障解除"),
    CLOSED("报告被负责人关闭");

    private String content;

    ProgressEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
