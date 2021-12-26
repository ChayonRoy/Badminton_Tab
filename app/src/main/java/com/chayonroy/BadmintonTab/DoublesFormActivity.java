package com.chayonroy.BadmintonTab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DoublesFormActivity extends AppCompatActivity {
Button start;
EditText apl1,apl2,bpl1,bpl2;
CheckBox servA, servB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles_form);

        apl1=findViewById(R.id.aplayer1);
        apl2=findViewById(R.id.aplayer2);
        bpl1=findViewById(R.id.bplayer1);
        bpl2=findViewById(R.id.bplayer2);

        servA=findViewById(R.id.checkBoxA);
        servB=findViewById(R.id.checkBoxB);
        start=findViewById(R.id.StartMatch);






        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1a=apl1.getText().toString();
                String p2a=apl2.getText().toString();
                String p1b=bpl1.getText().toString();
                String p2b=bpl2.getText().toString();

                Intent intent = new Intent(DoublesFormActivity.this,DoublesActivity.class);
                intent.putExtra("pla1",p1a);
                intent.putExtra("pla2",p2a);
                intent.putExtra("plb1",p1b);
                intent.putExtra("plb2",p2b);
                startActivity(intent);
            }
        });// Button Start Match
    }
}