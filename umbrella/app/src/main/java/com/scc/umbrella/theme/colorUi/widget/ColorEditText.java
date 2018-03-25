package com.scc.umbrella.theme.colorUi.widget;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.scc.umbrella.theme.colorUi.ColorUiInterface;
import com.scc.umbrella.theme.colorUi.util.ViewAttributeUtil;
/**
 * Created by chenjun on 18/3/25.
 */

public class ColorEditText extends AppCompatTextView implements ColorUiInterface {

    private int attr_background = -1;
    private int attr_textApperance = -1;

    public ColorEditText(Context context) {
        super(context);
    }

    public ColorEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textApperance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
    }

    public ColorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textApperance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if(attr_background != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_background);
        }
        if(attr_textApperance != -1) {
            ViewAttributeUtil.applyTextAppearance(this, themeId, attr_textApperance);
        }
    }
}