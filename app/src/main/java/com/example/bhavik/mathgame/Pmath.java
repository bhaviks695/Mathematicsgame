package com.example.bhavik.mathgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Pmath extends AppCompatActivity {

    TextView number1, number2,hscore;
    EditText answer;
    private int a, b;
    private int correctanswer;
    private int d=10;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmath);

        number1 = (TextView) findViewById(R.id.text1);
        number2 = (TextView) findViewById(R.id.text2);
        hscore = (TextView) findViewById(R.id.highscore);

        answer = (EditText) findViewById(R.id.ans);

        setques();
        hscore.setText(String.valueOf(0));

    }

    public void setques(){
        Random r = new Random();

        a = Math.abs(r.nextInt() % d );
        number1.setText(String.valueOf(a));

        b = Math.abs(r.nextInt() % d);
        number2.setText(String.valueOf(b));

        correctanswer = a * b;
    }


    public void submit(View v){
        //get answer form user and check if its correct
        String c = answer.getText().toString().trim();

        if(c.isEmpty()){
            answer.setError("Please enter an answer");
            return;
        }

        int getans = Integer.parseInt(c);

        if(getans==correctanswer){

            MediaPlayer correct = MediaPlayer.create(Pmath.this,R.raw.correctbuzzer);
            correct.start();
            Toast.makeText(Pmath.this,"Your answer is correct",Toast.LENGTH_SHORT).show();
            d+=1;
            score+=2;
            hscore.setText(String.valueOf(score));

      }
      else
      {
          MediaPlayer wrong = MediaPlayer.create(Pmath.this,R.raw.wrongbuzzer);
          wrong.start();

          Toast.makeText(Pmath.this,"Game over",Toast.LENGTH_SHORT).show();

          Intent intent=new Intent(Pmath.this,Result.class);
          intent.putExtra("SCORE", score);
          startActivity(intent);

          finish();
      }

      answer.setText(null);
      setques();

    }
}
