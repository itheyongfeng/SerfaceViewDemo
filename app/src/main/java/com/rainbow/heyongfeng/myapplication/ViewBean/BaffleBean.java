package com.rainbow.heyongfeng.myapplication.ViewBean;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by HP on 2016/12/11.
 */

public class BaffleBean implements ViewBeanInterface {
    public int top = 100,//挡板距离顶部位置
            length = 100,//挡板长度
            left = 100,//挡板距离右边界距离
            thickness = 20,//挡板厚度
            v = 10;//移动速度
    public Paint paint;

    public BaffleBean(int top, int length, int left, int thickness, int v, Paint paint) {
        this.top = top;
        this.length = length;
        this.left = left;
        this.thickness = thickness;
        this.paint = paint;
    }

    public void logic(int width, int height) {

    }

    @Override
    public void updateUi(Canvas mCanvas, int width, int height) {

        mCanvas.drawRect(left, top, left + thickness, top + length, paint);

    }

    @Override
    public boolean onKey(int width, int height, int keyCode, KeyEvent keyEvent) {
        Log.d("onKey", "onKey2>>>" + keyCode);
        switch (keyCode) {
            /**
             * 按下下键时候，挡板向下移动，当挡板底部接触屏幕下边界时候停止。
             */
            case KeyEvent.KEYCODE_DPAD_DOWN:

                if (top < height - length) {
                    top = top + v;
                }
                break;
            /**
             * 按下上键时候，挡板向上移动，当挡板顶部接触屏幕下边界时候停止。
             */
            case KeyEvent.KEYCODE_DPAD_UP:
                if (top > 0) {
                    top = top - v;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                if (left < width - thickness) {
                    left = left + v;
                }
                break;
            /**
             * 按下上键时候，挡板向上移动，当挡板顶部接触屏幕下边界时候停止。
             */
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (left > 0) {
                    left = left - v;
                }
                break;
        }
        return false;
    }


}
