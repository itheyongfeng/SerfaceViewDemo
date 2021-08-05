package com.rainbow.heyongfeng.myapplication.ViewBean;

import android.graphics.Canvas;
import android.view.KeyEvent;

/**
 *
 * @author HeYongFeng
 * @date 2016/12/11
 */

public interface ViewBeanInterface {

    /**
     * 每个View的自有逻辑
     *
     * @param width
     * @param height
     */
    void logic(int width, int height);

    /**
     * 每个View的自由UI绘制
     *
     * @param mCanvas
     * @param width
     * @param height
     */
    void updateUi(Canvas mCanvas, int width, int height);

    /**
     * 每个View的键盘响应事件
     *
     * @param width
     * @param height
     * @param keyCode
     * @param keyEvent
     * @return
     */
    boolean onKey(int width, int height, int keyCode, KeyEvent keyEvent);
}
