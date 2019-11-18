package com.app.loadingbutton;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zhuoCreator.loadingbutton.LoadingButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LoadingButton mLoadingButton;
    private Handler  handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLoadingButton = (LoadingButton) findViewById(R.id.loadingButton);
        mLoadingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loadingButton){
            toast("正在加载中，不可点击");
            mLoadingButton.startLoading();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoadingButton.stopLoading();
                    toast("加载完成，可以点击");
                }
            },3000);
        }
    }

    public void toast(CharSequence msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
}
