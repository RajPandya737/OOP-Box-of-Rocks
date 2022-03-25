//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: The main screen where the user faces off againt the rock
package com.example.pandyarajbor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    //This is the stack of cards
    Stack deck = new Stack();
    //The next 2 variables are the points the players get, H stands for human, r stands for rocks
    int Hpoints = 0;
    int Rpoints = 0;
    //These 2 variables are how many wedges the players have, a wedge is added to the player who gets 3 points first
    int Hwedges;
    int Rwedges;
    //Tracks how many cards left
    int num = 0;
    //Next 3 are variable, q is question, ans is answer, r is reason
    String q;
    int ans;
    String r;
//used in shared preferences to find the users name length
    int namelength;
MediaPlayer mySong;

    Timer timer;
    //The next few lines are for countdown timers to change textviews
    private static final long START_TIME_IN_MILLIS = 4000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimerLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mySong= MediaPlayer.create(GameScreen.this, R.raw.zense);
        mySong.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        //Shared preferences to get the number of wedges each player has
        SharedPreferences HW = getApplicationContext().getSharedPreferences("HUMAN", Context.MODE_PRIVATE);
        Hwedges = HW.getInt("HumanWedge", 0);
        SharedPreferences RW = getApplicationContext().getSharedPreferences("ROCK", Context.MODE_PRIVATE);
        Rwedges = RW.getInt("RockWedge", 0);
        //push method pushes a new card
        push();
        //load shows the players name they entered in the name screen
        load();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
    private void resetTimer() {
        //Useful method to reset the timer
        mTimerLeftInMillis = START_TIME_IN_MILLIS;
    }


    public void push() {
        //pushes a new card, gets the question, answer and reason
        Card c = new Card();
        q = c.getQuestion();
        ans = c.getAnswer();
        r = c.getReason();
        if (!deck.isFull()) {
            deck.push(c);
            num++;
            showCard(c);
        }
    }

    public String RockAns() {
        //find what the rocks answer is. returns a string
        Dice dice = new Dice();
        int diceroll = dice.getValue();

        if (diceroll == ans) {
            Rpoints++;
            return "right";
        } else
            return "wrong";
    }

    public void load() {
        SharedPreferences HW = getApplicationContext().getSharedPreferences("name", Context.MODE_PRIVATE);
        namelength = HW.getInt("name", 0);

        //loads the username of the player
        try {
            FileInputStream in = openFileInput("data.txt");
            String display = "";
            for (int i = 0; i < namelength; i++) {
                int data = in.read();
                display += "" + convert(data) + "";
            }
            in.close();

            TextView words = (TextView) findViewById(R.id.user);
            words.setText(display);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convert(int d) {
        //used in the load method, the name is brought in as ascii, and here it is converted to a string
        String str = null;
        str = Character.toString((char) d);
        return str;

    }

    public void pop() {
        //if the box isn't empty
        if (!deck.isEmpty()) {
            Card c = (Card) deck.pop();
            num--;
            showCard(c);
        } else {
            //set num to 0
            num = 0;
        }
    }

    public void shuffle() {
        //the shuffle method is present, I just don't use it
        deck.clear();
        deck.shuffle();
        num = deck.size();
        Card c = (Card) deck.pop();
        showCard(c);
    }

    public void showCard(Card c) {
        //shows the cards question second on screen
        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Question: " + c.getQuestion());

    }

    private void startTimer() {
        //this method is used after a button is clicked, it starts a timer that once finished, changes the question again
        resetTimer();
        mCountDownTimer = new CountDownTimer(mTimerLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUnitlFinsihed) {
                mTimerLeftInMillis = millisUnitlFinsihed;
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                push();
                //The enable button is here because it was a bit glitchy when it was in the other methods
                enableB();
            }
        }.start();
        mTimerRunning = true;
    }

    public void changePoints() {
        //Used after every question, changes the points images at the top for both players. Also see if someone wins
        TextView question = (TextView) findViewById(R.id.question);
        ImageView i = (ImageView) findViewById(R.id.userscore);
        ImageView j = (ImageView) findViewById(R.id.rockscore);
        if (Hpoints == 1)
            i.setImageResource(R.drawable.onepoint);
        else if (Hpoints == 2)
            i.setImageResource(R.drawable.twopoint);
        if (Rpoints == 1)
            j.setImageResource(R.drawable.onepoint);
        else if (Rpoints == 2)
            j.setImageResource(R.drawable.twopoint);
        if (Rpoints == Hpoints && Hpoints == 3) {
            //CHECK IF THERE IS A TIE
            Hwedges++;
            Rwedges++;
            i.setImageResource(R.drawable.threepoint);
            j.setImageResource(R.drawable.twopoint);

            PutSP();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(GameScreen.this, WedgeScreen.class);
                    startActivity(i);
                }
            }, 4000);
        } else if (Rpoints == 3) {
            //CHECK IF ROCK WINS
            j.setImageResource(R.drawable.threepoint);
            Rwedges++;

            PutSP();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(GameScreen.this, WedgeScreen.class);
                    startActivity(i);
                }
            }, 4000);
        } else if (Hpoints == 3) {
            Hwedges++;
            PutSP();

            //CHECK IF HUMAN WINS
            i.setImageResource(R.drawable.threepoint);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(GameScreen.this, WedgeScreen.class);
                    startActivity(i);
                }
            }, 4000);
        }
    }

    public void PutSP() {
        //This method uses shared preferences at tells the wedge screen which player got the 3 points first
        SharedPreferences HW;
        HW = getSharedPreferences("HUMAN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = HW.edit();
        editor1.putInt("HumanWedge", Hwedges);
        editor1.commit();

        SharedPreferences RW;
        RW = getSharedPreferences("ROCK", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = RW.edit();
        editor2.putInt("RockWedge", Rwedges);
        editor2.commit();

    }

    public void Ans0(View view) {
        //Button View
        disableB();
        TextView question = (TextView) findViewById(R.id.question);
        if (ans == 0) {
            Hpoints++;
            question.setText("You got it right\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        } else {
            question.setText("You got it wrong, the answer is " + ans + "\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        }
        changePoints();

    }

    public void Ans1(View view) {
        //Button View
        disableB();
        TextView question = (TextView) findViewById(R.id.question);
        if (ans == 1) {
            Hpoints++;
            question.setText("You got it right\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        } else {
            question.setText("You got it wrong, the answer is " + ans + "\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        }
        changePoints();

    }


    public void Ans2(View view) {
        //Button View
        disableB();
        TextView question = (TextView) findViewById(R.id.question);
        if (ans == 2) {
            Hpoints++;
            question.setText("You got it right\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        } else {
            question.setText("You got it wrong, the answer is " + ans + "\n The reason is " + r + "\n The rock got it " + RockAns());
            startTimer();
        }
        changePoints();

    }

    public void disableB() {
        //Disables the button so the player doenst get extra points
        Button b0 = (Button) findViewById(R.id.b0);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        b0.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
    }

    public void enableB() {
        //enables the buttons for the user to interact with
        Button b0 = (Button) findViewById(R.id.b0);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
    }

    public void instuction(View view) {
        //EXTRA FEATURE: Dialog box that appears when the user clicks on the instructions button
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Instructions")
                //The message that will appear
                .setMessage("Welcome to Box o' Rocks. This is a game to test your ability in knowledge. You will be facing a box of rocks and answering trivia questions, trying to get them right. The questions will be presented on the cards at the front." +
                        "\nYou can click on the buttons to submit your response" +
                        "\nFor every question you get right, you get a point. You can look at your points at the top left corner of the screen" +
                        "\nFirst to get 3 points gets a wedge. The points then reset and you fight for a wedge again. First to 3 wedges wins the game, do you think you are up for the task?")
                //What to do if the button is pressed
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //do something if they click the button
//otherwise, it just dismisses the dialog
                    }
                }).show();

    }

    public void home(View view) {
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}

