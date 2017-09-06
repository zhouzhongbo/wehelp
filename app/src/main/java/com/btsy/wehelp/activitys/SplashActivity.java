package com.btsy.wehelp.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.btsy.wehelp.R;

/**
 * Created by zhouzhongbo on 2017/9/1.
 */

public class SplashActivity extends Activity{
    Handler mHandler;
    String Tag = "splashActivity";
    private static final int COUNTDOWN_MSG = 1001;
    private static int CountDown = 3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        mHandler = new SplashHandler();
//        Message msg = Message.obtain();
//        msg.what = COUNTDOWN_MSG;
        mHandler.sendEmptyMessageDelayed(COUNTDOWN_MSG,1000);
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
    protected void onDestroy() {
        super.onDestroy();
    }

    public void  onClick(View view){
        int viewId = view.getId();
        switch (viewId){
            case R.id.jump_splash:
                mHandler.removeMessages(COUNTDOWN_MSG);
                goMain();
                break;

            default:
                Log.d(Tag,"unknow view id:"+viewId);
                break;
        }
    }

    class SplashHandler extends Handler{
        public SplashHandler() {
            super();
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int msgid = msg.what;
            switch(msgid){
                case COUNTDOWN_MSG:
                    CountDown--;
                    if(CountDown==0){
                        goMain();
                    }else{
                        mHandler.sendEmptyMessageDelayed(COUNTDOWN_MSG,1000);
                    }
                    break;
                default:
                    Log.d(Tag,"unkown message id:"+msgid);
                    break;
            }
        }
    }

    private void goMain(){
        Intent mintent = new Intent(this,MainActivity.class);
        mintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mintent);
        finish();
    }



}
