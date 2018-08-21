package com.example.bhavik.mathgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView Highscore = (TextView) findViewById(R.id.hhsccore);

        SharedPreferences settings = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        int highscore = settings.getInt("HIGH_SCORE", 0);

        Highscore.setText("HighScore: " + highscore + "");
    }

    public void back(View v){

        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
