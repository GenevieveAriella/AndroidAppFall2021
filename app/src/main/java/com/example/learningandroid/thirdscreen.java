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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdscreen);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
    }

    public void goBacktoMenu(View view) {
        // Intent takes in 2 arguments, the context and the page you want to link to. In this case,
        // I want to link to menuPage. Next step is to go to the sign in button and loads this method
        // into the onCLick attribute
        Intent intent = new Intent(this, menuPage.class);
        startActivity(intent);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
    }

    public void unselectAll(View view) {
        if (cb1.isChecked()) {
            cb1.setChecked(false);
        }
        if (cb2.isChecked()) {
            cb2.setChecked(false);
        }
        if (cb3.isChecked()) {
            cb3.setChecked(false);
        }

    }

    public void selectAll(View view) {
        if (cb1.isChecked() == false) {
            cb1.setChecked(true);
        }
        if (cb2.isChecked() == false) {
            cb2.setChecked(true);
        }
        if (cb3.isChecked() == false) {
            cb3.setChecked(true);
        }
    }
/*    ViewGroup layout= (ViewGroup) findViewById(R.id.linearlayout);
    public void switchToTrue(View v) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View w = layout.getChildAt(i);
            if (v instanceof CheckBox) {
                if (!((CheckBox) v).isChecked()) {
                    ((CheckBox) v).setChecked(true);
                }
            }
        }


    }*/

}