package com.rainbow.heyongfeng.myapplication.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by HP on 2016/12/11.
 * 屏幕刷新的线程
 */

public class MyThead extends Thread {
    private   boolean flag;
    public  Ui ui;
    public Logic logic;
    private  int refreshTime= 30;
    public MyThead( Ui ui,Logic logic) {
        this.ui=ui;
        this.logic=logic;
        flag=true;
    }

    //设置刷新时间为50毫秒

    @Override
    public void run() {
        while (flag) {
            long start = System.currentTimeMillis();
            logic.logic();
            ui.myDraw();
            long end = System.currentTimeMillis();
            try {
                long use_time = end - start;
                if (use_time < refreshTime) {
                    sleep(refreshTime - use_time);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isFlag() {
        return flag;
    }

    /**
     * 设置界面刷新时间
     * @param refreshTime
     */
    public void setRefreshTime(int refreshTime){
        this.refreshTime=refreshTime;
    }

    /**
     * 获取界面刷新时间
     * @return
     */
    public int getRefreshTime(){
        return refreshTime;
    }
    /**
     * 终止屏幕刷新，停止当前线程
     */
    public void stopThread(){
        flag=false;
    }
}
