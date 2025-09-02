package com.example.program34;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button submit;
    CheckBox python,java,c;
    RadioGroup rg;
    Switch s;

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

        et = findViewById(R.id.enterName);
        python = findViewById(R.id.checkPython);
        java = findViewById(R.id.checkJava);
        c = findViewById(R.id.checkC);
        rg = findViewById(R.id.radio);
        s= findViewById(R.id.switch1);
        submit = findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Let's Go", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Your Name: "+et.getText().toString(),Toast.LENGTH_SHORT).show();

                if (python.isChecked())
                {
                    Toast.makeText(MainActivity.this,"You Like Python",Toast.LENGTH_SHORT).show();

                }

                if (java.isChecked()){
                    Toast.makeText(MainActivity.this,"You Like Java",Toast.LENGTH_SHORT).show();
                }

                if (c.isChecked()){
                    Toast.makeText(MainActivity.this,"You Like C++",Toast.LENGTH_SHORT).show();

                }

                int selectedId =rg.getCheckedRadioButtonId();
                if(selectedId != -1){
                    RadioButton rb = findViewById(selectedId);
                    Toast.makeText(MainActivity.this,"You Select: "+rb.getText().toString(),Toast.LENGTH_SHORT).show();

                }
                if (s.isChecked()){
                    Toast.makeText(MainActivity.this,"You Like heavy Metal",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"You Dont Like heavy Metal",Toast.LENGTH_LONG).show();
                    Log.d("Switch Check","Switch State"+s.isChecked());

                }
            }
        });

    }
}