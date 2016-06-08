package com.xinran.qxanimationsendimg;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView mIvIcon1;
    private ImageView mIvIcon2;
    private ImageView mIvIcon3;
    private ImageView mIvIcon4;
    private ImageView mIvIcon5;
    private ImageView mIvIcon6;
    private boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        setImageListener();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        setContentView(R.layout.activity_main);

        mIvIcon1 = (ImageView) findViewById(R.id.iv_icon1);
        mIvIcon2 = (ImageView) findViewById(R.id.iv_icon2);
        mIvIcon3 = (ImageView) findViewById(R.id.iv_icon3);
        mIvIcon4 = (ImageView) findViewById(R.id.iv_icon4);
        mIvIcon5 = (ImageView) findViewById(R.id.iv_icon5);
        mIvIcon6 = (ImageView) findViewById(R.id.iv_icon6);
    }

    /**
     * 添加时间监听
     */
    private void setImageListener() {
        mIvIcon1.setOnClickListener(this);
        mIvIcon2.setOnClickListener(this);
        mIvIcon3.setOnClickListener(this);
        mIvIcon4.setOnClickListener(this);
        mIvIcon5.setOnClickListener(this);
        mIvIcon6.setOnClickListener(this);
    }

    /**
     * 集中处理监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_icon1:
                Toast.makeText(this, "icon1", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv_icon2:
                Toast.makeText(this, "icon2", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv_icon3:
                Toast.makeText(this, "icon3", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv_icon4:
                Toast.makeText(this, "icon4", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv_icon5:
                Toast.makeText(this, "icon5", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv_icon6:
                //点击最外层icon，展开icon动画
                if (isShow) {
                    isShow = false;
                    showIconLineX(isShow);
                } else {
                    isShow = true;
                    showIconLineX(isShow);

                }

                break;

            default:
                break;
        }
    }

    /**
     * 直线方式延Y轴收缩
     * @param isShow
     */
    private void showIconLineY(boolean isShow) {
        int duration=500;
        float distance=20f+(mIvIcon1.getBottom()-mIvIcon1.getTop());
        PropertyValuesHolder p1, p2,  p3, p4, p5;
        if(isShow){
            p1=PropertyValuesHolder.ofFloat("TranslationY",0f,-distance);
            p2=PropertyValuesHolder.ofFloat("TranslationY",0f,-(2*distance));
            p3=PropertyValuesHolder.ofFloat("TranslationY",0f,-(3*distance));
            p4=PropertyValuesHolder.ofFloat("TranslationY",0f,-(4*distance));
            p5=PropertyValuesHolder.ofFloat("TranslationY",0f,-(5*distance));
        }else{
            p1=PropertyValuesHolder.ofFloat("TranslationY",-distance,0f);
            p2=PropertyValuesHolder.ofFloat("TranslationY",-(2*distance),0f);
            p3=PropertyValuesHolder.ofFloat("TranslationY",-(3*distance),0f);
            p4=PropertyValuesHolder.ofFloat("TranslationY",-(4*distance),0f);
            p5=PropertyValuesHolder.ofFloat("TranslationY",-(5*distance),0f);
        }

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon1, p1).setDuration(duration);
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon2, p2).setDuration(duration);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon3, p3).setDuration(duration);
        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon4, p4).setDuration(duration);
        ObjectAnimator animator5 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon5, p5).setDuration(duration);

        //添加自由落体效果插值器
        animator1.setInterpolator(new BounceInterpolator());
        animator2.setInterpolator(new BounceInterpolator());
        animator3.setInterpolator(new BounceInterpolator());
        animator4.setInterpolator(new BounceInterpolator());
        animator5.setInterpolator(new BounceInterpolator());

        //启动动画
        animator1.start();
        animator2.start();
        animator3.start();
        animator4.start();
        animator5.start();
    }
    /**
     * 直线方式延X轴收缩
     * @param isShow
     */
    private void showIconLineX(boolean isShow) {
        int duration=500;
        float distance=20f+(mIvIcon1.getBottom()-mIvIcon1.getTop());
        PropertyValuesHolder p1, p2,  p3, p4, p5;
        if(isShow){
            p1=PropertyValuesHolder.ofFloat("TranslationX",0f,distance);
            p2=PropertyValuesHolder.ofFloat("TranslationX",0f,(2*distance));
            p3=PropertyValuesHolder.ofFloat("TranslationX",0f,(3*distance));
            p4=PropertyValuesHolder.ofFloat("TranslationX",0f,(4*distance));
            p5=PropertyValuesHolder.ofFloat("TranslationX",0f,(5*distance));
        }else{
            p1=PropertyValuesHolder.ofFloat("TranslationX",distance,0f);
            p2=PropertyValuesHolder.ofFloat("TranslationX",(2*distance),0f);
            p3=PropertyValuesHolder.ofFloat("TranslationX",(3*distance),0f);
            p4=PropertyValuesHolder.ofFloat("TranslationX",(4*distance),0f);
            p5=PropertyValuesHolder.ofFloat("TranslationX",(5*distance),0f);
        }

        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon1, p1).setDuration(duration);
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon2, p2).setDuration(duration);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon3, p3).setDuration(duration);
        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon4, p4).setDuration(duration);
        ObjectAnimator animator5 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon5, p5).setDuration(duration);

        //添加自由落体效果插值器
        animator1.setInterpolator(new BounceInterpolator());
        animator2.setInterpolator(new BounceInterpolator());
        animator3.setInterpolator(new BounceInterpolator());
        animator4.setInterpolator(new BounceInterpolator());
        animator5.setInterpolator(new BounceInterpolator());

        //启动动画
        animator1.start();
        animator2.start();
        animator3.start();
        animator4.start();
        animator5.start();
    }
    /**
     * 扇形方式
     * 动画实现，因为除了沿X,Y轴的图标，另外3个都有角度，所有，要有三角函数计算
     * 使图标位移距离相等，实现扇形效果
     */
    @SuppressLint("NewApi")
    private void showIconShanXing(boolean isShow) {

        //设置动画时间
        int duration = 500;
        //动画距离,屏幕宽度的60%
        float distance = getScreenWidth() * 0.6f;
        //相邻ImageView运动角度式22.5度
        float angle1 = (float) (22.5f * Math.PI / 180);
        float angle2 = (float) (45f * Math.PI / 180);
        float angle3 = (float) (67.5f * Math.PI / 180);
        PropertyValuesHolder p1, p21, p22, p31, p32, p41, p42, p5;
        if (isShow) {
            //icon1
            p1 = PropertyValuesHolder.ofFloat("TranslationX", 0f, distance);
            //icon2
            p21 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float) (distance * Math.cos(angle1)));
            p22 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float) (distance * Math.sin(angle1)));
            //icon3
            p31 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float) (distance * Math.cos(angle2)));
            p32 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float) (distance * Math.sin(angle2)));
            //icon4
            p41 = PropertyValuesHolder.ofFloat("TranslationX", 0f, (float) (distance * Math.cos(angle3)));
            p42 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -(float) (distance * Math.sin(angle3)));
            //icon5
            p5 = PropertyValuesHolder.ofFloat("TranslationY", 0f, -distance);
        } else {
            //icon1
            p1 = PropertyValuesHolder.ofFloat("TranslationX", distance, 0f);
            //icon2
            p21 = PropertyValuesHolder.ofFloat("TranslationX", (float) (distance * Math.cos(angle1)), 0f);
            p22 = PropertyValuesHolder.ofFloat("TranslationY", -(float) (distance * Math.sin(angle1)), 0f);
            //icon3
            p31 = PropertyValuesHolder.ofFloat("TranslationX", (float) (distance * Math.cos(angle2)), 0f);
            p32 = PropertyValuesHolder.ofFloat("TranslationY", -(float) (distance * Math.sin(angle2)), 0f);
            //icon4
            p41 = PropertyValuesHolder.ofFloat("TranslationX", (float) (distance * Math.cos(angle3)), 0f);
            p42 = PropertyValuesHolder.ofFloat("TranslationY", -(float) (distance * Math.sin(angle3)), 0f);
            //icon5
            p5 = PropertyValuesHolder.ofFloat("TranslationY", -distance, 0f);
        }


        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon1, p1).setDuration(duration);
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon2, p21, p22).setDuration(duration);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon3, p31, p32).setDuration(duration);
        ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon4, p41, p42).setDuration(duration);
        ObjectAnimator animator5 = ObjectAnimator.ofPropertyValuesHolder(mIvIcon5, p5).setDuration(duration);

        //添加自由落体效果插值器
        animator1.setInterpolator(new BounceInterpolator());
        animator2.setInterpolator(new BounceInterpolator());
        animator3.setInterpolator(new BounceInterpolator());
        animator4.setInterpolator(new BounceInterpolator());
        animator5.setInterpolator(new BounceInterpolator());

        //启动动画
        animator1.start();
        animator2.start();
        animator3.start();
        animator4.start();
        animator5.start();
    }

    /**
     * 竖屏时获取屏幕宽度，横屏时，获取高度
     *
     * @return
     */
    public int getScreenWidth() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int x = outMetrics.widthPixels;
        int y = outMetrics.heightPixels;
        return x > y ? y : x;
    }
}