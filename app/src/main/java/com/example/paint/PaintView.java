package com.example.paint;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.content.Context;
import android.view.View;


public class PaintView extends View {

    static LayoutParams params;
    static Paint brush = new Paint();
    static Path path = new Path();



    public PaintView(Context context) {
        super(context);
        initPaint();

    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }



    private void initPaint(){
        brush.setAntiAlias(true);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    public void changeColor(){
        brush.setColor(Color.RED);
    }

    @SuppressLint("ResourceAsColor")
    public void erase(){
        brush.setColor( R.color.white);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);// updates the path initial point
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);// makes a line to the point each time this event is fired
                break;


            default:
                return false;
        }

        // Schedules a repaint.
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, brush);// draws the path with the paint
    }
}

