package com.rikin.bored.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rikin.bored.R;
import com.rikin.bored.view.StreamListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreamListFragment streamListFragment = (StreamListFragment) getSupportFragmentManager()
                .findFragmentByTag(StreamListFragment.TAG);
        if (streamListFragment == null) {
            streamListFragment = StreamListFragment.newInstance();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_activity, streamListFragment)
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
