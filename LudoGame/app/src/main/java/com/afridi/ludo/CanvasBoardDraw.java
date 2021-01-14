package com.afridi.ludo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasBoardDraw extends View{

    private Paint paintBorder, paintPath, paintHomePath, paintFrame, paintBigCircle, redBox, greenBox, yellowBox, blueBox;
    public int width, hgt, canvasTop, canvasBottom, d;

    public CanvasBoardDraw(Context c, AttributeSet attrs) {

        super(c, attrs);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        assignCanvasComponent(canvas);
        canvasMaker(canvas);
        drawCircle(canvas);
    }

    private void assignCanvasComponent(Canvas canvas1) {

        width = canvas1.getWidth();
        hgt = canvas1.getHeight();
        d = width / 15;
        canvasTop = (hgt - width) / 2;
        canvasBottom = (hgt + width) / 2;


        redBox = new Paint();
        greenBox = new Paint();
        yellowBox = new Paint();
        blueBox = new Paint();
        redBox.setColor(Color.RED);
        greenBox.setColor(Color.GREEN);
        yellowBox.setColor(Color.YELLOW);
        blueBox.setColor(Color.BLUE);

        paintBorder = new Paint();
        paintBorder.setStrokeWidth(2f);
        paintBorder.setColor(Color.BLACK);
        paintBorder.setStyle(Paint.Style.STROKE);

        paintPath = new Paint();
        paintPath.setColor(Color.LTGRAY);
        paintPath.setStyle(Paint.Style.FILL);

        paintHomePath = new Paint();
        paintHomePath.setColor(Color.WHITE);
        paintHomePath.setStyle(Paint.Style.FILL);

        paintFrame = new Paint();
        paintFrame.setAlpha(16);
        paintFrame.setColor(Color.WHITE);
        paintFrame.setStyle(Paint.Style.FILL);

        paintBigCircle = new Paint();
        paintBigCircle.setColor(Color.WHITE);
        paintBigCircle.setStyle(Paint.Style.FILL);

    }

    private void canvasMaker(Canvas canvas1) {

        canvas1.drawRect(0, canvasTop, width, canvasBottom, paintFrame);
//draw 4 rectangular box
        canvas1.drawRect(8, canvasTop + 8, 6 * d - 8, canvasTop + 6 * d - 8, redBox);
        canvas1.drawRect(9 * d + 8, canvasTop + 8, width - 8, canvasTop + 6 * d - 8, greenBox);
        canvas1.drawRect(8, canvasTop + 9 * d + 8, 6 * d - 8, canvasBottom - 8, yellowBox);
        canvas1.drawRect(9 * d + 8, canvasTop + 9 * d + 8, width - 8, canvasBottom - 8, blueBox);
        canvas1.drawRect(8, canvasTop + 8, 6 * d - 8, canvasTop + 6 * d - 8, paintBorder);
        canvas1.drawRect(9 * d + 8, canvasTop + 8, width - 8, canvasTop + 6 * d - 8, paintBorder);
        canvas1.drawRect(8, canvasTop + 9 * d + 8, 6 * d - 8, canvasBottom - 8, paintBorder);
        canvas1.drawRect(9 * d + 8, canvasTop + 9 * d + 8, width - 8, canvasBottom - 8, paintBorder);

//Draw Path
        for (int i = 0; i <= 5; i++) {

            canvas1.drawRect(i * d, canvasTop + 6 * d, d + i * d, canvasTop + 7 * d, paintPath);//left-top
            canvas1.drawRect(i * d, canvasTop + 8 * d, d + i * d, canvasTop + 9 * d, paintPath);//left-bottom
            canvas1.drawRect(9 * d + i * d, canvasTop + 6 * d, 10 * d + i * d, canvasTop + 7 * d, paintPath);//right-top
            canvas1.drawRect(9 * d + i * d, canvasTop + 8 * d, 10 * d + i * d, canvasTop + 9 * d, paintPath);//right-bottom

            canvas1.drawRect(i * d, canvasTop + 6 * d, d + i * d, canvasTop + 7 * d, paintBorder);//left-top
            canvas1.drawRect(i * d, canvasTop + 8 * d, d + i * d, canvasTop + 9 * d, paintBorder);//left-bottom
            canvas1.drawRect(9 * d + i * d, canvasTop + 6 * d, 10 * d + i * d, canvasTop + 7 * d, paintBorder);//right-top
            canvas1.drawRect(9 * d + i * d, canvasTop + 8 * d, 10 * d + i * d, canvasTop + 9 * d, paintBorder);//right-bottom

            canvas1.drawRect(6 * d, canvasTop + i * d, 7 * d, canvasTop + d + i * d, paintPath);//top-left
            canvas1.drawRect(8 * d, canvasTop + i * d, 9 * d, canvasTop + d + i * d, paintPath);//top-right
            canvas1.drawRect(6 * d, canvasTop + 9 * d + i * d, 7 * d, canvasTop + 10 * d + i * d, paintPath);//bottom-left
            canvas1.drawRect(8 * d, canvasTop + 9 * d + i * d, 9 * d, canvasTop + 10 * d + i * d, paintPath);//bottom-right

            canvas1.drawRect(6 * d, canvasTop + i * d, 7 * d, canvasTop + d + i * d, paintBorder);//top-left
            canvas1.drawRect(8 * d, canvasTop + i * d, 9 * d, canvasTop + d + i * d, paintBorder);//top-right
            canvas1.drawRect(6 * d, canvasTop + 9 * d + i * d, 7 * d, canvasTop + 10 * d + i * d, paintBorder);//bottom-left
            canvas1.drawRect(8 * d, canvasTop + 9 * d + i * d, 9 * d, canvasTop + 10 * d + i * d, paintBorder);//bottom-right

        }
//Center Path Of Every Side
        canvas1.drawRect(0, canvasTop + 7 * d, d, canvasTop + 8 * d, paintPath);
        canvas1.drawRect(7 * d, canvasTop + 14*d, 8 * d, canvasTop + 15*d, paintPath);
        canvas1.drawRect(14*d, canvasTop + 7 * d, 15*d, canvasTop + 8 * d, paintPath);
        canvas1.drawRect(7 * d, canvasTop, 8 * d, canvasTop + d, paintPath);

        canvas1.drawRect(0, canvasTop + 7 * d, d, canvasTop + 8 * d, paintBorder);
        canvas1.drawRect(7 * d, canvasTop + 14 * d, 8 * d, canvasTop + 15*d, paintBorder);
        canvas1.drawRect(14 * d, canvasTop + 7 * d, 15*d, canvasTop + 8 * d, paintBorder);
        canvas1.drawRect(7 * d, canvasTop, 8 * d, canvasTop + d, paintBorder);

//Home Path
        for (int i = 0; i <= 4; i++) {

            canvas1.drawRect(d + i * d, canvasTop + 7 * d, 2 * d + i * d, canvasTop + 8 * d, paintHomePath);
            canvas1.drawRect(7 * d, canvasTop + 9 * d + i * d, 8 * d, canvasTop + 10 * d + i * d, paintHomePath);
            canvas1.drawRect(9 * d + i * d, canvasTop + 7 * d, 10 * d + i * d, canvasTop + 8 * d, paintHomePath);
            canvas1.drawRect(7 * d, canvasTop + d + i * d, 8 * d, canvasTop + 2 * d + i * d, paintHomePath);

            canvas1.drawRect(d + i * d, canvasTop + 7 * d, 2 * d + i * d, canvasTop + 8 * d, paintBorder);
            canvas1.drawRect(7 * d, canvasTop + 9 * d + i * d, 8 * d, canvasTop + 10 * d + i * d, paintBorder);
            canvas1.drawRect(9 * d + i * d, canvasTop + 7 * d, 10 * d + i * d, canvasTop + 8 * d, paintBorder);
            canvas1.drawRect(7 * d, canvasTop + d + i * d, 8 * d, canvasTop + 2 * d + i * d, paintBorder);

        }

    }

    private void drawCircle(Canvas can) {

        //Board-one
        can.drawCircle(3 * d, canvasTop + 3 * d, 3 * d - 20, paintBigCircle);
        can.drawCircle(3 * d, canvasTop + 3 * d, 3 * d - 20, paintBorder);

        //Board-two
        can.drawCircle(12 * d, canvasTop + 3 * d, 3 * d - 20, paintBigCircle);
        can.drawCircle(12 * d, canvasTop + 3 * d, 3 * d - 20, paintBorder);

        //Board-three
        can.drawCircle(3 * d, canvasBottom - 3 * d, 3 * d - 20, paintBigCircle);
        can.drawCircle(3 * d, canvasBottom - 3 * d, 3 * d - 20, paintBorder);

        //Board-four
        can.drawCircle(12 * d, canvasBottom - 3 * d, 3 * d - 20, paintBigCircle);
        can.drawCircle(12 * d, canvasBottom - 3 * d, 3 * d - 20, paintBorder);

    }

}