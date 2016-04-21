package com.yjt.titlebar.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.yjt.titlebar.TitleBarView;
import com.yjt.titlebar.TitlebarCallback;

/**
 * Created by yujiangtao on 16/4/18.
 */
public abstract class BaseActivity extends FragmentActivity implements
        TitlebarCallback {
    protected TitleBarView titlebar=null;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(null);
        View rootview= LayoutInflater.from(this).inflate(getLayoutID(),null);
        setContentView(rootview);

        if(hasTitleBar()){
            titlebar = new TitleBarView(this);
            titlebar.addToWindow(rootview);
            titlebar.setTitleBarCall(this);
        }

        if(bundle!=null) {
        }
        initControl(bundle);
    }

    protected abstract void initControl(Bundle savedInstanceState);
    protected abstract  boolean hasTitleBar();


    protected abstract int getLayoutID();

    @Override
    public void left_1_click(boolean backable) {

    }

    @Override
    public void left_2_click() {

    }

    @Override
    public void right_1_click() {

    }

    @Override
    public void right_2_click() {

    }

    @Override
    public void right_3_click() {

    }

    @Override
    public void center_click() {

    }
}
