package com.asosapp.phone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ASOS_zhulr on 2016/3/11.
 * 救援页面
 */
public class RescueFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "RescueFragment";
    private LayoutInflater mInflate;
    private View View;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflate = inflater;

        return View;
    }

    @Override
    public void onClick(View v) {

    }
}
