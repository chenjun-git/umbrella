package com.scc.umbrella.model;

import java.io.Serializable;

/**
 * Created by chenjun on 18/3/11.
 */

public class Title implements Serializable {
    public String TitleStr;
    public String TitleCode;

    public Title(String titleStr, String titleCode) {
        TitleStr = titleStr;
        TitleCode = titleCode;
    }
}
