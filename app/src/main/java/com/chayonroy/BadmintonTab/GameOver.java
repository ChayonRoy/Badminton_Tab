package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {


    String apl1, apl2, bpl1, bpl2, teamAscore,teamBscore;

    TextView teamAinfo,teamBinfo,teamApoint,teamBpoint;
    Button newmatch;
    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        teamAinfo = findViewById(R.id.teamAinfo);
        teamBinfo = findViewById(R.id.teamBinfo);
        teamApoint = findViewById(R.id.teamApoint);
        teamBpoint = findViewById(R.id.teamBpoint);
        newmatch = findViewById(R.id.newMatch);



        String p1a=getIntent().getStringExtra("pla1"); // Input Team A P1 name
        apl1=p1a;
        String p2a=getIntent().getStringExtra("pla2"); // Input Team A P2 name
        apl2=p2a;
        String p1b=getIntent().getStringExtra("plb1");// Input Team B P1 name
        bpl1=p1b;
        String p2b=getIntent().getStringExtra("plb2");// Input Team B P2 name
        bpl2=p2b;

        Intent i = getIntent();
        int val_a = i.getIntExtra("a",0); // Input Team A Score
        int val_b =i.getIntExtra("b",0);  // Input Team B Score


        teamAinfo.setText("Team A: "+ apl1 + " and " + apl2);
        teamBinfo.setText("Team B: "+ bpl1 + " and " + bpl2);
        teamApoint.setText(String.valueOf(val_a));
        teamBpoint.setText(String.valueOf(val_b));










    }
}