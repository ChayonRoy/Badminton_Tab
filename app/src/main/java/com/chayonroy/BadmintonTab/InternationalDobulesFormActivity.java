package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class InternationalDobulesFormActivity extends AppCompatActivity {
    Button start;
    EditText apl1,apl2,bpl1,bpl2;
    CheckBox servA, servB;
    int serveA = 0, serveB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_dobules_form);
        apl1=findViewById(R.id.aplayer1);
        apl2=findViewById(R.id.aplayer2);
        bpl1=findViewById(R.id.bplayer1);
        bpl2=findViewById(R.id.bplayer2);

        servA=findViewById(R.id.checkBoxA);
        servB=findViewById(R.id.checkBoxB);
        start=findViewById(R.id.StartMatch);

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
                String p2a=apl2.getText().toString();
                String p1b=bpl1.getText().toString();
                String p2b=bpl2.getText().toString();

                Intent intent = new Intent(InternationalDobulesFormActivity.this,InternationalDoublesActivity.class);
                intent.putExtra("pla1",p1a);
                intent.putExtra("pla2",p2a);
                intent.putExtra("plb1",p1b);
                intent.putExtra("plb2",p2b);
                intent.putExtra("serveA",serveA);
                intent.putExtra("serveB",serveB);
                startActivity(intent);
            }
        });// Button Start Match

    }
}