package com.madcamp.pokedamalib;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Junhong on 2016-01-11.
 */
public class HelloActivity extends Activity {
    private String TAG = "Unity HelloActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_map);

        setContentView(R.layout.hello);

        FragmentManager fm = getFragmentManager();
        if(null == fm){
            Log.e(TAG, "fragmentManager is null");
        }

//        int fo_id = get
//        FragmentOne fo = (FragmentOne)fm.findFragmentById()
    }
}