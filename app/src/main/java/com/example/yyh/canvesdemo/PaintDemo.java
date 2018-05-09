package com.example.yyh.canvesdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuhong.yang on 2018/3/5.
 */

public class PaintDemo extends View {

    private Paint paint;


    public PaintDemo(Context context) {
        super(context);
    }

    public PaintDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PaintDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10f);
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }



}
