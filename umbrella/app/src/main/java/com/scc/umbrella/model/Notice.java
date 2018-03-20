package com.scc.umbrella.model;

/**
 * Created by chenjun on 18/3/11.
 */

public class Notice {
    public int type;
    public Object content;

    public Notice(int type) {
        this.type = type;
    }

    public Notice(int type, Object content) {
        this.type = type;
        this.content = content;
    }

    public Notice() {
    }
}
