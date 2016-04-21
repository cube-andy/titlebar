package com.yjt.titlebar.barHelper;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.yjt.titlebar.R;
import com.yjt.titlebar.TitleBarView;
import com.yjt.titlebar.baritem.BarItem;
import com.yjt.titlebar.baritem.BarItemFactory;
import com.yjt.titlebar.barentity.BaseBarEntity;

/**
 * Created by yujiangtao on 16/3/30.
 * 负责根据原料BaseBarEntity,
 * 调度barItemFactory，得到正确的View，并添加到标题栏
 *
 */
public class TitleBarHelper {
    private Context mcontext = null;
    private TitleBarView titleBarView;
    private BarItemFactory barItemFactory=null;


    public TitleBarHelper(TitleBarView titlebar) {
        this.titleBarView = titlebar;
        this.mcontext = titlebar.getContext();
        barItemFactory = new BarItemFactory();

    }

    /**
     * 添加标题栏ITEM
     * @param item
     */
    public void addView(BaseBarEntity item){
        if(item==null)return;
        addView(getItemView(item));
    }
    public void addView(BarItem barItem){
        titleBarView.addView(barItem.getItem());
    }

    public BarItem getItemView(BaseBarEntity item){
        if(item ==null)return null;
        return barItemFactory.createBarItem(titleBarView,item);
    }

    /**
     * 获取BarView根据position和Order
     * @param bp
     * @param bo
     * @return
     */
    public View getBarView(BarPosition bp,BarOrder bo){
        switch (bp){
            case Left:
                return getLeftView(bo);
            case Center:
                return getCenterView();
            case Right:
                return getRightView(bo);
        }
        return null;
    }


    /**
     * 获取左侧View
     *
     * @param bo
     * @return
     */
    public View getLeftView(BarOrder bo) {
        int id = TitleBarIDManager.getLeftId(bo);
        if (titleBarView.findViewById(id) == null) {
            Toast.makeText(titleBarView.getContext(),
                    "none", Toast.LENGTH_SHORT).show();
            return null;
        }
        return titleBarView.findViewById(id);
    }

    /**
     * 获取右侧View
     *
     * @param bo
     * @return
     */
    public View getRightView(BarOrder bo) {
        int id = TitleBarIDManager.getRightId(bo);
        if (titleBarView.findViewById(id) == null) {
            Toast.makeText(titleBarView.getContext(),
                    "none", Toast.LENGTH_SHORT).show();
            return null;
        }
        return titleBarView.findViewById(id);
    }

    /**
     * 获取中间View
     *
     * @return
     */
    public View getCenterView() {
        int id = TitleBarIDManager.getCenterId();
        if (titleBarView.findViewById(id) == null){
            Toast.makeText(titleBarView.getContext(),
                    "none", Toast.LENGTH_SHORT).show();
            return null;
        }
        return titleBarView.findViewById(id);
    }

    public void removeView(BarPosition bp){
        switch (bp){
            case Left:
                removeView(R.id.titlebar_left_1);
                removeView(R.id.titlebar_left_2);
                break;
            case Center:
                removeView(R.id.titlebar_center);
                break;
            case Right:
                removeView(R.id.titlebar_right_1);
                removeView(R.id.titlebar_right_2);
                removeView(R.id.titlebar_right_3);
                break;
        }
    }
    public void removeView(BarPosition bp,BarOrder bo){
        int id=-1;
        switch (bp){
            case Left:
                id= TitleBarIDManager.getLeftId(bo);
                removeView(id);
                break;
            case Center:
                id=R.id.titlebar_center;
                break;
            case Right:
                id= TitleBarIDManager.getRightId(bo);
                break;
        }
        if(id==-1)return;
        removeView(id);
    }
    public void removeView(int id){
        View view = titleBarView.findViewById(id);
        if (view == null) return;
        titleBarView.removeView(view);
    }



}
