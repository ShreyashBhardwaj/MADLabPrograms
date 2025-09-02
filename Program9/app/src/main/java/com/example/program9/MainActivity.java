package com.example.program9;

import android.Manifest;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button record,stop,play;
    MediaRecorder mr;
    MediaPlayer mp;
    String absolutePath;

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
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},1);

        record = findViewById(R.id.record);
        stop = findViewById(R.id.stop);
        play = findViewById(R.id.play);

        absolutePath = getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath()+"/recording.3gp";

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordAudio();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });
    }

    private void recordAudio() {
        mr = new MediaRecorder();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mr.setOutputFile(absolutePath);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try{
            mr.prepare();
            mr.start();
            Toast.makeText(this, "Recording Started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void stopAudio(){
        if (mr!=null){
            mr.stop();
            mr.release();
            mr = null;
            Toast.makeText(this, "Recording Stopped", Toast.LENGTH_SHORT).show();
        }

        if(mp != null && mp.isPlaying()){
            mp.stop();
            mp.release();
            mp = null;
            Toast.makeText(this, "Playback Stopped", Toast.LENGTH_SHORT).show();
        }
    }

    private void playAudio(){
        mp = new MediaPlayer();
        try {
            mp.setDataSource(absolutePath);
            mp.prepare();
            mp.start();
            Toast.makeText(this, "Playback has Begun", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}