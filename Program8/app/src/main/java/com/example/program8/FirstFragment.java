package com.example.program8;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragment LifeCycle","onAttach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment LifeCycle","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Fragment LifeCycle","onCreteView");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Fragment LifeCycle","onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment LifeCycle","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment LifeCycle","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment LifeCycle","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment LifeCycle","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment LifeCycle","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment LifeCycle","onDestroy");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        Log.d("Fragment LifeCycle","onDetach");
    }
}