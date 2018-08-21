package com.example.bhavik.mathgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId () == R.id.rules){
            Toast.makeText(this,"Rules was selected", Toast.LENGTH_SHORT) .show();
        Intent intent = new Intent (MainActivity.this,rules.class);
        startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
        public void play(View v){
        Intent intent = new Intent(this,Pmath.class);
        startActivity(intent);
        finish();

        }
    public void quit(View v) {
       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
       builder.setMessage("Are you sure you want to quit the game");
       builder.setCancelable(false);
       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               finish();
           }
       });
       builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
           }
       });
       AlertDialog alert = builder.create();
       alert.show();
    }
    public void highscore(View v){

     Toast.makeText(MainActivity.this,"High score selected", Toast.LENGTH_SHORT).show();
     Intent intent = new Intent(MainActivity.this,Score.class);
     startActivity(intent);
     finish();

    }
}
