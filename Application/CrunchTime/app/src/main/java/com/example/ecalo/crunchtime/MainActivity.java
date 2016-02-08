package com.example.ecalo.crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public String workout;
    public boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void compute (View view) {
        if (checked) {
            Intent intent = new Intent(this, DisplayComputation.class);
            EditText editText = (EditText) findViewById(R.id.number_input);
            String number = editText.getText().toString();
            Bundle info = new Bundle(2);
            Double length;
            if (number != null) {
                length = Double.parseDouble(number);
            } else {
                length = 0.0;
            }
            info.putString("workout", workout);
            info.putDouble("length", length);
            intent.putExtra("bundle", info);
            startActivity(intent);
        }
    }

    public void onClick (View view) {
        checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.jumping_jacks_id:
                if (checked)
                    workout="jumping_jacks";
                    break;
            case R.id.jogging_id:
                if (checked)
                    workout="jogging";
                    break;
            case R.id.pull_ups_id:
                if (checked)
                    workout="pull_ups";
                    break;
            case R.id.push_ups_id:
                if (checked)
                    workout="push_ups";
                    break;
            case R.id.squats_id:
                if (checked)
                    workout="squats";
                    break;
            case R.id.leg_lifts_id:
                if (checked)
                    workout="leg_lifts";
                    break;
            case R.id.walking_id:
                if (checked)
                    workout="walking";
                    break;
            case R.id.swimming_id:
                if (checked)
                    workout="swimming";
                    break;
            case R.id.stair_climbing_id:
                if (checked)
                    workout="stair_climbing";
                    break;
            case R.id.plank_id:
                if (checked)
                    workout="plank";
                    break;
            case R.id.sit_ups_id:
                if (checked)
                    workout="sit_ups";
                    break;
            case R.id.cycling_id:
                if (checked)
                    workout="cycling";
                    break;
            case R.id.calories_id:
                if (checked)
                    workout="calories";
                    break;
        }
    }
}
