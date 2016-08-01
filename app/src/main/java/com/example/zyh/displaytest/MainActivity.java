package com.example.zyh.displaytest;

import android.content.Context;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        public   Context context=MainActivity.this;
    public  LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除标题栏

        WindowManager windowManager=(WindowManager) getSystemService(WINDOW_SERVICE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN); //去除状态栏

        setContentView(R.layout.activity_main);
        linearLayout =(LinearLayout)findViewById(R.id.linearLayout);

        Display display=windowManager.getDefaultDisplay();//获取这个Display对象，存储着屏幕的宽高
        /*
        　这是一个DisplayMetrics对象
        　先实例化对象DisplayMetrics
        　在使用display.getMetrics()方法获得
        　存储着宽高信息和屏幕密度


         */
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);
        int x=metrics.widthPixels;
        int y=metrics.heightPixels;
        float dpi=metrics.densityDpi;

        /*
        动态加载的方式一
        实例化对象TextView
        先生成一个对象LineLayout.LayoutParams
        在设置给对象TextView
        最后放入

         */
        TextView textView=new TextView(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        textView.setText(x+"　");
        textView.append(y+"　"+"\n ");
        textView.append(dpi+"　"+"\n");

        LayoutInflater layoutInflater=getLayoutInflater();//

        /*
        动态加载对象的方式二
        先用对象从文件加载出实例TextView
        然后获取布局参数
        修改布局参数
        放入对象


         */
        TextView view2=(TextView) layoutInflater.inflate(R.layout.textview,linearLayout,false);
       LinearLayout.LayoutParams params2=(LinearLayout.LayoutParams) view2.getLayoutParams();
        params2.height=LinearLayout.LayoutParams.WRAP_CONTENT;
        params2.width=LinearLayout.LayoutParams.WRAP_CONTENT;
        linearLayout.addView(view2);
        view2.setBackgroundColor(Color.BLUE);

        int height=display.getHeight();
        int width=display.getWidth();

        view2.setText(height+"\n");
        view2.append(width+"\n");




    }
}
