package com.walden.ziptest.zip;

/**
 * Created by walden on 2017/8/14.
 * 事件执行完毕后的回调接口
 */

public interface CallBack<T1, T2, T3> {
    void getEventResult(T1 t1, T2 t2, T3 t3);

}
