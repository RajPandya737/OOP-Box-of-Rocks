//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: To give users the ability to rate the game
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RateScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_screen);
    }

    public void home(View view){
        //one buttons that takes you home
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}