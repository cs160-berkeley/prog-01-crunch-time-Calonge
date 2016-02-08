package com.example.ecalo.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayComputation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_computation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        Double workout_length = bundle.getDouble("length");
        String workout = bundle.getString("workout");
        String return_message = workout_equivalent(workout_length, workout);
        TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setText(return_message);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }
    public String workout_equivalent(Double amount, String workout) {
        Double jump, jog, pull, push, squat, leg, walk, swim, stair, plank,
                sit, cycle, calories_burned = 0.0;
        if (amount == null) {
            jump = jog = pull = push = squat = leg = walk = swim =
                stair = plank = sit = cycle = calories_burned;
        } else {
            switch (workout) {
                case ("jumping_jacks"):
                    calories_burned = amount * 10.0;
                    break;
                case ("jogging"):
                    calories_burned = amount * 8.34;
                    break;
                case ("pull_ups"):
                    calories_burned = amount;
                    break;
                case ("push_ups"):
                    calories_burned = amount / 3.5;
                    break;
                case ("squats"):
                    calories_burned = amount / 2.25;
                    break;
                case ("leg_lifts"):
                    calories_burned = amount * 4;
                    break;
                case ("walking"):
                    calories_burned = amount * 5;
                    break;
                case ("swimming"):
                    calories_burned = amount * 7.7;
                    break;
                case ("stair_climbing"):
                    calories_burned = amount * 6.67;
                    break;
                case ("plank"):
                    calories_burned = amount * 4;
                    break;
                case ("sit_ups"):
                    calories_burned = amount / 2;
                    break;
                case ("cycling"):
                    calories_burned = amount * 8.34;
                    break;
                case ("calories"):
                    calories_burned = amount;
                    break;
            }
            jump = calories_burned / 10; jog = cycle = (double) Math.round(calories_burned / 8.34);
            swim = (double) Math.round(calories_burned / 7.7); sit = calories_burned * 2;
            plank = leg = calories_burned / 4; pull = calories_burned; walk = calories_burned / 5;
            push = calories_burned * 3.5; squat = calories_burned * 2.25;
            stair = (double) Math.round(calories_burned / 6.67);
        }
        String full_message = "Calories: " + calories_burned + "\nJumping Jacks: " + jump
                + " min\n" + "Jogging: " + jog + " min\n" + "Situps: " + sit + " reps\n" +
                "Swimming: " + swim + " min\n" + "Plank: " + plank + " min\n" + "Pullups: "
                + pull + " reps\n" + "Squats: " + squat + " reps\n" + "Cycling: " + cycle +
                " min\n" + "Walking: " + walk + " min\n" + "Leg-lifts: " + leg + " min\n"
                + "Stair-Climbing: " + stair + " min\n" + "Pushups: " + push + " reps\n";
        return full_message;
    }
}
