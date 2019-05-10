package com.gadgetsaint.viewpagerexample.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gadgetsaint.viewpagerexample.R;

/**
 * Created by Anu on 22/04/17.
 */


public class FragmentOne extends Fragment {


    private int count1;
    private Context mContext;



    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e(FragmentOne.class.getSimpleName(), "onCreateView: ");
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        Log.e(FragmentOne.class.getSimpleName(), "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(FragmentOne.class.getSimpleName(), "onCreate: ");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(FragmentOne.class.getSimpleName(), "onViewCreated: ");



        final TextView textView = view.findViewById(R.id.tv1);
        Button button = view.findViewById(R.id.btn1);

        final EditText editText = view.findViewById(R.id.et);

        Button button2 = view.findViewById(R.id.btn_pass_data);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      String textToPass = editText.getText().toString();
                if (textToPass.length() != 0) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.txt_for_shared_prfs), textToPass);
                    editor.commit();
                }
            }
        });


        if (savedInstanceState != null) {
            count1 = savedInstanceState.getInt("count1", 0);
        }

        textView.setText(String.valueOf(count1));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                textView.setText(String.valueOf(count1));
            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(FragmentOne.class.getSimpleName(), "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(FragmentOne.class.getSimpleName(), "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(FragmentOne.class.getSimpleName(), "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(FragmentOne.class.getSimpleName(), "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(FragmentOne.class.getSimpleName(), "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(FragmentOne.class.getSimpleName(), "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(FragmentOne.class.getSimpleName(), "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;//release context for garbage collection
        Log.e(FragmentOne.class.getSimpleName(), "onDetach: ");
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.e(FragmentOne.class.getSimpleName(), "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
        outState.putInt("count1", count1);
    }


}