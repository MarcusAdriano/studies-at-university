package com.marcus.paint.gc;

import android.graphics.Canvas;

/**
 * @author Marcs
 */
public class Rectangle extends AbstractGraphic {

    private Line l1 = new Line(), l2 = new Line(), l3 = new Line(), l4 = new Line();
    private Point p3 = new Point(), p4 = new Point();

    public Rectangle() {
        super();
    }

    public Rectangle(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public void draw(Canvas canvas) {
        if (invalidated) {
            p3.y = p1.y;
            p3.x = p2.x;

            p4.x = p1.x;
            p4.y = p2.y;

            l1.setPoints(p1, p3);
            l2.setPoints(p1, p4);
            l3.setPoints(p2, p3);
            l4.setPoints(p2, p4);

            l1.setPaint(this.mPaint);
            l2.setPaint(this.mPaint);
            l3.setPaint(this.mPaint);
            l4.setPaint(this.mPaint);

            invalidated = false;
        }

        l1.draw(canvas);
        l2.draw(canvas);
        l3.draw(canvas);
        l4.draw(canvas);
    }
}
