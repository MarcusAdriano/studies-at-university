package com.marcus.paint.gc;

import android.graphics.Canvas;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Circle extends AbstractGraphic {

    private ArrayList<Integer> pointsx = new ArrayList<Integer>();
    private ArrayList<Integer> pointsy = new ArrayList<Integer>();
    private float[] currPoints ;

    public Circle() {
        super();
    }

    public Circle(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public void draw(Canvas canvas) {
        midpointCircle();
        canvas.drawPoints(currPoints, this.mPaint);
    }

    private void midpointCircle() {
        if (invalidated) {
            pointsx.clear();
            pointsy.clear();
            double _r = pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2);
            _r = Math.sqrt(_r);
            int r = ((int) _r);
            int x = 0;
            int y = r;
            pointsx.add(x);
            pointsy.add(y);
            int d = 1 - r;
            while (y > x) {
                if (d < 0) //selecione E
                    d += (2 * x) + 3;
                else { //selecione SE
                    d += 2 * (x - y) + 5;
                    y--;
                }
                x++;
                pointsx.add(x);
                pointsy.add(y);
            }
            plotaOcteto();
        }
    }
    private void plotaOcteto(){
        currPoints = new float[16*pointsx.size()];
        int x;
        int y;
        int p1x = (int) p1.x;
        int p1y = (int) p1.y;
        for(int i=0; i< pointsx.size(); i++) {
            x = pointsx.get(i) ;
            y = pointsy.get(i);
            currPoints[0 + i*16] = x + p1x;
            currPoints[1 + i*16] = y + p1y;
            currPoints[2 + i*16] = -x + p1x;
            currPoints[3 + i*16] = y + p1y;
            currPoints[4 + i*16] = -y + p1x;
            currPoints[5 + i*16] = x + p1y;
            currPoints[6 + i*16] = -y + p1x;
            currPoints[7 + i*16] = -x + p1y;
            currPoints[8 + i*16] = -x + p1x;
            currPoints[9 + i*16] = -y + p1y;
            currPoints[10 + i*16] = x + p1x;
            currPoints[11 + i*16] = -y + p1y;
            currPoints[12 + i*16] = y + p1x;
            currPoints[13 + i*16] = -x + p1y;
            currPoints[14 + i*16] = y + p1x;
            currPoints[15 + i*16] = x + p1y;
        }
        invalidated = false;
    }
}