package com.marcus.paint.gc;

import android.graphics.Canvas;

import java.util.LinkedList;

/**
 * @author Marcus
 */
public class Line extends AbstractGraphic {

    private float[] currPoints;
    private LinkedList<Point> mPoints = new LinkedList<>();

    public Line(Point p1, Point p2) {
        super(p1, p2);
    }

    public Line() {
        super();
    }

    @Deprecated
    private void bresenham() {
        float dx = p2.x - p1.x;
        float dy = p2.y - p1.y;
        float dy2 = 2 * dy;
        float dydx2 = dy2 - 2 * dx;
        float pant = dy2 - dx;
        float x = p1.x, y = p1.y;

        for (int i = 0; i < dx; i++) {
            if (pant < 0) {
                mPoints.add(new Point(x + 1, y));
                pant = pant + dy2;
            } else {
                mPoints.add(new Point(x + 1, y + 1));
                pant = pant + dydx2;
                y += 1;
            }
            x += 1;
        }
    }

    private void bresenhamV2() {
        float d = 0;

        p1.x = (float) Math.rint(p1.x);
        p2.x = (float) Math.rint(p2.x);
        p1.y = (float) Math.rint(p1.y);
        p2.y = (float) Math.rint(p2.y);

        float dx = Math.abs(p2.x - p1.x);
        float dy = Math.abs(p2.y - p1.y);

        float dx2 = 2 * dx; // slope scaling factors to
        float dy2 = 2 * dy; // avoid floating point

        int ix = p1.x < p2.x ? 1 : -1; // increment direction
        int iy = p1.y < p2.y ? 1 : -1;

        float x = p1.x;
        float y = p1.y;

        if (dx >= dy) {
            while (true) {
                mPoints.add(new Point(x, y));
                if (x == p2.x)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                mPoints.add(new Point(x, y));
                if (y == p2.y)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (invalidated) {
            bresenhamV2();
            currPoints = Point.parse(this.mPoints);

            invalidated = false;
            this.mPoints.clear();
        }

        canvas.drawPoints(currPoints, this.mPaint);
    }
}
