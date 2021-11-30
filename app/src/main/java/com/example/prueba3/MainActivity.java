package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button resultado,votacion;
    RadioButton Nulo,boric,Kast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = (Button) findViewById(R.id.button2);
        votacion = (Button) findViewById(R.id.button);
        Nulo = (RadioButton) findViewById(R.id.radioButton4);
        boric = (RadioButton) findViewById(R.id.radioButton5);
        Kast = (RadioButton) findViewById(R.id.radioButton6);



        votacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer Totalenblanco = 0, TotalVotoNulo = 0, TotalBoric = 0, TotalKast = 0;
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db = conn.getReadableDatabase();
                ContentValues CV = new ContentValues();

                Cursor C = db.query("voto", null, null, null, null, null, null);
                if (C != null) ;
                {
                    if(C.moveToFirst())
                    {
                        do{
                            if(!Nulo.isChecked() && !boric.isChecked() && !Kast.isChecked()){
                                Toast.makeText(getApplicationContext(),"USTED VOTARA EN BLANCO",Toast.LENGTH_SHORT).show();
                                Totalenblanco++;
                                CV.put("1",Totalenblanco);
                            }
                            if(Nulo.isChecked())
                            {
                                TotalVotoNulo++;
                                CV.put("2",TotalVotoNulo);
                            }
                            if(boric.isChecked())
                            {
                                TotalBoric++;
                                CV.put("3",TotalBoric);
                            }
                            if(Kast.isChecked())

                            {
                                TotalKast++;
                                CV.put("4",TotalKast);
                            }

                            db.insert("voto",null,CV);
                        }
                        while(C.moveToNext());
                    }
                }

                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);
            }
        });
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);
            }
        });
    }
}