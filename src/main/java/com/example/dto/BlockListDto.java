package com.example.dto;

import java.util.Date;

public class BlockListDto {
    private Integer height;
    private Date time;
    private double size;
    private Integer transacation;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Integer getTransacation() {
        return transacation;
    }

    public void setTransacation(Integer transacation) {
        this.transacation = transacation;
    }
}
