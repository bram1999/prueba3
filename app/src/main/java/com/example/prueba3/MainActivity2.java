package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button regresar;
    TextView bl, nu, bo, ka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        regresar = (Button) findViewById(R.id.reg);
        bl = (TextView) findViewById(R.id.blanco);
        nu = (TextView) findViewById(R.id.nulo);
        bo = (TextView) findViewById(R.id.boric);
        ka = (TextView) findViewById(R.id.kast);

        Integer blanco=0,nulo=0,boric=0,kast=0;

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

                    blanco = (C.getInt(1));
                    nulo = (C.getInt(2));
                    boric = (C.getInt(3));
                    kast = (C.getInt(4));

                }
                while(C.moveToNext());
            }
            bl.setText(" "+blanco);
            nu.setText(" "+nulo);
            bo.setText(" "+boric);
            ka.setText(" "+kast);

        }
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}