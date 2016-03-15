package com.asosapp.phone.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.asosapp.phone.activity.ASOSContext;
import com.asosapp.phone.viewdata.ASOSViewModel;

/**
 * Created by ASOS_zhulr on 2016/3/11.
 * Fragment基类，共同控制待添加
 */
public class BaseFragment extends Fragment implements ASOSContext {
    protected String Tag = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tag = this.getClass().getSimpleName();
    }


    /**
     * 显示提示信息
     *
     * @param message 要显示的信息
     */
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获得FragmentManager
     *
     * @return FragmentManager
     */
    public FragmentManager getSupportFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    public String getASOSTag() {
        return Tag;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void updateView(Object Sender, ASOSViewModel view) {

    }
}
