package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LinearActivity extends AppCompatActivity {
        Button toRelative;

        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_linear);
            toRelative = findViewById(R.id.toRelative);
            toRelative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LinearActivity.this, RelativeActivity.class);
                    startActivity(i);
                }
            });

        }

}
