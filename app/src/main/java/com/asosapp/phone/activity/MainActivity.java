package com.asosapp.phone.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.asosapp.phone.R;
import com.asosapp.phone.activity.BaseActivity;
import com.asosapp.phone.activity.LoginActivity;
import com.asosapp.phone.fragment.FunctionActivity;
import com.asosapp.phone.fragment.MineFragment;
import com.asosapp.phone.fragment.NewsFragment;
import com.asosapp.phone.globaldata.GlobalUserInfo;


public class MainActivity extends BaseActivity implements OnClickListener {

    private static int BOTTOM_MENU1 = 1;
    private static int BOTTOM_MENU2 = 2;
    private static int BOTTOM_MENU3 = 3;
    private static int BOTTOM_MENU4 = 4;
    //记录当前是第几个菜单被选中
    private int currentSelectedMenu = -1;
    private View bottomMenuIcon1;
    private View bottomMenuIcon2;
    private View bottomMenuIcon3;
    private View bottomMenuIcon4;
    //保存各个菜单的fragment
    private Fragment menu1Fragment = null;
    private Fragment menu2Fragment = null;
    private Fragment menu3Fragment = null;
    private Fragment menu4Fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bottomMenuIcon1 = findViewById(R.id.bottom_menu_icon1_layout);
        bottomMenuIcon2 = findViewById(R.id.bottom_menu_icon2_layout);
        bottomMenuIcon3 = findViewById(R.id.bottom_menu_icon3_layout);
        bottomMenuIcon4 = findViewById(R.id.bottom_menu_icon4_layout);
        bottomMenuIcon1.setOnClickListener(this);
        bottomMenuIcon2.setOnClickListener(this);
        bottomMenuIcon3.setOnClickListener(this);
        bottomMenuIcon4.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_menu_icon1_layout:
                selectMenu(BOTTOM_MENU1);
                break;
            case R.id.bottom_menu_icon2_layout:
                selectMenu(BOTTOM_MENU2);
                break;
            case R.id.bottom_menu_icon3_layout:
//                if (!GlobalUserInfo.getInstance().jumpByLoginState(this
//                        , LoginActivity.NCShoppingFragment)) {
//                    return;
//                }
                selectMenu(BOTTOM_MENU3);
                break;
            case R.id.bottom_menu_icon4_layout:
                selectMenu(BOTTOM_MENU4);
                break;
            default:
                break;

        }
    }

    /**
     * 根据点击的菜单执行替换fragment的操作
     *
     * @param iconIndex 点击的菜单序号
     */
    private void selectMenu(int iconIndex) {

        if (iconIndex == currentSelectedMenu) {
            //当前就是选中的菜单，不需要改变
            return;
        }

        //如果不是点击的菜单1，关闭频道管理或者搜索页面
        if (iconIndex != BOTTOM_MENU1) {
            FragmentManager fm = getSupportFragmentManager();
            if (fm.findFragmentByTag("ORDER") != null) {
                fm.popBackStack();
            }
            if (fm.findFragmentByTag("Search") != null) {
                fm.popBackStack();
            }
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if (BOTTOM_MENU1 == iconIndex) {
            currentSelectedMenu = iconIndex;
            clearBottomMenuState();
            bottomMenuIcon1.setSelected(true);
            if (menu2Fragment != null) {
                ft.hide(menu2Fragment);
            }
            if (menu3Fragment != null) {
                ft.hide(menu3Fragment);
            }
            if (menu4Fragment != null) {
                ft.hide(menu4Fragment);
            }
            ft.show(menu1Fragment).commit();


        } else if (BOTTOM_MENU2 == iconIndex) {
            currentSelectedMenu = iconIndex;
            clearBottomMenuState();
            bottomMenuIcon2.setSelected(true);
            if (menu2Fragment == null) {
                menu2Fragment = new FunctionActivity();
                ft.add(R.id.contentLayout, menu2Fragment, "MENU2");
            }
            if (menu1Fragment != null) {
                ft.hide(menu1Fragment);
            }
            if (menu3Fragment != null) {
                ft.hide(menu3Fragment);
            }

            if (menu4Fragment != null) {
                ft.hide(menu4Fragment);
            }
            ft.show(menu2Fragment).commit();

        } else if (BOTTOM_MENU3 == iconIndex) {
            currentSelectedMenu = iconIndex;
            clearBottomMenuState();
            bottomMenuIcon3.setSelected(true);
            if (menu3Fragment == null) {
                menu3Fragment = new NewsFragment();
                ft.add(R.id.contentLayout, menu4Fragment, "MENU4");
            }
            if (menu1Fragment != null) {
                ft.hide(menu1Fragment);
            }
            if (menu2Fragment != null) {
                ft.hide(menu2Fragment);
            }
            if (menu4Fragment != null) {
                ft.hide(menu4Fragment);
            }
            ft.show(menu3Fragment).commit();
        } else if (BOTTOM_MENU4 == iconIndex) {
            currentSelectedMenu = iconIndex;
            clearBottomMenuState();
            bottomMenuIcon4.setSelected(true);
            if (menu4Fragment == null) {
                menu4Fragment = new MineFragment();
                ft.add(R.id.contentLayout, menu4Fragment, "MENU4");
            }
            if (menu1Fragment != null) {
                ft.hide(menu1Fragment);
            }
            if (menu2Fragment != null) {
                ft.hide(menu2Fragment);
            }
            if (menu3Fragment != null) {
                ft.hide(menu3Fragment);
            }
            ft.show(menu4Fragment).commit();
        }
    }

    private void clearBottomMenuState() {
        //清空所有状态
        bottomMenuIcon1.setSelected(false);
        bottomMenuIcon2.setSelected(false);
        bottomMenuIcon3.setSelected(false);
        bottomMenuIcon4.setSelected(false);
    }
}
