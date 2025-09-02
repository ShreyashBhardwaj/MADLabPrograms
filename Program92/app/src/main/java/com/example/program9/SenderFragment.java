package com.example.program9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SenderFragment extends Fragment {

    EditText editText;
    Button button;
    OnDataPass dataPasser;

    public interface OnDataPass {
        void onDataPass(String data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sender, container, false);

        editText = view.findViewById(R.id.etInput);
        button = view.findViewById(R.id.btnSend);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            dataPasser.onDataPass(text);
        });

        return view;
    }
}
