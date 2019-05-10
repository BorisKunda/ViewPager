package com.gadgetsaint.viewpagerexample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gadgetsaint.viewpagerexample.R;

/**
 * Created by Anu on 22/04/17.
 */



public class FragmentTwo extends Fragment {

    private int count2;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(FragmentTwo.class.getSimpleName(), "onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(FragmentTwo.class.getSimpleName(), "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(FragmentTwo.class.getSimpleName(), "onCreate: ");
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textView = view.findViewById(R.id.tv2);

        if (savedInstanceState != null) {
            count2 = savedInstanceState.getInt("count2", 0);
        }
        textView.setText(String.valueOf(count2));


        Button button = view.findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                textView.setText(String.valueOf(count2));
            }
        });


        Log.e(FragmentTwo.class.getSimpleName(), "onViewCreated: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(FragmentTwo.class.getSimpleName(), "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(FragmentTwo.class.getSimpleName(), "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(FragmentTwo.class.getSimpleName(), "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(FragmentTwo.class.getSimpleName(), "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(FragmentTwo.class.getSimpleName(), "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(FragmentTwo.class.getSimpleName(), "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(FragmentTwo.class.getSimpleName(), "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(FragmentTwo.class.getSimpleName(), "onDetach: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(FragmentTwo.class.getSimpleName(), "onSaveInstanceState: ");
        outState.putInt("count2", count2);
    }
}