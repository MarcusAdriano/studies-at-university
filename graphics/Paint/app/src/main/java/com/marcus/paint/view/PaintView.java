package com.marcus.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.marcus.paint.gc.AbstractGraphic;
import com.marcus.paint.gc.Circle;
import com.marcus.paint.gc.Line;
import com.marcus.paint.gc.Point;
import com.marcus.paint.gc.Rectangle;
import com.marcus.paint.gc.Square;

import java.util.LinkedList;

import androidx.annotation.Nullable;

/**
 * @author Marcus
 */
public class PaintView extends View {

    private LinkedList<AbstractGraphic> mGraphics;
    private AbstractGraphic temp;

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mGraphics = new LinkedList<>();
    }

    public Line drawLine(int color, Point p1, Point p2) {
        Line line = new Line(p1, p2);
        line.setColor(color);
        this.mGraphics.add(line);
        invalidate();
        return line;
    }

    public Rectangle drawRect(int color, Point p1, Point p2) {
        Rectangle rect = new Rectangle(p1, p2);
        rect.setColor(color);
        this.mGraphics.add(rect);
        invalidate();
        return rect;
    }

    public Square drawSquare(int color, Point p1, Point p2) {
        Square square = new Square(p1, p2);
        square.setColor(color);
        this.mGraphics.add(square);
        invalidate();
        return square;
    }

    public void drawCircle(int color, Point p1, Point p2) {
        Circle circle = new Circle(p1, p2);
        circle.setColor(color);
        this.mGraphics.add(circle);
        invalidate();
    }

    public Line drawLine(Point p1, Point p2) {
        Line line = new Line(p1, p2);
        this.mGraphics.add(line);
        invalidate();
        return line;
    }

    public Rectangle drawRect(Point p1, Point p2) {
        Rectangle rect = new Rectangle(p1, p2);
        this.mGraphics.add(rect);
        invalidate();
        return rect;
    }

    public Square drawSquare(Point p1, Point p2) {
        Square square = new Square(p1, p2);
        this.mGraphics.add(square);
        invalidate();
        return square;
    }

    public void drawCircle(Point p1, Point p2) {
        Circle rectCircle = new Circle(p1, p2);
        this.mGraphics.add(rectCircle);
        invalidate();
    }



    public void draw(AbstractGraphic ab) {
        this.mGraphics.add(ab);
        invalidate();
    }

    public void remove(AbstractGraphic ab) {
        if (this.mGraphics.remove(ab)) {
            invalidate();
        }
    }

    public void drawTemp(AbstractGraphic ab, int color) {
        temp = ab;
        temp.setColor(color);
        if (temp != null) {
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (AbstractGraphic g : mGraphics) {
            g.draw(canvas);
        }

        if (temp != null) {
            temp.draw(canvas);
        }
    }
}
