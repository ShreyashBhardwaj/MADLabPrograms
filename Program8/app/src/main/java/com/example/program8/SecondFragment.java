package com.example.program8;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {

    public SecondFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FragmentLifecycle", "SecondFragment - onCreateView");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}


// Now to do it Myself
