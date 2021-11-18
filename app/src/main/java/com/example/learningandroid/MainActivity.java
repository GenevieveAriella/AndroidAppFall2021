package com.example.learningandroid;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void nextScreen(View view) {
//        makeText(getApplicationContext(),"Next Screen", LENGTH_SHORT).show();
//    }
}