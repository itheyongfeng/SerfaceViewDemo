package com.rainbow.heyongfeng.myapplication.ui;

import com.rainbow.heyongfeng.myapplication.ViewBean.BaffleBean;
import com.rainbow.heyongfeng.myapplication.ViewBean.CircleBean;
import com.rainbow.heyongfeng.myapplication.ViewBean.ViewBeanInterface;

import java.util.ArrayList;

/**
 *
 * @author heyongfeng
 * @date 2016/12/11
 * 逻辑执行类，负责执行页面逻辑
 */

public class Logic {
    public int width, height;
    public ArrayList<ViewBeanInterface> viewArray;

    public Logic(int width, int height, ArrayList<ViewBeanInterface> viewArray) {
        this.width = width;
        this.height = height;
        this.viewArray = viewArray;
    }

    public void logic() {
        for (ViewBeanInterface viewBeanInterface : viewArray) {
            viewBeanInterface.logic(width, height);
        }
        collision( );
    }

    /**
     * 碰撞逻辑
     * 当球CircleBean碰上BaffleBean时候，反弹
     */
    private void collision() {
        CircleBean circleBean = null;
        BaffleBean baffleBean = null;
        for (ViewBeanInterface viewBeanInterface : viewArray) {
            if (viewBeanInterface instanceof CircleBean) {
                circleBean = (CircleBean) viewBeanInterface;
            } else if (viewBeanInterface instanceof BaffleBean) {
                baffleBean = (BaffleBean) viewBeanInterface;
            }
        }
        if (
                (circleBean.x < baffleBean.left + baffleBean.thickness + circleBean.r) &&
                        (circleBean.x > baffleBean.left - circleBean.r) &&
                        (circleBean.y < baffleBean.top + baffleBean.length + circleBean.r) &&
                        (circleBean.y > baffleBean.top - circleBean.r)
        ) {
            circleBean.vx = -circleBean.vx;

        }
//        circleBean.x+=circleBean.vx;
//        circleBean.y+=circleBean.vy;
    }
}
