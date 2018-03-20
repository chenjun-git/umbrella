package com.scc.umbrella.listener;

/**
 * Created by chenjun on 18/3/11.
 */

public interface OnChannelListener {
    void onItemMove(int starPos, int endPos);
    void onMoveToMyChannel(int starPos, int endPos);
    void onMoveToOtherChannel(int starPos, int endPos);
}
