package com.example.program13;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Environment;
import android.widget.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    EditText editTextData;
    TextView textViewOutput;

    final String internalFile = "internal_data.txt";
    final String externalFile = "external_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextData = findViewById(R.id.editTextData);
        textViewOutput = findViewById(R.id.textViewOutput);

        findViewById(R.id.btnSaveInternal).setOnClickListener(view -> saveToInternal());
        findViewById(R.id.btnLoadInternal).setOnClickListener(view -> loadFromInternal());
        findViewById(R.id.btnSaveExternal).setOnClickListener(view -> saveToExternal());
        findViewById(R.id.btnLoadExternal).setOnClickListener(view -> loadFromExternal());
    }

    private void saveToInternal() {
        String data = editTextData.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(internalFile, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            showToast("Saved to internal storage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFromInternal() {
        try {
            FileInputStream fis = openFileInput(internalFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
            textViewOutput.setText(sb.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToExternal() {
        if (isExternalStorageWritable()) {
            File file = new File(getExternalFilesDir(null), externalFile);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(editTextData.getText().toString().getBytes());
                fos.close();
                showToast("Saved to external storage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFromExternal() {
        File file = new File(getExternalFilesDir(null), externalFile);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
            textViewOutput.setText(sb.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    PUshing to Completed Repo

    private boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
