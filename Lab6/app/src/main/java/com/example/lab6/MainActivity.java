package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
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

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button);

        String trueUsername="admin";
        String truePassword="abc123";

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if (user.equals(trueUsername) && pass.equals(truePassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });


    }
}