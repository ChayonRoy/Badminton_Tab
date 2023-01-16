package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoublesChoiceActivity extends AppCompatActivity {
    Button internationalMatch, localMatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles_choice);
        internationalMatch=findViewById(R.id.International);
        localMatch=findViewById(R.id.Local);


        internationalMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DoublesChoiceActivity.this,InternationalDobulesFormActivity.class);
                startActivity(intent);
            }
        });
        localMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DoublesChoiceActivity.this,DoublesFormActivity.class);
                startActivity(intent);
            }
        });
    }
}// AppCompatActivity