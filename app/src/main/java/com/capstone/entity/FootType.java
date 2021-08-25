package com.capstone.entity;

public class FootType {

    private long footTypeId;
    private Record leftFoot;
    private Record rightFoot;

    public FootType() {
    }

    public FootType(long footTypeId, Record leftFoot, Record rightFoot) {

        this.footTypeId = footTypeId;
        this.leftFoot = leftFoot;
        this.rightFoot = rightFoot;
    }

    public long getFootTypeId() {
        return footTypeId;
    }

    public void setFootTypeId(long footTypeId) {
        this.footTypeId = footTypeId;
    }

    public Record getLeftFoot() {
        return leftFoot;
    }

    public void setLeftFoot(Record leftFoot) {
        this.leftFoot = leftFoot;
    }

    public Record getRightFoot() {
        return rightFoot;
    }

    public void setRightFoot(Record rightFoot) {
        this.rightFoot = rightFoot;
    }
}
