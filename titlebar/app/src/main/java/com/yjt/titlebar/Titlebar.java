package com.yjt.titlebar;

import android.app.Activity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by yujiangtao on 16/4/19.
 */
public class Titlebar {



    public static void addTitleBarView(TitleBarView titlebar,Activity act){
        FrameLayout frameLayout = (FrameLayout) act.findViewById(android.R.id.content);
        View view = frameLayout.getChildAt(0);
        FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams) view.getLayoutParams();
        int height= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                TitleBarConfig.DEFAULT_TITLEBAR_HEIGHT,
                titlebar.getContext().getResources().getDisplayMetrics());
        lp.setMargins(0,height,0,0);
        frameLayout.addView(titlebar,0);
    }

    public static void addTitleBarView(TitleBarView titlebar,View rootView){
        if(rootView instanceof LinearLayout){
            ((LinearLayout)rootView).addView(titlebar,0);
        }else{
            ((ViewGroup)rootView).addView(titlebar,0);
            if(((ViewGroup)rootView).getChildCount()>1){

                View childview = (View) ((ViewGroup) rootView).getChildAt(1);
                int height= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        TitleBarConfig.DEFAULT_TITLEBAR_HEIGHT,
                        titlebar.getContext().getResources().getDisplayMetrics());
                if(childview.getLayoutParams() instanceof FrameLayout.LayoutParams){
                        FrameLayout.LayoutParams lp= (FrameLayout.LayoutParams)
                                childview.getLayoutParams();
                        lp.setMargins(0,height,0,0);
                }else if(childview.getLayoutParams() instanceof RelativeLayout.LayoutParams){
                        RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams)
                                        childview.getLayoutParams();
                        lp.setMargins(0,height,0,0);
                }else if(childview.getLayoutParams() instanceof ScrollView.LayoutParams){
                    ScrollView.LayoutParams lp= (ScrollView.LayoutParams)
                                    childview.getLayoutParams();
                    lp.setMargins(0,height,0,0);
                }
            }

        }

    }
}
