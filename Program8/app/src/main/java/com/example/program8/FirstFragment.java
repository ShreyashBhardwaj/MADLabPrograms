package com.example.program8;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    public FirstFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FragmentLifecycle", "FirstFragment - onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FragmentLifecycle", "FirstFragment - onCreateView");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentLifecycle", "FirstFragment - onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentLifecycle", "FirstFragment - onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentLifecycle", "FirstFragment - onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FragmentLifecycle", "FirstFragment - onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentLifecycle", "FirstFragment - onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentLifecycle", "FirstFragment - onDestroy");
    }
}
