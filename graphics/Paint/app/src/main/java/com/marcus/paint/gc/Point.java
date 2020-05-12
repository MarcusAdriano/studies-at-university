package com.marcus.paint.gc;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Marcus
 */
public final class Point {

    public float x, y;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static float[] parse(Collection<Point> points) {
        float[] retPoints = new float[points.size() * 2];
        Iterator<Point> iterator = points.iterator();
        for (int i = 0; i < points.size() && iterator.hasNext(); i++) {
            Point p = iterator.next();
            retPoints[i * 2] = p.x;
            retPoints[i * 2 + 1] = p.y;
        }

        return retPoints;
    }
}
