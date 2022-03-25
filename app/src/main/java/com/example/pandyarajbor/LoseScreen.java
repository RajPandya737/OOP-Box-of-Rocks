//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: Tell the user they lost
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoseScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_screen);
    }

    public void home(View view) {
        //button that takes you home
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}