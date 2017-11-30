package com.rainbow.heyongfeng.myapplication.ui;

import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;

import com.rainbow.heyongfeng.myapplication.ViewBean.ViewBeanInterface;

import java.util.ArrayList;

/**
 * Created by HP on 2016/12/11.
 */

public class MyCallback implements Callback ,View.OnKeyListener,View.OnTouchListener, GestureDetector.OnGestureListener {
   private MyThead myThead;
  private   ArrayList<ViewBeanInterface> viewArray;
    private
    GestureDetector detector = new GestureDetector(this);
    int width,  height;
    public MyCallback(int width, int height, MyThead myThead, ArrayList<ViewBeanInterface> viewArray) {
        this.width=width;
        this.height=height;
        this.myThead = myThead;
        this.viewArray=viewArray;
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        myThead.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        myThead.stopThread();
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Log.d("onKey","KEYCODE_DPAD_DOWN>>>"+KeyEvent.KEYCODE_DPAD_DOWN);
        Log.d("onKey","KEYCODE_DPAD_UP>>>"+KeyEvent.KEYCODE_DPAD_UP);
        Log.d("onKey","onKey>>>"+keyCode);
        for (ViewBeanInterface viewBeanInterface :viewArray) {
            viewBeanInterface.onKey(width,height,keyCode,event);
        }
        return true;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
         int code= motionEvent.getAction();
        System.out.println("onTouch"+code+",getWidth:"+view.getWidth()+",getHeight:"+view.getHeight());
        detector.onTouchEvent(motionEvent);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
        int keyCode=KeyEvent.KEYCODE_DPAD_DOWN;
        if(velocityY < 0){keyCode=KeyEvent.KEYCODE_DPAD_DOWN;
        }else if(velocityY > 0){
            keyCode=KeyEvent.KEYCODE_DPAD_UP;
        }else if(velocityX>0){
            keyCode=KeyEvent.KEYCODE_DPAD_LEFT;
        }else if(velocityX<0){
            keyCode=KeyEvent.KEYCODE_DPAD_RIGHT;
        }
        for (ViewBeanInterface viewBeanInterface :viewArray) {
            viewBeanInterface.onKey(width,height,keyCode,null);
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
        return false;
    }
}
