package com.rainbow.heyongfeng.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;

import com.rainbow.heyongfeng.myapplication.ViewBean.BaffleBean;
import com.rainbow.heyongfeng.myapplication.ViewBean.CircleBean;
import com.rainbow.heyongfeng.myapplication.ViewBean.ViewBeanInterface;
import com.rainbow.heyongfeng.myapplication.ui.Logic;
import com.rainbow.heyongfeng.myapplication.ui.MyCallback;
import com.rainbow.heyongfeng.myapplication.ui.MyGameView;
import com.rainbow.heyongfeng.myapplication.ui.MyThead;
import com.rainbow.heyongfeng.myapplication.ui.Ui;

import java.util.ArrayList;

/**
 * @author liuping
 */
public class MainActivity extends Activity {
    MyThead myThead;
    MyGameView myGameView;
    int width, height;
    ArrayList<ViewBeanInterface> viewArray = new ArrayList<>( );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        myGameView = new MyGameView(this);
        setContentView(myGameView);
        init();
    }

    public void init() {
        //myGameView.requestFocus();
        getWidth( );
        SurfaceHolder mSHolder = myGameView.getHolder( );

        Paint circlePain = new Paint( );
        circlePain.setColor(Color.RED);
        Paint bafflePain = new Paint( );
        bafflePain.setColor(Color.RED);
        CircleBean circleBean = new CircleBean(100, 100, 50, 10, 10, circlePain);
        BaffleBean baffleBean = new BaffleBean(100, 300, 600, 20, 10, bafflePain);
        viewArray.add(circleBean);
        viewArray.add(baffleBean);

        Ui ui = new Ui(mSHolder, width, height, viewArray);
        Logic logic = new Logic(width, height, viewArray);


        myThead = new MyThead(ui, logic);
        MyCallback myCallback = new MyCallback(width, height, myThead, viewArray);

        myGameView.setOnKeyListener(myCallback);
        myGameView.setOnTouchListener(myCallback);
        mSHolder.addCallback(myCallback);
    }

    public void getWidth() {
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay( ).getWidth( );
        height = wm.getDefaultDisplay( ).getHeight( );
    }

}
