package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.content.Context;
import android.view.View;


public class PaintView extends View {

    public LayoutParams params;
    private Path path = new Path();
    private Paint brush = new Paint();

    public PaintView(Context context) {
        super(context);
        initPaint();

    }

    private void initPaint(){
        brush.setAntiAlias(true);
        brush.setColor(Color.CYAN);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
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

