package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button setB;
    private Button aboutB;


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    //private SensorActivity lightEventListener;

    private SensorManager sensorManager;
    private TextView lightLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lightLevel = (TextView) findViewById(R.id.light_level);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);


       // lightEventListener = new SensorActivity();



        setB = findViewById(R.id.settingsbutton);
        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivityForResult(intent , 1);

            }
        });

        aboutB = findViewById(R.id.aboutbutton);
        aboutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
               // finish();

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }
    }
    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
// The value of the first subscript in the values array is the current light intensity
            float value = event.values[0];
            lightLevel.setText("Current light level is " + value + " lx");
            if (value < 20.0){
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));

            } else {
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));

            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

   



    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        int result = data.getIntExtra("c", 0);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                //red
                if (result == 1) {
                    getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));

                }

                //green
                if (result == 2) {
                    getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));

                }

                //blue
                if (result == 3) {
                    getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));

                }

                //getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(second.this, R.color.red));

            }
        }
    }





}