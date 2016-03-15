package com.asosapp.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;
import com.asosapp.phone.viewdata.ASOSViewModel;

import java.util.List;

/**
 * Created by ASOS_zhulr on 2016/3/11.
 * Activity 的基类，所有Activity应继承该类， 基类中已经包含了Activity的控制，由ActivityCollector实现，
 */
public class BaseActivity extends FragmentActivity implements ASOSContext {
    protected String Tag = "GTBaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 要全屏,去掉下面的注释
        // requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 添加入Activity收集器
        ActivityCollector.add(this);
        Tag = this.getClass().getSimpleName();
    }

    protected void showToast(String val) {
        Toast.makeText(this, val, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从Activity收集器删除
        ActivityCollector.remove(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void updateView(Object Sender, ASOSViewModel view) {

    }

    @Override
    public String getTag() {
        return Tag;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager fm = getSupportFragmentManager();
        int index = requestCode >> 16;
        if (index != 0) {
            index--;
            if (fm.getFragments() == null || index < 0
                    || index >= fm.getFragments().size()) {
                Log.w(Tag, "Activity result fragment index out of range: 0x"
                        + Integer.toHexString(requestCode));
                return;
            }
            List<Fragment> frags = fm.getFragments();
            if (frags != null) {
                for (Fragment f : frags) {
                    if (f != null)
                        handleResult(f, requestCode, resultCode, data);
                }
            }
           /* Fragment frag = fm.getFragments().get(index);
            if (frag == null) {
                Log.w(Tag, "Activity result no fragment exists for index: 0x"
                        + Integer.toHexString(requestCode));
            } else {
                handleResult(frag, requestCode, resultCode, data);
            }*/
            return;
        }

    }

    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }
}
