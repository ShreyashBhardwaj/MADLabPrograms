package com.example.lab8;

import android.os.Bundle;

import com.example.lab8.SenderFragment;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements SenderFragment.OnDataPass {

    ReceiverFragment receiverFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add SenderFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerA, new SenderFragment())
                .commit();

        // Add ReceiverFragment
        receiverFragment = new ReceiverFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerB, receiverFragment)
                .commit();
    }

    // Interface method called from SenderFragment
    @Override
    public void onDataPass(String data) {
        receiverFragment.updateText(data);
    }
}
