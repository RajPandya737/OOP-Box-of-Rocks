//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: Tell you how many wedges the user has
package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WedgeScreen extends AppCompatActivity {
    //how many wedges the players have
    int Hwedges;
    int Rwedges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedge_screen);
        //get there values from other screens
        SharedPreferences sp = getApplicationContext().getSharedPreferences("HUMAN", Context.MODE_PRIVATE);
        Hwedges = sp.getInt("HumanWedge", 0);
        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("ROCK", Context.MODE_PRIVATE);
        Rwedges = sp2.getInt("RockWedge", 0);
        DrawWedges();

    }

    public void DrawWedges() {
        //changes the images of the other wedges
        ImageView i = (ImageView) findViewById(R.id.HumanWedge);
        ImageView j = (ImageView) findViewById(R.id.RockWedge);
        if (Hwedges == Rwedges && Hwedges == 3) {
            i.setImageResource(R.drawable.threewedge);
            tie();
        } else if (Hwedges == 1) {
            i.setImageResource(R.drawable.onewedge);
        } else if (Hwedges == 2) {
            i.setImageResource(R.drawable.twowedge);
        } else if (Hwedges == 3) {
            i.setImageResource(R.drawable.threewedge);
            win();
        }
        if (Rwedges == 1) {
            j.setImageResource(R.drawable.onewedge);
        } else if (Rwedges == 2) {
            j.setImageResource(R.drawable.twowedge);
        } else if (Rwedges == 3) {
            j.setImageResource(R.drawable.threewedge);
            lose();
        }
    }

    public void win() {
        //if the user wins, they go to the win screen
        Intent i = new Intent(WedgeScreen.this, WinScreen.class);
        startActivity(i);
    }

    public void tie() {
        //if the user ties, they go to the tie screen
        Intent i = new Intent(WedgeScreen.this, Tie.class);
        startActivity(i);
    }

    public void lose() {
        //if the user loses they go to the lose screen
        Intent i = new Intent(WedgeScreen.this, LoseScreen.class);
        startActivity(i);
    }

    public void Th(View view) {
        //the button that takes them back to the main screen. No real reason why its called Th, i think i was just tired
        Intent i = new Intent(WedgeScreen.this, GameScreen.class);
        startActivity(i);
    }
}