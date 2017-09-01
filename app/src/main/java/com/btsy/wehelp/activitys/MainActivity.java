package com.btsy.wehelp.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.btsy.wehelp.R;
import com.btsy.wehelp.fragment.MineFragment;
import com.btsy.wehelp.fragment.OrderFragment;
import com.btsy.wehelp.fragment.ReportFragment;
import com.btsy.wehelp.fragment.ToolsFragment;

public class MainActivity extends Activity implements BottomNavigationBar.OnTabSelectedListener{

    private String Tag="mainactivity";
    private BottomNavigationBar bottomNavigationBar;
    private BadgeItem numberBadgeItem;
    private int lastSelectedPosition = 0;

    MineFragment mineFragment;
    OrderFragment orderFragment;
    ReportFragment reportFragment;
    ToolsFragment toolsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView(){
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);

        numberBadgeItem = new BadgeItem()
                .setBorderWidth(3)
                .setBackgroundColorResource(R.color.blue)
                .setText("" + lastSelectedPosition)
                .setHideOnSelect(false);

        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
//            bottomNavigationBar
//                    .setMode(BottomNavigationBar.MODE_SHIFTING);

//            bottomNavigationBar
//                    .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.tools, R.string.tab_tool).setActiveColorResource(R.color.orange).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.report, R.string.tab_report).setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.order, R.string.tab_order).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.mine, R.string.tab_mine).setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(lastSelectedPosition > 4 ? 4 : lastSelectedPosition)
                .initialise();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        orderFragment = OrderFragment.newInstance("位置");
        transaction.replace(R.id.tabs, orderFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int i) {
        lastSelectedPosition = i;
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (i) {
            case 0:
                if (toolsFragment == null) {
                    toolsFragment = ToolsFragment.newInstance(getString(R.string.tab_tool));
                }
                transaction.replace(R.id.tabs, toolsFragment);
                break;
            case 1:
                if (reportFragment == null) {
                    reportFragment = ReportFragment.newInstance(getString(R.string.tab_report));
                }
                transaction.replace(R.id.tabs, reportFragment);
                break;

            case 2:
                if (orderFragment == null) {
                    orderFragment = OrderFragment.newInstance(getString(R.string.tab_order));
                }
                transaction.replace(R.id.tabs, orderFragment);
                break;

            case 3:
                if (mineFragment == null) {
                    mineFragment = MineFragment.newInstance(getString(R.string.tab_mine));
                }
                transaction.replace(R.id.tabs, mineFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int i) {
        Log.d(Tag,"onTabUnselected:"+i);
    }

    @Override
    public void onTabReselected(int i) {
        Log.d(Tag,"onTabReselected:"+i);
    }
}
