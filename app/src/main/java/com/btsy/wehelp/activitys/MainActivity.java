package com.btsy.wehelp.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.btsy.wehelp.R;
import com.btsy.wehelp.fragment.MineFragment;
import com.btsy.wehelp.fragment.SellsFragment;
import com.btsy.wehelp.fragment.ReportFragment;
import com.btsy.wehelp.fragment.ToolsFragment;

public class MainActivity extends Activity implements BottomNavigationBar.OnTabSelectedListener{

    private String Tag="mainactivity";
    private BottomNavigationBar bottomNavigationBar;
    private BadgeItem numberBadgeItem;
    private int lastSelectedPosition = 2;

    MineFragment mineFragment;
    SellsFragment orderFragment;
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
                .addItem(new BottomNavigationItem(R.drawable.tab_tools, R.string.tab_tool).setActiveColorResource(R.color.orange).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.tab_report, R.string.tab_report).setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.tab_order, R.string.tab_order).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.tab_mine, R.string.tab_mine).setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(lastSelectedPosition > 4 ? 4 : lastSelectedPosition)
                .initialise();
        setDefaultFragment();

    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        orderFragment = SellsFragment.newInstance("位置");
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
                    orderFragment = SellsFragment.newInstance(getString(R.string.tab_order));
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("zzb","11resultcode ="+resultCode+";resultCode="+resultCode+"!");
    }
}
