package com.scc.umbrella.base;

/**
 * Created by chenjun on 18/3/12.
 */

public class ResultResponse<T> {
    public String has_more;
    public String message;
    public String success;
    public T data;

    public ResultResponse(String more, String _message, T result) {
        has_more = more;
        message = _message;
        data = result;
    }
}
