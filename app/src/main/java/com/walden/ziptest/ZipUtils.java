package com.walden.ziptest;

import android.view.SurfaceHolder;

/**
 * Created by walden on 2017/8/14.
 */

public class ZipUtils {


    public static <T1, T2, T3, R> void Zip(Event<? extends T1> event1,
                                           Event<? extends T2> event2,
                                           Event<? extends T3> event3,
                                           final CallBack<? super T1, ? super T2, ? super T3> callBack) {

        final boolean[] t = new boolean[]{false, false, false};
        final Object[] o = new Object[3];
        event1.getCallBack().dosomething(new Event.PostData<T1>() {

            @Override
            public void post(T1 t1) {
                t[0] = true;
                o[0] = t1;
                if (isAllTrue(t)) {
                    callBack.getEventResult((T1) o[0], (T2) o[1], (T3) o[2]);
                }
            }
        });

        event2.getCallBack().dosomething(new Event.PostData<T2>() {


            @Override
            public void post(T2 t2) {
                t[1] = true;
                o[1] = t2;
                if (isAllTrue(t)) {
                    callBack.getEventResult((T1) o[0], (T2) o[1], (T3) o[2]);
                }
            }
        });
        event3.getCallBack().dosomething(new Event.PostData<T3>() {

            @Override
            public void post(T3 t3) {
                t[2] = true;
                o[2] = t3;
                if (isAllTrue(t)) {
                    callBack.getEventResult((T1) o[0], (T2) o[1], (T3) o[2]);
                }
            }
        });
    }


    private static boolean isAllTrue(boolean[] b) {
        if (b != null && b.length > 0) {
            int len = b.length;
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                flag = flag && b[i];
            }
            return flag;
        }
        return false;
    }
}
