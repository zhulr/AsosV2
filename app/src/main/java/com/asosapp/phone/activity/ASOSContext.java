package com.asosapp.phone.activity;

import com.asosapp.phone.viewdata.ASOSViewModel;

/**
 * Created by ASOS_zhulr on 2016/3/11.
 */
public interface ASOSContext {
    /**
     * 根据获得的数据更新页面
     * @param Sender 由那个handler调用了该回调
     * @param view	 获得的数据模型
     */
    public void updateView(Object Sender, ASOSViewModel view);


    /**
     * 获得Activity的Tag
     * @return Tag
     */
    public String getTag();
}
