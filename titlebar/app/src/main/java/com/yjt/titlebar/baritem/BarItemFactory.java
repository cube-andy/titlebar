package com.yjt.titlebar.baritem;

import android.view.View;

import com.yjt.titlebar.TitleBarView;
import com.yjt.titlebar.barentity.BarCustomViewEntity;
import com.yjt.titlebar.barentity.BarImageEntity;
import com.yjt.titlebar.barentity.BarMainSubEntity;
import com.yjt.titlebar.barentity.BarTextEntity;
import com.yjt.titlebar.barentity.BaseBarEntity;
import com.yjt.titlebar.baritem.BarItem;

/**
 * Created by yujiangtao on 16/4/11.
 */
public class BarItemFactory {

    public BarItem createBarItem(TitleBarView titleBarView, BaseBarEntity barItem){
        BarItem item=null;
        switch (barItem.itemtype){
            case TTextView:
            case TBackText:
                BarTextEntity textitem= (BarTextEntity) barItem;
                item= new TextViewItem(titleBarView, textitem);
                break;
            case TImageView:
                BarImageEntity imageitem = (BarImageEntity) barItem;
                item = new ImageViewItem(titleBarView,imageitem);
                break;
            case TProgressBar:
                break;
            case TCustomView:
                BarCustomViewEntity customitem= (BarCustomViewEntity) barItem;
                item = new CustomViewItem(titleBarView,customitem);
                break;
            case TMainSubText:
                BarMainSubEntity mainSubEntity = (BarMainSubEntity) barItem;
                item = new MainSubItem(titleBarView,mainSubEntity);
                break;
        }
        return item;
    }


}
