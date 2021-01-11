package com.eneskoc.eventbusexample;

public class ActivityToFragmentEvent {

    private String msg;
    public ActivityToFragmentEvent(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
