package com.yjt.titlebar.baritem;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.RelativeLayout;

import com.yjt.titlebar.barHelper.BarPosition;
import com.yjt.titlebar.barHelper.BarType;
import com.yjt.titlebar.TitleBarConfig;
import com.yjt.titlebar.TitleBarView;
import com.yjt.titlebar.barentity.BarMainSubEntity;

/**
 * Created by yujiangtao on 16/4/13.
 */
public class MainSubItem extends TextViewItem {
    private BarMainSubEntity entity;
    int maintextsize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            TitleBarConfig.DEFAULT_TEXTSIZE_TITLE_MAIN,
            mcontext.getResources().getDisplayMetrics());
    int subtextsize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            TitleBarConfig.DEFAULT_TEXTSIZE_TITLE_SUB,
            mcontext.getResources().getDisplayMetrics());

    public MainSubItem(TitleBarView titleBarView, BarMainSubEntity textbean) {
        super(titleBarView, textbean);
        barType = BarType.TMainSubText;
        entity = textbean;
    }



    @Override
    protected void initTextView(BarPosition bp) {
        if(bp==BarPosition.Left) textView.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
        AbsoluteSizeSpan mainspan = new AbsoluteSizeSpan(maintextsize);
        AbsoluteSizeSpan subspan = new AbsoluteSizeSpan(subtextsize);
        String text = entity.maintitletext+"\n"+entity.subtitletext;
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(mainspan, 0, entity.maintitletext.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //0.5f表示默认字体大小的一半
        spannableString.setSpan(subspan,entity.maintitletext.length()+1 ,
                text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //0.5f表示默认字体大小的一半
        textView.setText(spannableString);
        textView.setLineSpacing(0f,1.2f);
    }
}
