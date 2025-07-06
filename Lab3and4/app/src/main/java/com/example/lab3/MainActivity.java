package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button Enter;
    EditText et;
    CheckBox c1,c2,c3;
    RadioGroup rg;
    RadioButton rb1,rb2;

    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        t=findViewById(R.id.textView);
        et=findViewById(R.id.editTextText);
        c1=findViewById(R.id.checkBox);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        rg=findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        Enter=findViewById(R.id.button);
        s1=findViewById(R.id.switch1);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();

                Toast.makeText(getApplicationContext(), "Hello " + s, Toast.LENGTH_LONG).show();

                if (c1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You Know Java", Toast.LENGTH_SHORT).show();
                }
                if (c2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You Know Python", Toast.LENGTH_SHORT).show();
                }
                if (c3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You Know C++", Toast.LENGTH_SHORT).show();
                }

                if (rb1.isChecked() && !rb2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You are Male", Toast.LENGTH_SHORT).show();
                } else if (rb2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You are Female", Toast.LENGTH_SHORT).show();
                }

                if (s1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Switch is On", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Switch is Off", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}