package com.rainbow.heyongfeng.myapplication.ViewBean;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by HP on 2016/12/11.
 */

public class CircleBean implements ViewBeanInterface {
    public int x = 100, y = 100, r = 30;
    public Paint paint;

    public int vx = 10;//横向速度
    public int vy = 10;//纵向速度s

    public CircleBean(int x, int y, int r, int vx, int vy, Paint paint) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.paint = paint;
    }

    @Override
    public void logic(int width, int height) {
        if (x - r < 0) {
            vx = 10;
        } else if (x + r > width) {
            vx = -10;
        }
        if (y - r < 0) {
            vy = 10;
        } else if (y + r > height) {
            vy = -10;
        }
//        x+=vx;
//        y+=vy;
    }

    @Override
    public void updateUi(Canvas mCanvas, int width, int height) {
        x += vx;
        y += vy;
        mCanvas.drawCircle(x, y, r, paint);
    }

    @Override
    public boolean onKey(int width, int height, int keyCode, KeyEvent keyEvent) {
        return false;
    }
}
