//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: To allow the user to practice without the pressure of being exposed as someone who is 'dumber than a box of rocks'
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class PracticeScreen extends AppCompatActivity {
    MediaPlayer mySong;
    //similar grid game to the unit 5 project
    //rows and col int values
    int row = 4;
    int col = 4;
    ImageView pics[] = new ImageView[row * col];
    //the bored value's don't change, there are there to put the image on
    int bored[][] =
            {{1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1}};
    //new stack
    Stack deck = new Stack();
    //number of cards
    int num = 0;
    //question and answer global variable used for displaying
    String q;
    int ans;
    //Global variable that is useful for telling the user to wait
    boolean wait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_screen);
        mySong = MediaPlayer.create(PracticeScreen.this, R.raw.marsh_happier);
        mySong.start();
        //set up grid
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pics[m] = new ImageView(this);
                setpicStart(pics[m], m);
                pics[m].setId(m);
                pics[m].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridButtonClick(v.getId());
                    }
                });
                g.addView(pics[m]);
                m++;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }

    public void push() {
        //pushes the card onto the screen
        Card c = new Card();
        q = c.getQuestion();
        ans = c.getAnswer();
        if (!deck.isFull()) {
            deck.push(c);
            num++;
        }
    }

    public void gridButtonClick(int pos) {
        //tells the game if something has been clicked
        if (wait == true) {
            Toast.makeText(getApplicationContext(), "Error: Please wait 2 seconds between clicking on a new question", Toast.LENGTH_SHORT).show();
        } else {
            wait = true;
            int x = pos / col;
            int y = pos % col;
            TextView t = (TextView) findViewById(R.id.question);
            TextView a = (TextView) findViewById(R.id.answer);
            if (bored[x][y] == 1) {
                push();
                t.setText("" + q);
                a.setText("" + ans);
            }
            Timer timer;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    wait = false;
                }
            }, 2000);
        }
    }

    public void home(View view) {
        //takes you back to the main menu
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }

    public void setpicStart(ImageView i, int pos) {
        //sets the pictures up at the beginning
        int x = pos / col;
        int y = pos % col;
        int picnum = bored[x][y];
        if (picnum == 1)
            i.setImageResource(R.drawable.square);
    }

}