//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: To create a fun game for Ms McGonagall ELL class (grade 4-5)
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //EXTRA FEATURE: MUSIC
    MediaPlayer mySong;
    Stack deck = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//EXTRA FEATURES: shared preferences to reset any previous values
        SharedPreferences HW;
        HW = getSharedPreferences("HUMAN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = HW.edit();
        editor1.putInt("HumanWedge", 0);
        editor1.commit();

        SharedPreferences RW;
        RW = getSharedPreferences("ROCK", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = RW.edit();
        editor2.putInt("RockWedge", 0);
        editor2.commit();
        //originally there were 3 timers that showed images, but I want to make sure that the users phone is able to run the program, if you would like to see the original video
        //the link is: https://www.youtube.com/watch?v=6q2NbYt-eX8
        mySong = MediaPlayer.create(MainActivity.this, R.raw.littletalks_ofmonsterssong);
        mySong.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }

    //all these methods just bring you to different screens
    public void test(View view) {
        Intent i = new Intent(this, name.class);
        startActivity(i);
    }

    public void instructions(View view) {
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
    }

    public void rate(View view) {
        Intent i = new Intent(this, RateScreen.class);
        startActivity(i);
    }

    public void practice(View view) {
        Intent i = new Intent(this, PracticeScreen.class);
        startActivity(i);
    }
}