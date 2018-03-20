package com.scc.umbrella.base;

/**
 * Created by chenjun on 18/3/12.
 */

public interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
