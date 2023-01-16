package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SingleFormActivity extends AppCompatActivity {
    Button start;
    EditText apl1,bpl1;
    CheckBox servA, servB;
    int serveA = 0, serveB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_form); apl1=findViewById(R.id.aplayer1);
        apl1 = findViewById(R.id.aplayer1);
        bpl1=findViewById(R.id.bplayer1);
        start=findViewById(R.id.StartMatch);
        servA = findViewById(R.id.checkBoxA);
        servB = findViewById(R.id.checkBoxB);



         servA.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (servA.isChecked())
                 {
                     serveA = 1;
                     servB.setChecked(false);
                 }

             }
         });
         servB.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (servB.isChecked())
                 {
                     serveB = 1;
                     servA.setChecked(false);
                 }

             }
         });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1a=apl1.getText().toString();

                String p1b=bpl1.getText().toString();

                Intent intent = new Intent(SingleFormActivity.this,SinglesActivity.class);
                intent.putExtra("pla1",p1a);

                intent.putExtra("plb1",p1b);

                intent.putExtra("serveA",serveA);
                intent.putExtra("serveB",serveB);

                startActivity(intent);
            }
        });// Button Start Match
    }


}