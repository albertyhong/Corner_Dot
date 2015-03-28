package com.example.yunsuphong.cornerdot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

/**
 * Created by yunsuphong on 3/22/15.
 */
public class TouchView extends View {
    //String color;
    int id2;
    Paint paint = new Paint();

    public TouchView(Context context, int id1, int id2) {
        super(context);
        this.id2 = id2;
        //this.color = color;
        int[] colorsArray = {
                Color.WHITE,
                Color.BLUE,
                Color.GREEN,
                Color.RED,
                Color.YELLOW
        };

        int circleColor = colorsArray[id1];

        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);	//vs. STROKE
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        float radius = .1f * Math.min(width, height);

        canvas.drawColor(Color.WHITE);	//background

        if (id2 == 1) {
            canvas.drawCircle(radius, radius, radius, paint); //Top-left
        } else if (id2 == 2) {
            canvas.drawCircle(width - radius, radius, radius, paint); //Top-right
        } else if (id2 == 3) {
            canvas.drawCircle(radius, height - radius, radius, paint); //Bottom-left
        } else {
            canvas.drawCircle(width - radius, height - radius, radius, paint); //Bottom-right
        }

        //String s = width + " \u00D7 " + height; //Unicode "by" character
        String s = "ID2 " + id2;
        Toast toast = Toast.makeText(getContext(), s, Toast.LENGTH_LONG);
        toast.show();
    }
}