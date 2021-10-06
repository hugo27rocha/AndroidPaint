package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button red = findViewById(R.id.redbutton);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("c", 1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button green = findViewById(R.id.greenbutton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultintent = new Intent();
                resultintent.putExtra("c", 2);
                setResult(RESULT_OK, resultintent);
                finish();
            }
        });

        Button blue = findViewById(R.id.bluebutton);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultintent = new Intent();
                resultintent.putExtra("c", 3);
                setResult(RESULT_OK, resultintent);
                finish();
            }
        });


    }
}