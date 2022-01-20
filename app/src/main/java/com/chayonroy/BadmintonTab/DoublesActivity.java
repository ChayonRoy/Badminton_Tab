package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DoublesActivity extends AppCompatActivity {

    Button pointa, pointb, undoa, undob, A_2nd_srv,B_2nd_srv;
    ToggleButton sideout;

    TextView ascore, bscore, acenter, bcenter;
    TextView aplayer1,aplayer2,bplayer1,bplayer2,teamA, teamB;

    int count_a, count_b, clr_count_A, clr_count_B;

    String pl1a, pl2a, pl1b, pl2b;
    CardView alft, aright, blft, bright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles);

        pointa = findViewById(R.id.point_a);
        undoa=findViewById(R.id.undo_a);
        pointb=findViewById(R.id.point_b);
        undob=findViewById(R.id.undo_b);
        A_2nd_srv=findViewById(R.id.button);
        B_2nd_srv=findViewById(R.id.B_2nd_service);
        sideout=findViewById(R.id.side_out);

        ascore =findViewById(R.id.ascore);
        bscore = findViewById(R.id.BScore);
        acenter=findViewById(R.id.ascorecen);
        bcenter=findViewById(R.id.bscorecen);

        teamA=findViewById(R.id.TeamA);
        teamB=findViewById(R.id.TeamB);

        aplayer1=findViewById(R.id.a_player_1);
        aplayer2=findViewById(R.id.a_player_2);
        bplayer1=findViewById(R.id.b_player_1);
        bplayer2=findViewById(R.id.b_player_2);
        alft=findViewById(R.id.a_lft_crt);
        aright=findViewById(R.id.a_rit_crt);
        blft=findViewById(R.id.b_lft_crt);
        bright=findViewById(R.id.b_rit_crt);

        String p1a=getIntent().getStringExtra("pla1"); // Input Team A P1 name
        aplayer1.setText(p1a+"");
        pl1a=p1a;

        String p2a=getIntent().getStringExtra("pla2"); // Input Team A P2 name
        aplayer2.setText(p2a+"");
        pl2a=p2a;

        String p1b=getIntent().getStringExtra("plb1");// Input Team B P1 name
        bplayer1.setText(p1b+"");
        pl1b=p1b;

        String p2b=getIntent().getStringExtra("plb2");// Input Team B P2 name
        bplayer2.setText(p2b+"");
        pl2b=p2b;

        teamA.setText("Team A: "+ p1a + " & "+p2a);
        teamB.setText("Team B: "+ p1b + " & "+p2b);




        pointa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_a++;
                clr_count_A++;
                ascore.setText(count_a+"");
                acenter.setText(count_a+"");
                teama_crtinfo();
                cort_clr_A();

            }
        });// ...................................................Button Point A
        undoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_a--;
                clr_count_A--;
                ascore.setText(count_a+"");
                acenter.setText(count_a+"");
                teama_crtinfo();
                cort_clr_A();

            }
        });// ....................................................Button undo A
        pointb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_b++;
                clr_count_B++;
                bscore.setText(count_b+"");
                bcenter.setText(count_b+"");
                teamb_crtinfo();
                cort_clr_B();

            }
        }); // ..................................................Button Point B

        undob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_b--;
                clr_count_B--;
                bscore.setText(count_b+"");
                bcenter.setText(count_b+"");
                teamb_crtinfo();
                cort_clr_B();
            }
        });// ....................................................Button undo B

        A_2nd_srv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clr_count_A++;
                cort_clr_A();
                // Intent intent= new Intent(DoublesActivity.this, MainActivity.class);
               // startActivity(intent);
            }
        });//....................................................Team A 2nd service

        B_2nd_srv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clr_count_B++;
                cort_clr_B();
            }
        });//....................................................Team B 2nd service

        sideout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clr_count_A=0;
                    aright.setCardBackgroundColor(Color.parseColor("#035409"));
                    alft.setCardBackgroundColor(Color.parseColor("#035409"));
                    bright.setCardBackgroundColor(Color.parseColor("#f65151"));
                } else {
                    clr_count_B=0;
                    blft.setCardBackgroundColor(Color.parseColor("#035409"));
                    bright.setCardBackgroundColor(Color.parseColor("#035409"));
                    aright.setCardBackgroundColor(Color.parseColor("#f65151"));
                }
            }
        });



    }//..............End of onCreate

    public void teama_crtinfo()
    {

        if (count_a % 2==0)
        {
            aplayer1.setText(pl1a+"");
            aplayer2.setText(pl2a+"");
            //aright.setCardBackgroundColor(Color.parseColor("#f65151"));
            //alft.setCardBackgroundColor(Color.parseColor("#035409"));
        }
        else if (count_a % 2==1)
        {
            aplayer1.setText(pl2a+"");
            aplayer2.setText(pl1a+"");
            //alft.setCardBackgroundColor(Color.parseColor("#f65151"));
            //aright.setCardBackgroundColor(Color.parseColor("#035409"));
        }
    }// ................................Player name change Function of Team A

    public void cort_clr_A()
    {
        if (clr_count_A % 2==0) {
            aright.setCardBackgroundColor(Color.parseColor("#f65151"));
            alft.setCardBackgroundColor(Color.parseColor("#035409"));
        }
        else if(clr_count_A % 2==1)
        {
            alft.setCardBackgroundColor(Color.parseColor("#f65151"));
            aright.setCardBackgroundColor(Color.parseColor("#035409"));
        }
    }//......................................cort color change by point.

    public void teamb_crtinfo()
    {

        if (count_b % 2==0)
        {
            bplayer1.setText(pl1b+"");
            bplayer2.setText(pl2b+"");
           // bright.setCardBackgroundColor(Color.parseColor("#f65151"));
            //blft.setCardBackgroundColor(Color.parseColor("#035409"));
        }
        else if (count_b % 2==1)
        {
            bplayer1.setText(pl2b+"");
            bplayer2.setText(pl1b+"");
           // blft.setCardBackgroundColor(Color.parseColor("#f65151"));
           // bright.setCardBackgroundColor(Color.parseColor("#035409"));
        }
    }// ................................Player name change Function of Team B
    public void cort_clr_B()
    {
        if (clr_count_B % 2==0) {
            bright.setCardBackgroundColor(Color.parseColor("#f65151"));
            blft.setCardBackgroundColor(Color.parseColor("#035409"));
        }
        else if(clr_count_B % 2==1)
        {
            blft.setCardBackgroundColor(Color.parseColor("#f65151"));
            bright.setCardBackgroundColor(Color.parseColor("#035409"));
        }
    }//......................................cort color change by point.

}// AppCompatActivity