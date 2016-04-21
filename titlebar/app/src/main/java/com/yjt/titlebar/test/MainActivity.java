package com.yjt.titlebar.test;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.yjt.titlebar.R;
import com.yjt.titlebar.widget.SwitchTV;

public class MainActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void initControl(Bundle bundle) {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
        findViewById(R.id.btn13).setOnClickListener(this);
        findViewById(R.id.btn14).setOnClickListener(this);
        findViewById(R.id.btn15).setOnClickListener(this);
        findViewById(R.id.btn16).setOnClickListener(this);
        findViewById(R.id.btn17).setOnClickListener(this);
        findViewById(R.id.btn18).setOnClickListener(this);
        findViewById(R.id.btn19).setOnClickListener(this);
        findViewById(R.id.btn20).setOnClickListener(this);
        findViewById(R.id.btn21).setOnClickListener(this);
        findViewById(R.id.btn22).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
    }

    @Override
    protected boolean hasTitleBar() {
        return true;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                //TODO implement
                titlebar.setLeftImage(R.mipmap.back_icon_normal);
                break;
            case R.id.btn2:
                titlebar.removeAllLeftView();
                break;
            case R.id.btn3:
                //TODO implement
                titlebar.setCenterText(getResources().getString(R.string.title_set));
                break;
            case R.id.btn4:
                //TODO implement
                ((TextView) titlebar.getCenterView()).setText(R.string.sure);
                break;
            case R.id.btn5:
                //TODO implement
                titlebar.removeCenterView();
                break;
            case R.id.btn6:
                //TODO implement

                titlebar.setCenterImage(R.mipmap.status_edit_history_n);
                break;
            case R.id.btn7:
                //TODO implement
                SwitchTV switchv = new SwitchTV(this);
                switchv.setSwitchClickCallback(new SwitchTV.SwitchClickCallback() {
                    @Override
                    public void callback(int p) {
                    }
                });
                switchv.downBtn.performClick();
                titlebar.setCenterView(switchv);
                break;
            case R.id.btn8:
                //TODO implement
                titlebar.setRightImage(R.mipmap.actionbar_icon_add);
                break;
            case R.id.btn9:
                titlebar.setCenterMainSubText(getResources().getString(R.string.title_leftmain),
                        getResources().getString(R.string.title_leftsub),true);
                break;
            case R.id.btn10:
                //TODO implement
                titlebar.removeAllRightView();
                break;
            case R.id.btn11:
                //TODO implement
                titlebar.setTitleBarBackColor(R.color.red);
                break;
            case R.id.btn12:
                titlebar.setRightText(getResources().getString(R.string.sure), R.color.yellow);
                //TODO implement
                break;
            case R.id.btn13:
                //TODO implement
                titlebar.setVisibility(View.GONE);
                break;
            case R.id.btn14:
                //TODO implement
                titlebar.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_clear:
                titlebar.clearViews();
                break;

            case R.id.btn15:
                //TODO implement
                titlebar.setLeftMainSubText(getResources().getString(R.string.title_leftmain)
                        , getResources().getString(R.string.title_leftsub));
                break;
            case R.id.btn16:
                //TODO implement
                titlebar.setLeftBackText(getResources().getString(R.string.title_msg));
                break;
            case R.id.btn17:
                //TODO implement
                titlebar.setRightImage(R.mipmap.actionbar_icon_add);
                break;
            case R.id.btn18:
                //TODO implement
                titlebar.setRightText(getResources().getString(R.string.abc_search_hint));
                break;
            case R.id.btn19:
                //TODO implement
                Switch aSwitch = new Switch(this);
                titlebar.setRightView(aSwitch);
                break;
            case R.id.btn20:
                titlebar.setStatusBarEnable(this);
                break;
            case R.id.btn21:
                titlebar.setStatusBarColor(this, Color.parseColor("#ff0000"));
                break;
            case R.id.btn22:
                titlebar.setStatusBarDefault();
                break;
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void left_1_click(boolean backable) {
        super.left_1_click(backable);
        Toast.makeText(this,"点击了左侧第一个按钮",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void right_1_click() {
        super.right_1_click();
        Toast.makeText(this,"点击了右侧第一个按钮",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void center_click() {
        super.center_click();
        Toast.makeText(this,"点击了中间的按钮",Toast.LENGTH_SHORT).show();
    }
}
