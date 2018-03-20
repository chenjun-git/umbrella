package com.scc.umbrella.view;

import java.util.List;
import com.scc.umbrella.model.News;

/**
 * Created by chenjun on 18/3/17.
 */

public interface INewsListView {

    void onGetNewsListSuccess(List<News> response);

    void onError();
}
