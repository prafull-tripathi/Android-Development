package com.example.calenderproject;

public class Alarm {
    private int hrs;
    private int mins;
    private String msg;

    public Alarm(int hrs, int mins, String msg) {
        this.hrs = hrs;
        this.mins = mins;
        this.msg = msg;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "hrs=" + hrs +
                ", mins=" + mins +
                ", msg='" + msg + '\'' +
                '}';
    }
}
