package com.sum.eventbusdemo;

/**
 * @创建者 mingyan.su
 * @创建时间 2020/03/24 15:02
 * @类描述 {TODO}事件对象
 */
public class MessageEvent {
    public MessageEvent(String name) {
        this.name = name;
    }

    public String name;
}
