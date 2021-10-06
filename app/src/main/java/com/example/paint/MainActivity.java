package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button setB;
    private Button aboutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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