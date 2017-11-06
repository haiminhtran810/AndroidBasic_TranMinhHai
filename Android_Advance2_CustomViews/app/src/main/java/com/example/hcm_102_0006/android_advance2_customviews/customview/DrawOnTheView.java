package com.example.hcm_102_0006.android_advance2_customviews.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hcm-102-0006 on 06/11/2017.
 */

public class DrawOnTheView extends View {

    private Paint mPaint;
    private Path mPath;

    public DrawOnTheView(Context context) {
        this(context, null);

    }

    public DrawOnTheView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public DrawOnTheView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttribute();
    }

    private void setAttribute() {
        mPaint = new Paint();
        mPath = new Path();
        // smooths out the edges of what is being drawn
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("COOR", "DOWN " + x + " - " + y);
                mPath.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d("COOR", "MOVE " + x + " - " + y);
                mPath.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                Log.d("COOR", "UP " + x + " - " + y);
                break;
            default:
                return false;
        }
        //repaint
        invalidate();
        return true;
    }

    public void deleteAll(){
        mPath.reset();
        invalidate();
    }

    public void changeColor(int colorChange){
        mPaint.setColor(colorChange);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

}
