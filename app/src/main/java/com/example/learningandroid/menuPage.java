package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

    }

    /**
     The purpose of this public method is to link our menu page to the landing page together
     **/
    public void signOutButtonClick(View view){
        // Intent takes in 2 arguments, the context and the page you want to link to. In this case,
        // I want to link to menuPage. Next step is to go to the sign in button and loads this method
        // into the onCLick attribute
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void viewThirdScreen(View view) {
        // Intent takes in 2 arguments, the context and the page you want to link to. In this case,
        // I want to link to menuPage. Next step is to go to the sign in button and loads this method
        // into the onCLick attribute
        Intent intent = new Intent(this, thirdscreen.class);
        startActivity(intent);
    }

    }
