package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DoublesActivity extends AppCompatActivity {

    Button pointa, pointb, undoa, undob, A_2nd_srv,B_2nd_srv, sound_play, game_over;
    ToggleButton sideout;

    TextView ascore, bscore, acenter, bcenter;
    TextView aplayer1,aplayer2,bplayer1,bplayer2,teamA, teamB;

    int count_a, count_b, clr_count_A, clr_count_B;
            int count_voice_A =1, count_voice_B =1;
    int play_sound_code = 1;

    String pl1a, pl2a, pl1b, pl2b;
    CardView alft, aright, blft, bright;
    MediaPlayer player_pointa,player_pointb,player,player2,player3,player4,player0a,player1a,player2a,player3a,player4a,player5a,player6a,player7a,player8a,player9a,player10a,player11a,
                player12a,player13a,player14a,player15a,player16a,player17a,player18a,player19a,player20a,player21a,player22a,player23a,player24a,player25a,
                player26a,player27a,player28a,player29a,player_ser_one,player_ser_two,player_ser_oneb,player_ser_twob,
                player0b,player1b,player2b,player3b,player4b,player5b,player6b,player7b,player8b,player9b,player10b,player11b,
                player12b,player13b,player14b,player15b,player16b,player17b,player18b,player19b,player20b,player21b,player22b,player23b,player24b,player25b,
                player26b,player27b,player28b,player29b,gameover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles);

        pointa = findViewById(R.id.point_a);
        undoa = findViewById(R.id.undo_a);
        pointb = findViewById(R.id.point_b);
        undob = findViewById(R.id.undo_b);
        A_2nd_srv = findViewById(R.id.button);
        B_2nd_srv = findViewById(R.id.B_2nd_service);
        sideout = findViewById(R.id.side_out);
        sound_play = findViewById(R.id.sound_play);
        game_over = findViewById(R.id.button3);

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
                if (player_pointa == null) {
                    player_pointa = MediaPlayer.create(DoublesActivity.this, R.raw.point);
                }
                player_pointa.start();


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
                if (player_pointb == null) {
                    player_pointb = MediaPlayer.create(DoublesActivity.this, R.raw.point);
                }
                player_pointb.start();


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
                count_voice_A = 2;
                cort_clr_A();
                service_no_a();
                // Intent intent= new Intent(DoublesActivity.this, MainActivity.class);
               // startActivity(intent);
                if (player == null) {
                    player = MediaPlayer.create(DoublesActivity.this, R.raw.second_service);
                }
                player.start();
            }
        });//....................................................Team A 2nd service

        B_2nd_srv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clr_count_B++;
                count_voice_B = 2;
                cort_clr_B();
                service_no_b();
                if (player2 == null) {
                    player2 = MediaPlayer.create(DoublesActivity.this, R.raw.second_service);
                }
                player2.start();
            }
        });//....................................................Team B 2nd service

        sideout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clr_count_A=0;
                    aright.setCardBackgroundColor(Color.parseColor("#035409"));
                    alft.setCardBackgroundColor(Color.parseColor("#035409"));
                    bright.setCardBackgroundColor(Color.parseColor("#f65151"));
                    if (player3 == null) {
                        player3 = MediaPlayer.create(DoublesActivity.this, R.raw.service_over);
                    }
                    player3.start();
                    count_voice_A = 1;
                    // --- side wise button enable and disable
                    pointa.setEnabled(false);
                    pointb.setEnabled(true);
                    undoa.setEnabled(false);
                    undob.setEnabled(true);
                    A_2nd_srv.setEnabled(false);
                    B_2nd_srv.setEnabled(true);
                    play_sound_code = 2;
                    service_no_a();

                } else {
                    clr_count_B=0;
                    blft.setCardBackgroundColor(Color.parseColor("#035409"));
                    bright.setCardBackgroundColor(Color.parseColor("#035409"));
                    aright.setCardBackgroundColor(Color.parseColor("#f65151"));
                    if (player4 == null) {
                        player4 = MediaPlayer.create(DoublesActivity.this, R.raw.service_over);
                    }
                    player4.start();
                    count_voice_B = 1;
                    // --- side wise button enable and disable
                    pointa.setEnabled(true);
                    pointb.setEnabled(false);
                    undoa.setEnabled(true);
                    undob.setEnabled(false);
                    A_2nd_srv.setEnabled(true);
                    B_2nd_srv.setEnabled(false);
                    play_sound_code = 1;
                    service_no_b();

                }
            }
        });

        sound_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play_sound_code == 1) {
                    sound_A_side();
                }
                else
                {
                    sound_B_side();
                }

            }
        });

        game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameover == null) {
                    gameover = MediaPlayer.create(DoublesActivity.this, R.raw.game_over);
                }
                gameover.start();

               // String ScoreA = String.valueOf(count_a);
               // String ScoreB = String.valueOf(count_b);


                Intent intent = new Intent(DoublesActivity.this,GameOver.class);
                intent.putExtra("pla1",pl1a);
                intent.putExtra("pla2",pl2a);
                intent.putExtra("plb1",pl1b);
                intent.putExtra("plb2",pl2b);
                intent.putExtra("a",count_a);
                intent.putExtra("b",count_b);
               // intent.putExtra("point_of_a",ScoreA);
                //intent.putExtra("point_of_b",ScoreB);
                startActivity(intent);

            }
        });



    }//..............End of onCreate

    public void teama_crtinfo()
    {

        if (count_a % 2==0)
        {
            aplayer1.setText(pl1a+"");
            aplayer2.setText(pl2a+"");
            // aright.setCardBackgroundColor(Color.parseColor("#f65151"));
            // alft.setCardBackgroundColor(Color.parseColor("#035409"));
        }
        else if (count_a % 2==1)
        {
            aplayer1.setText(pl2a+"");
            aplayer2.setText(pl1a+"");
            // alft.setCardBackgroundColor(Color.parseColor("#f65151"));
            // aright.setCardBackgroundColor(Color.parseColor("#035409"));
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

    // .... sound play function A side
    public void sound_A_side()
    {
        // first side point count
       switch (count_a){
           case 0:
               if (player0a == null) {
                   player0a = MediaPlayer.create(DoublesActivity.this, R.raw.zero);
               }
               player0a.start();
               break;
           case 1:
               if (player1a == null) {
                   player1a = MediaPlayer.create(DoublesActivity.this, R.raw.one);
               }
               player1a.start();
               break;
           case 2:
               if (player2a == null) {
                   player2a = MediaPlayer.create(DoublesActivity.this, R.raw.two);
               }
               player2a.start();
               break;
           case 3:
               if (player3a == null) {
                   player3a = MediaPlayer.create(DoublesActivity.this, R.raw.three);
               }
               player3a.start();
               break;
           case 4:
               if (player4a == null) {
                   player4a = MediaPlayer.create(DoublesActivity.this, R.raw.four);
               }
               player4a.start();
               break;
           case 5:
               if (player5a == null) {
                   player5a = MediaPlayer.create(DoublesActivity.this, R.raw.five);
               }
               player5a.start();
               break;
           case 6:
               if (player6a == null) {
                   player6a = MediaPlayer.create(DoublesActivity.this, R.raw.six);
               }
               player6a.start();
               break;
           case 7:
               if (player7a == null) {
                   player7a = MediaPlayer.create(DoublesActivity.this, R.raw.seven);
               }
               player7a.start();
               break;
           case 8:
               if (player8a == null) {
                   player8a = MediaPlayer.create(DoublesActivity.this, R.raw.eight);
               }
               player8a.start();
               break;
           case 9:
               if (player9a == null) {
                   player9a = MediaPlayer.create(DoublesActivity.this, R.raw.nine);
               }
               player9a.start();
               break;
           case 10:
               if (player10a == null) {
                   player10a = MediaPlayer.create(DoublesActivity.this, R.raw.ten);
               }
               player10a.start();
               break;
           case 11:
               if (player11a == null) {
                   player11a = MediaPlayer.create(DoublesActivity.this, R.raw.eleven);
               }
               player11a.start();
               break;
           case 12:
               if (player12a == null) {
                   player12a = MediaPlayer.create(DoublesActivity.this, R.raw.twelve);
               }
               player12a.start();
               break;
           case 13:
               if (player13a == null) {
                   player13a = MediaPlayer.create(DoublesActivity.this, R.raw.thirteen);
               }
               player13a.start();
               break;
           case 14:
               if (player14a == null) {
                   player14a = MediaPlayer.create(DoublesActivity.this, R.raw.fourteen);
               }
               player14a.start();
               break;
           case 15:
               if (player15a == null) {
                   player15a = MediaPlayer.create(DoublesActivity.this, R.raw.fifteen);
               }
               player15a.start();
               break;
           case 16:
               if (player16a == null) {
                   player16a = MediaPlayer.create(DoublesActivity.this, R.raw.sixteen);
               }
               player16a.start();
               break;
           case 17:
               if (player17a == null) {
                   player17a = MediaPlayer.create(DoublesActivity.this, R.raw.seventeen);
               }
               player17a.start();
               break;
           case 18:
               if (player18a == null) {
                   player18a = MediaPlayer.create(DoublesActivity.this, R.raw.eighteen);
               }
               player18a.start();
               break;
           case 19:
               if (player19a == null) {
                   player19a = MediaPlayer.create(DoublesActivity.this, R.raw.nineteen);
               }
               player19a.start();
               break;
           case 20:
               if (player20a == null) {
                   player20a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty);
               }
               player20a.start();
               break;
           case 21:
               if (player21a == null) {
                   player21a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_one);
               }
               player21a.start();
               break;
           case 22:
               if (player22a == null) {
                   player22a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_two);
               }
               player22a.start();
               break;
           case 23:
               if (player23a == null) {
                   player23a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_three);
               }
               player23a.start();
               break;
           case 24:
               if (player24a == null) {
                   player24a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_four);
               }
               player24a.start();
               break;
           case 25:
               if (player25a == null) {
                   player25a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_five);
               }
               player25a.start();
               break;
           case 26:
               if (player26a == null) {
                   player26a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_six);
               }
               player26a.start();
               break;
           case 27:
               if (player27a == null) {
                   player27a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_seven);
               }
               player27a.start();
               break;
           case 28:
               if (player28a == null) {
                   player28a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_eight);
               }
               player28a.start();
               break;
           case 29:
               if (player29a == null) {
                   player29a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_nine);
               }
               player29a.start();
               break;
       }

        // first or second service count
        if(count_voice_A == 1){
            if (player_ser_one == null) {
                player_ser_one = MediaPlayer.create(DoublesActivity.this, R.raw.service_one);
            }
            player_ser_one.start();
        }
        else{
            if (player_ser_two == null) {
                player_ser_two = MediaPlayer.create(DoublesActivity.this, R.raw.service_two);
            }
            player_ser_two.start();
        }


        // second side point count
        switch (count_b){
            case 0:
                if (player0b == null) {
                    player0b = MediaPlayer.create(DoublesActivity.this, R.raw.last_zero);
                }
                player0b.start();
                break;
            case 1:
                if (player1b == null) {
                    player1b = MediaPlayer.create(DoublesActivity.this, R.raw.last_one);
                }
                player1b.start();
                break;
            case 2:
                if (player2b == null) {
                    player2b = MediaPlayer.create(DoublesActivity.this, R.raw.last_two);
                }
                player2b.start();
                break;
            case 3:
                if (player3b == null) {
                    player3b = MediaPlayer.create(DoublesActivity.this, R.raw.last_three);
                }
                player3b.start();
                break;
            case 4:
                if (player4b == null) {
                    player4b = MediaPlayer.create(DoublesActivity.this, R.raw.last_four);
                }
                player4b.start();
                break;
            case 5:
                if (player5b == null) {
                    player5b = MediaPlayer.create(DoublesActivity.this, R.raw.last_five);
                }
                player5b.start();
                break;
            case 6:
                if (player6b == null) {
                    player6b = MediaPlayer.create(DoublesActivity.this, R.raw.last_six);
                }
                player6b.start();
                break;
            case 7:
                if (player7b == null) {
                    player7b = MediaPlayer.create(DoublesActivity.this, R.raw.last_seven);
                }
                player7b.start();
                break;
            case 8:
                if (player8b == null) {
                    player8b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eight);
                }
                player8b.start();
                break;
            case 9:
                if (player9b == null) {
                    player9b = MediaPlayer.create(DoublesActivity.this, R.raw.last_nine);
                }
                player9b.start();
                break;
            case 10:
                if (player10b == null) {
                    player10b = MediaPlayer.create(DoublesActivity.this, R.raw.last_ten);
                }
                player10b.start();
                break;
            case 11:
                if (player11b == null) {
                    player11b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eleven);
                }
                player11b.start();
                break;
            case 12:
                if (player12b == null) {
                    player12b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twelve);
                }
                player12b.start();
                break;
            case 13:
                if (player13b == null) {
                    player13b = MediaPlayer.create(DoublesActivity.this, R.raw.last_thirteen);
                }
                player13b.start();
                break;
            case 14:
                if (player14b == null) {
                    player14b = MediaPlayer.create(DoublesActivity.this, R.raw.last_fourteen);
                }
                player14b.start();
                break;
            case 15:
                if (player15b == null) {
                    player15b = MediaPlayer.create(DoublesActivity.this, R.raw.last_fifteen);
                }
                player15b.start();
                break;
            case 16:
                if (player16b == null) {
                    player16b = MediaPlayer.create(DoublesActivity.this, R.raw.last_sixteen);
                }
                player16b.start();
                break;
            case 17:
                if (player17b == null) {
                    player17b = MediaPlayer.create(DoublesActivity.this, R.raw.last_seventeen);
                }
                player17b.start();
                break;
            case 18:
                if (player18b == null) {
                    player18b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eighteen);
                }
                player18b.start();
                break;
            case 19:
                if (player19b == null) {
                    player19b = MediaPlayer.create(DoublesActivity.this, R.raw.last_ninteen);
                }
                player19b.start();
                break;
            case 20:
                if (player20b == null) {
                    player20b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty);
                }
                player20b.start();
                break;
            case 21:
                if (player21b == null) {
                    player21b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_one);
                }
                player21b.start();
                break;
            case 22:
                if (player22b == null) {
                    player22b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_two);
                }
                player22b.start();
                break;
            case 23:
                if (player23b == null) {
                    player23b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_three);
                }
                player23b.start();
                break;
            case 24:
                if (player24b == null) {
                    player24b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_four);
                }
                player24b.start();
                break;
            case 25:
                if (player25b == null) {
                    player25b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_five);
                }
                player25b.start();
                break;
            case 26:
                if (player26b == null) {
                    player26b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_six);
                }
                player26b.start();
                break;
            case 27:
                if (player27b == null) {
                    player27b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_seven);
                }
                player27b.start();
                break;
            case 28:
                if (player28b == null) {
                    player28b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_eight);
                }
                player28b.start();
                break;
            case 29:
                if (player29b == null) {
                    player29b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_nine);
                }
                player29b.start();
                break;
        }

    }

    // .... sound play function B side


    public void sound_B_side()
    {
        // first side point count
        switch (count_b){
            case 0:
                if (player0a == null) {
                    player0a = MediaPlayer.create(DoublesActivity.this, R.raw.zero);
                }
                player0a.start();
                break;
            case 1:
                if (player1a == null) {
                    player1a = MediaPlayer.create(DoublesActivity.this, R.raw.one);
                }
                player1a.start();
                break;
            case 2:
                if (player2a == null) {
                    player2a = MediaPlayer.create(DoublesActivity.this, R.raw.two);
                }
                player2a.start();
                break;
            case 3:
                if (player3a == null) {
                    player3a = MediaPlayer.create(DoublesActivity.this, R.raw.three);
                }
                player3a.start();
                break;
            case 4:
                if (player4a == null) {
                    player4a = MediaPlayer.create(DoublesActivity.this, R.raw.four);
                }
                player4a.start();
                break;
            case 5:
                if (player5a == null) {
                    player5a = MediaPlayer.create(DoublesActivity.this, R.raw.five);
                }
                player5a.start();
                break;
            case 6:
                if (player6a == null) {
                    player6a = MediaPlayer.create(DoublesActivity.this, R.raw.six);
                }
                player6a.start();
                break;
            case 7:
                if (player7a == null) {
                    player7a = MediaPlayer.create(DoublesActivity.this, R.raw.seven);
                }
                player7a.start();
                break;
            case 8:
                if (player8a == null) {
                    player8a = MediaPlayer.create(DoublesActivity.this, R.raw.eight);
                }
                player8a.start();
                break;
            case 9:
                if (player9a == null) {
                    player9a = MediaPlayer.create(DoublesActivity.this, R.raw.nine);
                }
                player9a.start();
                break;
            case 10:
                if (player10a == null) {
                    player10a = MediaPlayer.create(DoublesActivity.this, R.raw.ten);
                }
                player10a.start();
                break;
            case 11:
                if (player11a == null) {
                    player11a = MediaPlayer.create(DoublesActivity.this, R.raw.eleven);
                }
                player11a.start();
                break;
            case 12:
                if (player12a == null) {
                    player12a = MediaPlayer.create(DoublesActivity.this, R.raw.twelve);
                }
                player12a.start();
                break;
            case 13:
                if (player13a == null) {
                    player13a = MediaPlayer.create(DoublesActivity.this, R.raw.thirteen);
                }
                player13a.start();
                break;
            case 14:
                if (player14a == null) {
                    player14a = MediaPlayer.create(DoublesActivity.this, R.raw.fourteen);
                }
                player14a.start();
                break;
            case 15:
                if (player15a == null) {
                    player15a = MediaPlayer.create(DoublesActivity.this, R.raw.fifteen);
                }
                player15a.start();
                break;
            case 16:
                if (player16a == null) {
                    player16a = MediaPlayer.create(DoublesActivity.this, R.raw.sixteen);
                }
                player16a.start();
                break;
            case 17:
                if (player17a == null) {
                    player17a = MediaPlayer.create(DoublesActivity.this, R.raw.seventeen);
                }
                player17a.start();
                break;
            case 18:
                if (player18a == null) {
                    player18a = MediaPlayer.create(DoublesActivity.this, R.raw.eighteen);
                }
                player18a.start();
                break;
            case 19:
                if (player19a == null) {
                    player19a = MediaPlayer.create(DoublesActivity.this, R.raw.nineteen);
                }
                player19a.start();
                break;
            case 20:
                if (player20a == null) {
                    player20a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty);
                }
                player20a.start();
                break;
            case 21:
                if (player21a == null) {
                    player21a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_one);
                }
                player21a.start();
                break;
            case 22:
                if (player22a == null) {
                    player22a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_two);
                }
                player22a.start();
                break;
            case 23:
                if (player23a == null) {
                    player23a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_three);
                }
                player23a.start();
                break;
            case 24:
                if (player24a == null) {
                    player24a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_four);
                }
                player24a.start();
                break;
            case 25:
                if (player25a == null) {
                    player25a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_five);
                }
                player25a.start();
                break;
            case 26:
                if (player26a == null) {
                    player26a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_six);
                }
                player26a.start();
                break;
            case 27:
                if (player27a == null) {
                    player27a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_seven);
                }
                player27a.start();
                break;
            case 28:
                if (player28a == null) {
                    player28a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_eight);
                }
                player28a.start();
                break;
            case 29:
                if (player29a == null) {
                    player29a = MediaPlayer.create(DoublesActivity.this, R.raw.twenty_nine);
                }
                player29a.start();
                break;
        }

        // first or second service count
        if(count_voice_B  == 1){
            if (player_ser_oneb == null) {
                player_ser_oneb = MediaPlayer.create(DoublesActivity.this, R.raw.service_one);
            }
            player_ser_oneb.start();
        }
        else{
            if (player_ser_twob == null) {
                player_ser_twob = MediaPlayer.create(DoublesActivity.this, R.raw.service_two);
            }
            player_ser_twob.start();
        }


        // second side point count
        switch (count_a){
            case 0:
                if (player0b == null) {
                    player0b = MediaPlayer.create(DoublesActivity.this, R.raw.last_zero);
                }
                player0b.start();
                break;
            case 1:
                if (player1b == null) {
                    player1b = MediaPlayer.create(DoublesActivity.this, R.raw.last_one);
                }
                player1b.start();
                break;
            case 2:
                if (player2b == null) {
                    player2b = MediaPlayer.create(DoublesActivity.this, R.raw.last_two);
                }
                player2b.start();
                break;
            case 3:
                if (player3b == null) {
                    player3b = MediaPlayer.create(DoublesActivity.this, R.raw.last_three);
                }
                player3b.start();
                break;
            case 4:
                if (player4b == null) {
                    player4b = MediaPlayer.create(DoublesActivity.this, R.raw.last_four);
                }
                player4b.start();
                break;
            case 5:
                if (player5b == null) {
                    player5b = MediaPlayer.create(DoublesActivity.this, R.raw.last_five);
                }
                player5b.start();
                break;
            case 6:
                if (player6b == null) {
                    player6b = MediaPlayer.create(DoublesActivity.this, R.raw.last_six);
                }
                player6b.start();
                break;
            case 7:
                if (player7b == null) {
                    player7b = MediaPlayer.create(DoublesActivity.this, R.raw.last_seven);
                }
                player7b.start();
                break;
            case 8:
                if (player8b == null) {
                    player8b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eight);
                }
                player8b.start();
                break;
            case 9:
                if (player9b == null) {
                    player9b = MediaPlayer.create(DoublesActivity.this, R.raw.last_nine);
                }
                player9b.start();
                break;
            case 10:
                if (player10b == null) {
                    player10b = MediaPlayer.create(DoublesActivity.this, R.raw.last_ten);
                }
                player10b.start();
                break;
            case 11:
                if (player11b == null) {
                    player11b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eleven);
                }
                player11b.start();
                break;
            case 12:
                if (player12b == null) {
                    player12b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twelve);
                }
                player12b.start();
                break;
            case 13:
                if (player13b == null) {
                    player13b = MediaPlayer.create(DoublesActivity.this, R.raw.last_thirteen);
                }
                player13b.start();
                break;
            case 14:
                if (player14b == null) {
                    player14b = MediaPlayer.create(DoublesActivity.this, R.raw.last_fourteen);
                }
                player14b.start();
                break;
            case 15:
                if (player15b == null) {
                    player15b = MediaPlayer.create(DoublesActivity.this, R.raw.last_fifteen);
                }
                player15b.start();
                break;
            case 16:
                if (player16b == null) {
                    player16b = MediaPlayer.create(DoublesActivity.this, R.raw.last_sixteen);
                }
                player16b.start();
                break;
            case 17:
                if (player17b == null) {
                    player17b = MediaPlayer.create(DoublesActivity.this, R.raw.last_seventeen);
                }
                player17b.start();
                break;
            case 18:
                if (player18b == null) {
                    player18b = MediaPlayer.create(DoublesActivity.this, R.raw.last_eighteen);
                }
                player18b.start();
                break;
            case 19:
                if (player19b == null) {
                    player19b = MediaPlayer.create(DoublesActivity.this, R.raw.last_ninteen);
                }
                player19b.start();
                break;
            case 20:
                if (player20b == null) {
                    player20b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty);
                }
                player20b.start();
                break;
            case 21:
                if (player21b == null) {
                    player21b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_one);
                }
                player21b.start();
                break;
            case 22:
                if (player22b == null) {
                    player22b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_two);
                }
                player22b.start();
                break;
            case 23:
                if (player23b == null) {
                    player23b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_three);
                }
                player23b.start();
                break;
            case 24:
                if (player24b == null) {
                    player24b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_four);
                }
                player24b.start();
                break;
            case 25:
                if (player25b == null) {
                    player25b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_five);
                }
                player25b.start();
                break;
            case 26:
                if (player26b == null) {
                    player26b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_six);
                }
                player26b.start();
                break;
            case 27:
                if (player27b == null) {
                    player27b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_seven);
                }
                player27b.start();
                break;
            case 28:
                if (player28b == null) {
                    player28b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_eight);
                }
                player28b.start();
                break;
            case 29:
                if (player29b == null) {
                    player29b = MediaPlayer.create(DoublesActivity.this, R.raw.last_twenty_nine);
                }
                player29b.start();
                break;
        }

    }

    public void service_no_a()
    {
        if (count_voice_A == 1)
        {
            A_2nd_srv.setText("1st Service");
            A_2nd_srv.setBackgroundResource(R.drawable.btn_bg_new);
        }
        else
        {
            A_2nd_srv.setText("2nd Service");
            A_2nd_srv.setBackgroundResource(R.drawable.btn_bg_new_2);
        }
    }
    public void service_no_b()
    {
        if (count_voice_B == 1)
        {
            B_2nd_srv.setText("1st Service");
            B_2nd_srv.setBackgroundResource(R.drawable.btn_bg_new);
        }
        else
        {
            B_2nd_srv.setText("2nd Service");
            B_2nd_srv.setBackgroundResource(R.drawable.btn_bg_new_2);
        }
    }


}// AppCompatActivity