package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
            TextView textView;
            TextView textView2;
            TextView textView3;
            TextView textView4;
            TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(x);

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(x);

            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(x);

            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(x);

            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(x);

            }
        });
    }
}
