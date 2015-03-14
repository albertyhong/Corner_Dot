package com.example.yunsuphong.cornerdot;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by yunsuphong on 3/13/15.
 */
public class MyOnClickListener implements View.OnClickListener {

    @Override
    //Receives the object that was clicked, View v
    public void onClick(View v) {
        //Convert into a button object. Assuming view being received is a button. Need if statement to ensure
        Button button = (Button) v;
        button.setText("Thanks for pressing this button.");

        Context context = v.getContext();
        Toast.makeText(context, "Selections submitted", Toast.LENGTH_LONG).show();
    }
}
