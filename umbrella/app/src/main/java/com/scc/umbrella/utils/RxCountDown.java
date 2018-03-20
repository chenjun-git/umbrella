package com.scc.umbrella.utils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by chenjun on 18/3/12.
 */

public class RxCountDown {
    public static Observable<Integer> countDown(int time)
    {
        if(time<0) time=0;
        final int countTime = time;
        return Observable.interval(0,1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long aLong) {
                        return countTime-aLong.intValue();
                    }
                }).take(time+1);
    }
}
