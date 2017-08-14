package com.walden.ziptest;

import java.util.Objects;

/**
 * Created by walden on 2017/8/14.
 */

public class Event<T> {

    EventCallBack<T> callBack;

    static <T> Event create(EventCallBack<T> eventCallBack) {
        return new Event<>(eventCallBack);
    }

    private Event(EventCallBack<T> eventCallBack) {
        callBack = eventCallBack;
    }

    EventCallBack getCallBack() {
        return callBack;
    }

    interface EventCallBack<T> {
        void dosomething(PostData<T> postData);
    }


    interface PostData<T> {
        void post(T t);
    }
}
