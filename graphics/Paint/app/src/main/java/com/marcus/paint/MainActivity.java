package com.marcus.paint;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.paris.Paris;
import com.marcus.paint.gc.AbstractGraphic;
import com.marcus.paint.gc.Circle;
import com.marcus.paint.gc.Line;
import com.marcus.paint.gc.Point;
import com.marcus.paint.gc.Rectangle;
import com.marcus.paint.gc.Square;
import com.marcus.paint.view.PaintView;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Marcus
 */
public class MainActivity extends AppCompatActivity {

    private PaintView mPaintView;
    private Point p1, p2;
    private AbstractGraphic mTemp;
    private AbstractGraphic.Type mSelected = AbstractGraphic.Type.LINE;
    private Button mLastClickedButton;
    private int mPlineCounter = 0;
    private int mCurrentColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mLastClickedButton = findViewById(R.id.LINE);

        mPaintView = findViewById(R.id.paint);

        p1 = new Point(0,0);
        p2 = new Point(0,0);
    }

    public void on2DFormsClick(View v) {
        Button btn = (Button) v;
        Paris.style(mLastClickedButton)
                .apply(R.style.ButtonNotSelected);

        Paris.style(btn)
                .apply(R.style.ButtonSelected);

        mLastClickedButton = btn;

        switch (btn.getId()) {
            case R.id.CIRCLE:
                mSelected = AbstractGraphic.Type.CIRCLE;
                mPlineCounter = 0;
                break;

            case R.id.CURVE:
                mSelected = AbstractGraphic.Type.CURVE;
                mPlineCounter = 0;
                break;

            case R.id.LINE:
                mSelected = AbstractGraphic.Type.LINE;
                mPlineCounter = 0;
                break;

            case R.id.POLYLINE:
                mSelected = AbstractGraphic.Type.POLYLINE;
                break;

            case R.id.RECTANGLE:
                mSelected = AbstractGraphic.Type.RECTANGLE;
                mPlineCounter = 0;
                break;

            case R.id.SQUARE:
                mSelected = AbstractGraphic.Type.SQUARE;
                mPlineCounter = 0;
                break;
        }
    }

    public void onColorClick(final View v) {
        final ColorPicker cp = new ColorPicker(MainActivity.this);
        cp.setColor(mCurrentColor);

        cp.setCallback(color -> {
            mCurrentColor = color;

            v.setBackgroundColor(mCurrentColor);
        });

        // an integer that define RGB is:
           /*   int rgb = red;
                rgb = (rgb << 8) + green;
                rgb = (rgb << 8) + blue;*/

           /*
                int red = (color >> 16) & 0xFF;
                int green = (color >> 8) & 0xFF;
                int blue = color & 0xFF;
            */

        cp.show();
    }

    private void draw() {

        switch (mSelected) {
            case CIRCLE:
                mPaintView.drawCircle(mCurrentColor, p1, p2);

                break;
            case RECTANGLE:

                mPaintView.drawRect(mCurrentColor, p1, p2);

                break;
            case LINE:

                mPaintView.drawLine(mCurrentColor, p1, p2);

                break;
            case POLYLINE:

                mPaintView.drawLine(mCurrentColor, p1, p2);

                mPlineCounter++;

                break;
            case CURVE:
                break;
            case SQUARE:

                mPaintView.drawSquare(mCurrentColor, p1, p2);

                break;
        }
    }

    private void drawTemp() {
        switch (mSelected) {
            case CIRCLE:
                if (mTemp != null) {
                    mTemp.setPoints(p1, p2);
                } else {
                    mTemp = new Circle(p1, p2);
                }
                break;
            case RECTANGLE:

                if (mTemp != null) {
                    mTemp.setPoints(p1, p2);
                } else {
                    mTemp = new Rectangle(p1, p2);
                }

                break;
            case LINE:

                if (mTemp != null) {
                    mTemp.setPoints(p1, p2);
                } else {
                    mTemp = new Line(p1, p2);
                }

                break;
            case POLYLINE:

                if (mTemp != null) {
                    mTemp.setPoints(p1, p2);
                } else {
                    mTemp = new Line(p1, p2);
                }

                break;
            case CURVE:
                break;
            case SQUARE:
                if (mTemp != null) {
                    mTemp.setPoints(p1, p2);
                } else {
                    mTemp = new Square(p1, p2);
                }
                break;
        }

        mPaintView.drawTemp(mTemp, mCurrentColor);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mSelected == AbstractGraphic.Type.POLYLINE && mPlineCounter > 0) {
                    p1.x = p2.x;
                    p1.y = p2.y;
                } else {
                    p1.x = event.getX();
                    p1.y = event.getY();
                }
                break;

            case MotionEvent.ACTION_UP:
                mTemp = null;

                draw();

                break;

            case MotionEvent.ACTION_MOVE:
                p2.x = event.getX();
                p2.y = event.getY();

                drawTemp();
                break;
        }

        return super.onTouchEvent(event);
    }
}
