package com.example.yunsuphong.cornerdot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    boolean firstTime1 = true;
    boolean firstTime2 = true;
    long id1;
    long id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstTime1) {
                    firstTime1 = false;
                    return;
                }
                String s = "Selected " + parent.getItemAtPosition(position)
                        + ", position = " + position
                        + ", id = " + id + ".";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                id1 = id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String s = "Spinner contains no selected item.";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstTime2) {
                    firstTime2 = false;
                    return;
                }
                String s = "Selected " + parent.getItemAtPosition(position)
                        + ", position = " + position
                        + ", id = " + id + ".";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                id2 = id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String s = "Spinner contains no selected item.";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

        Button submitButton = (Button)findViewById(R.id.submitButton);
        MyOnClickListener myOnClickListener = new MyOnClickListener();
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            //Receives the object that was clicked, View v
            public void onClick(View v) {
                //Convert into a button object. Assuming view being received is a button. Need if statement to ensure
                Button button = (Button) v;
                button.setText("Thanks for pressing this button.");

                Context context = v.getContext();
                Toast.makeText(context, "Selections submitted " + id1 + " " + id2, Toast.LENGTH_LONG).show();

                setContentView(new TouchView(context));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}