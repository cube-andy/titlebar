package com.yjt.titlebar.statusbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.yjt.titlebar.R;
import com.yjt.titlebar.TitleBarConfig;
import com.yjt.titlebar.TitleBarView;


/**
 * Created by yujiangtao on 16/4/15.
 */
public class SystemBarUtil {

    public SystemBarTintManager tintManager=null;
    private Activity activity;

    public SystemBarUtil(Activity activity){
        this.activity = activity;
        FrameLayout rootview = (FrameLayout) activity.findViewById(android.R.id.content);
        ViewGroup viewGroup = (ViewGroup) rootview.getChildAt(0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            initSystemBar(activity);
        }
    }


    private void initSystemBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
    }

    @TargetApi(19)
    private static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public SystemBarTintManager getSystemBarTintManager(){
        return tintManager;
    }
    /**
     * 设置状态栏颜色为标题栏颜色
     */
    public void setStatusBarEnabled(){
        tintManager.setTintColor(Color.parseColor(TitleBarConfig.DEFAULT_TITLEBAR_COLOR));
    }
    /**
     * 恢复默认状态栏颜色为黑色
     */
    public void setStatusBarDefault(){
        tintManager.setTintColor(Color.parseColor("#000000"));
    }
    /**
     * 设置状态栏颜色
     * @param act
     * @param color
     */
    public void setStatusBarColor(Activity act,int color){
        tintManager.setStatusBarTintColor(color);
    }
    /**
     * 设置状态栏颜色
     * @param act
     * @param res
     */
    public void setStatusBarResource(Activity act,int res){
        tintManager.setStatusBarTintResource(res);
    }
}
