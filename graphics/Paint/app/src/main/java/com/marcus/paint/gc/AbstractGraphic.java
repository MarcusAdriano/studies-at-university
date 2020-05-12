package com.marcus.paint.gc;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author Marcus
 */
public abstract class AbstractGraphic {

    protected Point p1, p2;
    protected Paint mPaint;
    protected boolean invalidated = true;

    public AbstractGraphic() {
        init();
    }

    public AbstractGraphic(Point p1, Point p2) {
        init();
        this.p1 = p1;
        this.p2 = p2;
    }

    public AbstractGraphic(Point p1, Point p2, Paint mPaint) {
        init();
        this.p1 = p1;
        this.p2 = p2;
        this.mPaint = mPaint;
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setStrokeWidth(5);
        this.mPaint.setColor(Color.BLACK);
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        this.invalidated = true;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        this.invalidated = true;
    }

    public void setPoints(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.invalidated = true;
    }

    protected void setPaint(Paint p) {
        this.mPaint = p;
    }

    public abstract void draw(Canvas canvas);

    public enum Type {
        CIRCLE,
        RECTANGLE,
        LINE,
        POLYLINE,
        CURVE,
        SQUARE
    }
}
