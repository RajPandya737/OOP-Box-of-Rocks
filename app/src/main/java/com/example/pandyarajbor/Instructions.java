//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: Tell the user what to do
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    public void home(View view) {
        //one button, brings you home
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}