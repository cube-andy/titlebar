package com.yjt.titlebar.barentity;

import android.graphics.Color;

import com.yjt.titlebar.TitleBarConfig;

/**
 * Created by yujiangtao on 16/4/11.
 */
public class BarTextEntity extends BaseBarEntity {
    public int textColor= Color.parseColor(TitleBarConfig.DEFAULT_BARTEXT_COLOR);
    public String text;
    public boolean isbacktext=false;
}
