//Name: Raj Pandya
//Date: Friday 14 2022
//Purpose: Get the user's name

package com.example.pandyarajbor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void check(View view) {
        //When the user clicks the button, there name is saved to a variable, converted to ascii, and saved to a file
        EditText et = (EditText) findViewById(R.id.name);
        String word = et.getText().toString();

        int size = word.length();

        SharedPreferences HW;
        HW = getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = HW.edit();
        editor1.putInt("name", size);
        editor1.commit();


        int asc[] = new int[word.length() + 1];

        for (int i = 0; i < word.length(); i++) {
            asc[i] = (int) word.charAt(i);
        }
        try {
            FileOutputStream out = openFileOutput("data.txt", Activity.MODE_PRIVATE);
            for (int i = 0; i < asc.length; i++) {
                out.write(asc[i]);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //take you to the game screen
        Intent i = new Intent(this, GameScreen.class);
        startActivity(i);
    }
}