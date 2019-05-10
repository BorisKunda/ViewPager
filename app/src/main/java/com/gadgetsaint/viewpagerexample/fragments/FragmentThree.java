package com.gadgetsaint.viewpagerexample.fragments;

import android.arch.lifecycle.Observer;
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
import android.widget.TextView;

import com.gadgetsaint.viewpagerexample.R;

/**
 * Created by Anu on 22/04/17.
 */


public class FragmentThree extends Fragment {

    private int count3;
    private TextView mTextView;
    private TextView mTextView2;
    private Button mButton;
    private Context mContext;

    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(FragmentThree.class.getSimpleName(), "onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        Log.e(FragmentThree.class.getSimpleName(), "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(FragmentThree.class.getSimpleName(), "onCreate: ");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(FragmentThree.class.getSimpleName(), "onViewCreated: ");

        initViews(view);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String passedString = sharedPreferences.getString(getString(R.string.txt_for_shared_prfs), "default");

        mTextView2.setText(passedString);

        if (savedInstanceState != null) {
            count3 = savedInstanceState.getInt("count3", 0);
        }
        mTextView.setText(String.valueOf(count3));



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count3++;
                mTextView.setText(String.valueOf(count3));
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(FragmentThree.class.getSimpleName(), "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(FragmentThree.class.getSimpleName(), "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(FragmentThree.class.getSimpleName(), "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(FragmentThree.class.getSimpleName(), "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(FragmentThree.class.getSimpleName(), "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(FragmentThree.class.getSimpleName(), "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(FragmentThree.class.getSimpleName(), "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;//release context reference for garbage collection
        Log.e(FragmentThree.class.getSimpleName(), "onDetach: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count3", count3);
    }

    void initViews(View view) {
        mTextView = view.findViewById(R.id.tv3);
        mButton = view.findViewById(R.id.btn3);
        mTextView2 = view.findViewById(R.id.passedTV);
    }

}