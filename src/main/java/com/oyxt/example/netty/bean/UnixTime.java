package com.oyxt.example.netty.bean;

import java.util.Date;

/**
 * @author 20190712713
 * @date 2019/12/19 17:21
 */
public class UnixTime {
    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((getValue() - 2208988800L) * 1000L).toString();
    }
}
