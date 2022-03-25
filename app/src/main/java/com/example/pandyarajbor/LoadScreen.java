//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: Give the user a more fulfilling experiance
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class LoadScreen extends AppCompatActivity {
    ProgressBar pb;
    //used to give value to the progress bar view
    int counter = 0;

    //the percent on the progress bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        prog();
    }

    public void prog() {
        //progress bar and circle that tells you how long you have to wait before being redirected
        pb = (ProgressBar) findViewById(R.id.progress_bar);
        Timer timer = new Timer();
        TimerTask timer2 = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter == 100) {
                    Intent i = new Intent(LoadScreen.this, MainActivity.class);
                    startActivity(i);
                }

            }
        };
        timer.schedule(timer2, 0, 10);
    }
}