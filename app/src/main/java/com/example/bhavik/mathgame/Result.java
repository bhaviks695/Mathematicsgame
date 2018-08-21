package com.example.bhavik.mathgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scorelabel = (TextView) findViewById(R.id.score);

       TextView Highscorelabel = (TextView) findViewById(R.id.hscore);

    int score = getIntent().getIntExtra("SCORE",0);
    scorelabel.setText("Score: " +score + "");

        SharedPreferences settings = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        int highscore = settings.getInt("HIGH_SCORE", 0);

        if(score>highscore){

            Highscorelabel.setText("High Score : " + score + "");

            //update the high score
          SharedPreferences.Editor editor = settings.edit();
           editor.putInt("HIGH_SCORE", score);
           editor.commit();
        }
       else {
           Highscorelabel.setText("High Score : " + highscore + "");
       }

    }

    public void tryagain(View v){
        Intent intent = new Intent(Result.this,Pmath.class);
        startActivity(intent);
        finish();
    }

    public void home(View v){
        Intent intent = new Intent(Result.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
