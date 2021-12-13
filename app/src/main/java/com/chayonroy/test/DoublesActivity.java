package com.chayonroy.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoublesActivity extends AppCompatActivity {

    Button pointa, pointb, undoa, undob, btn;

    TextView ascore, bscore, acenter, bcenter;
    TextView aplayer1,aplayer2,bpalayer1,bplayer2,teamA, teamB;
    int count_a, count_b;

    String pl1a, pl2a, pl1b, pl2b;
    CardView alft, aright, bleft, bright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles);

        pointa = findViewById(R.id.point_a);
        undoa=findViewById(R.id.undo_a);
        pointb=findViewById(R.id.point_b);
        undob=findViewById(R.id.undo_b);
        btn=findViewById(R.id.button);

        ascore =findViewById(R.id.ascore);
        bscore = findViewById(R.id.BScore);
        acenter=findViewById(R.id.ascorecen);
        bcenter=findViewById(R.id.bscorecen);

        teamA=findViewById(R.id.TeamA);
        teamB=findViewById(R.id.TeamB);

        aplayer1=findViewById(R.id.a_player_1);
        aplayer2=findViewById(R.id.a_player_2);
        alft=findViewById(R.id.a_lft_crt);
        aright=findViewById(R.id.a_rit_crt);

        String p1a=getIntent().getStringExtra("pla1");
        aplayer1.setText(p1a+"");
        pl1a=p1a;

        String p2a=getIntent().getStringExtra("pla2");
        aplayer2.setText(p2a+"");
        pl2a=p2a;
        teamA.setText("Team A: "+ p1a + " & "+p2a);
        teamB.setText("Team B: "+ p1a + " & "+p2a);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DoublesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        pointa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_a++;
                ascore.setText(count_a+"");
                acenter.setText(count_a+"");
                teama_lftcrt();
                teama_rtcrt();

            }
        });// Button Point_A
        undoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_a--;
                ascore.setText(count_a+"");
                acenter.setText(count_a+"");
                teama_rtcrt();
                teama_lftcrt();
            }
        });// Button undo A
        pointb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_b++;
                bscore.setText(count_b+"");
                bcenter.setText(count_b+"");

            }
        }); // Button Point_B

        undob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_b--;
                bscore.setText(count_b+"");
                bcenter.setText(count_b+"");
            }
        });



    }//onCreate

    public void teama_rtcrt()
    {

        if (count_a % 2==0)
        {
            aplayer1.setText(pl1a+"");
            aright.setCardBackgroundColor(Color.parseColor("#f65151"));
            alft.setCardBackgroundColor(Color.parseColor("#035409"));

        }
        else if (count_a % 2==1)
        {
            aplayer1.setText(pl2a+"");
            alft.setCardBackgroundColor(Color.parseColor("#f65151"));
            aright.setCardBackgroundColor(Color.parseColor("#035409"));

        }
    }// Player name change Function of A right cort
    public void teama_lftcrt()
    {

        if (count_a % 2==1)
        {
            aplayer2.setText(pl1a+"");

        }
        else if (count_a % 2==0)
        {
            aplayer2.setText(pl2a+"");
        }
    }// Player name change Function of A left cort
}// AppCompatActivity