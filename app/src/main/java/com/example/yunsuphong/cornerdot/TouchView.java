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
    String color;
    int id1;

    Paint paint = new Paint();

    public TouchView(Context context, String color, int id1) {
        super(context);
        this.color = color;
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
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);

        String s = width + " \u00D7 " + height; //Unicode "by" character
        Toast toast = Toast.makeText(getContext(), s, Toast.LENGTH_LONG);
        toast.show();
    }
}