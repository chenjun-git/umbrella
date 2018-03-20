package com.scc.umbrella.model;

import java.io.Serializable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
/**
 * Created by chenjun on 18/3/17.
 */

public class Channel extends MultiItemEntity implements Serializable {
    public static final int TYPE_MY = 1;
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_MY_CHANNEL = 3;
    public static final int TYPE_OTHER_CHANNEL = 4;
    public String Title;
    public String TitleCode;
//    public int itemType;

    public Channel(String title, String titleCode) {
        this(TYPE_MY_CHANNEL, title, titleCode);
    }

    public Channel(int type, String title, String titleCode) {
        Title = title;
        TitleCode = titleCode;
        itemType = type;
    }

//    @Override
//    public int getItemType() {
//        return itemType;
//    }
}
