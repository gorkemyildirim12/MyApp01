package com.capstone.entity;

public class Record {

    private long recordId;
    private double groundReactForce;
    private double strideTime;

    public Record() {
    }

    public Record(long recordId, double groundReactForce, double strideTime) {
        this.recordId = recordId;
        this.groundReactForce = groundReactForce;
        this.strideTime = strideTime;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public double getGroundReactForce() {
        return groundReactForce;
    }

    public void setGroundReactForce(double groundReactForce) {
        this.groundReactForce = groundReactForce;
    }

    public double getStrideTime() {
        return strideTime;
    }

    public void setStrideTime(double strideTime) {
        this.strideTime = strideTime;
    }
}
