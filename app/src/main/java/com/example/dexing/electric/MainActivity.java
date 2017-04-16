package com.example.dexing.electric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGetPoint = (Button) findViewById(R.id.btnGetPoint);
        btnGetPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GetPointActivity.class));
            }
        });

        Button btnDrawLine = (Button) findViewById(R.id.btnDrawLine);
        btnDrawLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DrawLineActivity.class));
            }
        });

    }
}
