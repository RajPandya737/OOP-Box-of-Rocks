//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: To roll 2 rocks to create a value for the bot
package com.example.pandyarajbor;

public class Dice {
    //Value instance variable that calculates the rock roll
    private int value;


    public Dice() {
        //each rand gives a value of 0 or 1; the total is the value instance variable
        int rand1 = (int) (Math.random() * 2);
        int rand2 = (int) (Math.random() * 2);
        value = rand1 + rand2;
    }

    public Dice(int v) {
        //dafault constructor
        value = v;
    }

    public int getValue() {
        //access the value number
        return value;
    }

    public void setValue(int v) {
        //mutate the Value number
        value = v;
    }

    public boolean equals(Dice r) {
        //Facilitator - check if the values are the same
        if (r.getValue() == value) {
            return true;
        } else
            return false;
    }

    public int compareTo(Dice r) {
        //Facilitator that compares 2 values
        if (r.equals(this))
            return 0;
        else if (r.value > this.value)
            return -1;
        else
            return 1;

    }

    public String toString() {
        //toString method that returns the value in a string
        return "The Rocks chose " + value;
    }
}
