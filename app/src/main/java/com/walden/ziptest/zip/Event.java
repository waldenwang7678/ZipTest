package com.walden.ziptest.zip;

/**
 * Created by walden on 2017/8/14.
 * 一个任务事件
 */

public class Event<T> {

    private EventCallBack<T> callBack;

    public static <T> Event create(EventCallBack<T> eventCallBack) {
        return new Event<>(eventCallBack);
    }

    private Event(EventCallBack<T> eventCallBack) {
        callBack = eventCallBack;
    }

    EventCallBack getCallBack() {
        return callBack;
    }

    public interface EventCallBack<T> {
        void dosomething(PostData<T> postData);
    }


    public interface PostData<T> {
        void post(T t);
    }
}
