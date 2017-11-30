package com.rainbow.heyongfeng.myapplication.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by HP on 2016/12/11.
 */

public class MyGameView extends SurfaceView  {

    public MyGameView(Context context) {
        super(context);
    }

    public MyGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("onKey","onKeyDownkeyCode>>>"+keyCode);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d("onKey","onKeyUpkeyCode>>>"+keyCode);
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        Log.d("onKey","setOnKeyListener>>>");
        super.setOnKeyListener(l);
    }

//    public MyGameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
}
