//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: Tell the user they got a tie
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);
    }

    public void home(View view) {
        //single button that takes you home
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}