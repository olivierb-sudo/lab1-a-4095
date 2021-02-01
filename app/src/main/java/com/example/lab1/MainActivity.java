package com.example.lab1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private final String C_TAG = "ON_CREATE";
    private final String P_TAG = "ON_PAUSED";
    private final String R_TAG = "ON_RESUME";
    private final String D_TAG = "ON_DESTROY";

    private final String START_TAG = "ON_START";
    private final String STOP_TAG = "ON_STOP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(C_TAG, "Non-existent to stopped");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(START_TAG, "Stopped to paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(R_TAG, "Paused to resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(P_TAG, "Resumed to pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(STOP_TAG, "Paused to stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(D_TAG, "Stopped to non-existent");
    }
}