package com.rainbow.heyongfeng.myapplication.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.rainbow.heyongfeng.myapplication.ViewBean.ViewBeanInterface;

import java.util.ArrayList;

/**
 * Created by HP on 2016/12/11.
 * <p>
 * UI绘制类，负责绘制每个View
 */

public class Ui {
    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;
    /**
     * 画布的宽与高
     */
    private int width, height;
    ArrayList<ViewBeanInterface> viewArray;

    public Ui(SurfaceHolder mSurfaceHolder, int width, int height, ArrayList<ViewBeanInterface> viewArray) {
        this.mSurfaceHolder = mSurfaceHolder;
        this.width = width;
        this.height = height;
        this.viewArray = viewArray;
    }

    public void myDraw() {
        try {
            //使用SurfaceHolder.lockCanvas()获取SurfaceView的Canvas对象，并对画布加锁.
            mCanvas = mSurfaceHolder.lockCanvas( );
            //得到自定义大小的画布，因为局部绘制，效率更高
            //Canvas canvas = mSurfaceHolder.lockCanvas(new Rect(0,0,200,200));

            if (mCanvas != null) {
                /**
                 * 在绘制之前需要将画布清空，否则画布上会显示之前绘制的内容,以下三种方法效果一致*/
                mCanvas.drawRect(0, 0, width, height, new Paint( ));
                mCanvas.drawColor(Color.WHITE);
                mCanvas.drawRGB(255, 255, 255);

                //通过在Canvas上绘制内容来修改SurfaceView中的数据
                for (ViewBeanInterface viewBeanInterface : viewArray) {
                    viewBeanInterface.updateUi(mCanvas, width, height);
                }
                updateUi( );
            }
        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            if (mSurfaceHolder != null) {
                //用于解锁画布和提交
                try {
                    mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace( );
                }
            }
        }
    }

    public ArrayList<ViewBeanInterface> getViewArray() {
        return viewArray;
    }

    public void setViewArray(ArrayList<ViewBeanInterface> viewArray) {
        this.viewArray = viewArray;
    }

    /**
     * 更新总体UI
     */
    public void updateUi() {

    }

}
