package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class thirdscreen extends AppCompatActivity {
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    CheckBox cb5;
    CheckBox cb6;
    CheckBox cb7;
    CheckBox cb8;
    CheckBox cb9;
    CheckBox cb10;
    CheckBox cb11;
    CheckBox cb12;
    CheckBox cb13;
    CheckBox cb14;
    CheckBox cb15;
    CheckBox cb16;
    CheckBox cb17;
    CheckBox cb18;
    CheckBox cb19;
    CheckBox cb20;
    CheckBox cb21;
    CheckBox cb22;
    CheckBox cb23;
    CheckBox cb24;
    CheckBox cb25;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdscreen);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        cb9 = findViewById(R.id.checkBox9);
        cb10 = findViewById(R.id.checkBox10);
        cb11 = findViewById(R.id.checkBox11);
        cb12 = findViewById(R.id.checkBox12);
        cb13 = findViewById(R.id.checkBox13);
        cb14 = findViewById(R.id.checkBox14);
        cb15 = findViewById(R.id.checkBox15);
        cb16 = findViewById(R.id.checkBox16);
        cb17 = findViewById(R.id.checkBox17);
        cb18 = findViewById(R.id.checkBox18);
        cb19 = findViewById(R.id.checkBox19);
        cb20 = findViewById(R.id.checkBox20);
        cb21 = findViewById(R.id.checkBox21);
        cb22 = findViewById(R.id.checkBox22);
        cb23 = findViewById(R.id.checkBox23);
        cb24 = findViewById(R.id.checkBox24);
        cb25 = findViewById(R.id.checkBox25);
    }

    public void goBacktoMenu(View view) {
        // Intent takes in 2 arguments, the context and the page you want to link to. In this case,
        // I want to link to menuPage. Next step is to go to the sign in button and loads this method
        // into the onCLick attribute
        Intent intent = new Intent(this, menuPage.class);
        startActivity(intent);



    }

    public void unselectAll(View view) {
        ViewGroup layout = (ViewGroup) findViewById(R.id.linearlayout);
        for (int i = 0; i < layout.getChildCount(); i++) {

            View child = layout.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox button = (CheckBox) child;
                if (button.isChecked()) {
                    button.setChecked(false);
                }


            }
        }
    }


    public void selectAll(View view) {
        ViewGroup layout = (ViewGroup) findViewById(R.id.linearlayout);
        for (int i = 0; i < layout.getChildCount(); i++) {

            View child = layout.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox button = (CheckBox) child;
                if (button.isChecked() == false) {
                    button.setChecked(true);


                }
            }
        }
    }

    public void hideAll(View view) {
        ViewGroup layout = (ViewGroup) findViewById(R.id.linearlayout);
        for (int i = 0; i < layout.getChildCount(); i++) {

            View child = layout.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox button = (CheckBox) child;
                button.setVisibility(View.GONE);
            }
        }
    }




}