package com.example.program13;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView tv ;
    EditText et;

    Button saveInternal,loadInternal,saveExternal,loadExternal;

    final String internalFile = "internal.txt";
    final String externalFile = "external.txt";


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
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.Text);
        saveInternal = findViewById(R.id.saveInternal);
        loadInternal = findViewById(R.id.loadInternal);
        saveExternal= findViewById(R.id.saveExternal);
        loadExternal = findViewById(R.id.loadExternal);


        saveInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et.getText().toString();

                saveToInternal(data);
            }
        });
        loadInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFromInternal();
            }
        });
        saveExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et.getText().toString();

                saveToExternal(data);
            }
        });
        loadExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFromExternal();
            }
        });
    }

    private void loadFromExternal() {
        File file = new File(getExternalFilesDir(null),externalFile);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                sb.append(line).append("\n");
            }
            Toast.makeText(this, "Loaded from External", Toast.LENGTH_SHORT).show();
            br.close();
            tv.setText(sb.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadFromInternal() {
        try{
            FileInputStream fis = openFileInput(internalFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                sb.append(line).append("\n");
            }
        Toast.makeText(this, "Loaded from Internal", Toast.LENGTH_SHORT).show();
            br.close();
            tv.setText(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void saveToInternal(String data) {
        try{
            FileOutputStream fos = openFileOutput(internalFile,MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(this, "Saved to Internal Storage", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToExternal(String data) {
        if(isExternalStorageWriteable()){
            File file = new File(getExternalFilesDir(null),externalFile);
            try{
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data.getBytes());
                fos.close();
                Toast.makeText(this, "Saved to External Storage", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean isExternalStorageWriteable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }


}