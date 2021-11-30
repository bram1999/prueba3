package com.example.prueba3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



    public class Dbhelper extends SQLiteOpenHelper {
        public static String Nombre_BD= "Votaciones.db";
        public static int Version_DB=1;
        public static String Tabla_Voto="create table voto (id_voto integer primary key autoincrement, voto_blanco integer not null, voto_null integer not null,voto_boric integer not null, voto_kast integer not null)";


        public Dbhelper(Context context) {
            super(context, Nombre_BD, null, Version_DB);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(Tabla_Voto);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists Voto");
            sqLiteDatabase.execSQL(Tabla_Voto);
        }
    }

