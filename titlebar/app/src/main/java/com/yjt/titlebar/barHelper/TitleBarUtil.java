package com.yjt.titlebar.barHelper;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.yjt.titlebar.TitleBarConfig;
import com.yjt.titlebar.TitleBarView;

/**
 * Created by yujiangtao on 16/4/11.
 */
public class TitleBarUtil {

    public static ColorDrawable pressedDrawable =
            new ColorDrawable(Color.parseColor(TitleBarConfig.DEFAULT_PRESSED_COLOR));
    public static ColorDrawable nomalDrawable =
            new ColorDrawable(Color.parseColor(TitleBarConfig.DEFAULT_NORMAL_COLOR));
    public static ColorDrawable focusedDrawable =
            new ColorDrawable(Color.parseColor(TitleBarConfig.DEFAULT_FOCUSED_COLOR));

    /**
     * 获取标题栏按钮的背景图片列表
     *
     * @return StateListDrawable
     */
    public static StateListDrawable getDrawableSelector() {
        //当XML的设定是false时，就需要使用资源符号的负值来设定。
        StateListDrawable drawable = new StateListDrawable();
        // View.PRESSED_ENABLED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        // View.ENABLED_SELECTED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_selected}, focusedDrawable);
        // View.ENABLED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_enabled}, nomalDrawable);
        // View.FOCUSED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_focused}, focusedDrawable);

        drawable.addState(new int[]{}, nomalDrawable);

        return drawable;

    }

    /**
     * 获取标题栏按钮的背景颜色列表
     *
     * @return ColorStateList
     */

    public static ColorStateList getColorSelector() {
        int[] colors = new int[]{Color.parseColor(TitleBarConfig.DEFAULT_PRESSED_COLOR),
                Color.parseColor(TitleBarConfig.DEFAULT_FOCUSED_COLOR),
                Color.parseColor(TitleBarConfig.DEFAULT_FOCUSED_COLOR),
                Color.parseColor(TitleBarConfig.DEFAULT_NORMAL_COLOR)};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_selected};
        states[3] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public static void setVisibility(View rootview,TitleBarView titlebar, int visible) {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                TitleBarConfig.DEFAULT_TITLEBAR_HEIGHT,
                titlebar.getContext().getResources().getDisplayMetrics());
        if(visible==View.GONE) {
            setMagin(rootview,0);
            titlebar.setVisibility(View.GONE);
        }else{
            setMagin(rootview,height);
            titlebar.setVisibility(View.VISIBLE);
        }

    }

    public static void addTitleBarView(TitleBarView titlebar, Activity act) {
        FrameLayout frameLayout = (FrameLayout) act.findViewById(android.R.id.content);
        View view = frameLayout.getChildAt(0);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                TitleBarConfig.DEFAULT_TITLEBAR_HEIGHT,
                titlebar.getContext().getResources().getDisplayMetrics());
        lp.setMargins(0, height, 0, 0);
        frameLayout.addView(titlebar, 0);
    }

    public static void addTitleBarView(TitleBarView titlebar, View rootView) {
        if (rootView instanceof LinearLayout) {
            ((LinearLayout) rootView).addView(titlebar, 0);
        } else {
            ((ViewGroup) rootView).addView(titlebar, 0);
            if (((ViewGroup) rootView).getChildCount() > 1) {
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        TitleBarConfig.DEFAULT_TITLEBAR_HEIGHT,
                        titlebar.getContext().getResources().getDisplayMetrics());
                setMagin(rootView,height);
            }
        }
    }

    private static void  setMagin(View rootView,int height){
        View childview = (View) ((ViewGroup) rootView).getChildAt(1);
        if (childview.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)
                    childview.getLayoutParams();
            lp.setMargins(0, height, 0, 0);
        } else if (childview.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)
                    childview.getLayoutParams();
            lp.setMargins(0, height, 0, 0);
        } else if (childview.getLayoutParams() instanceof ScrollView.LayoutParams) {
            ScrollView.LayoutParams lp = (ScrollView.LayoutParams)
                    childview.getLayoutParams();
            lp.setMargins(0, height, 0, 0);
        }
    }
}
