package com.test1.a04818078107.app2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.test1.a04818078107.app2.modelo.User;
import com.test1.a04818078107.app2.modelo.UserConfig;

/**
 * Created by 04818078107 on 21/12/2017.
 */

public class UserDAO extends SQLiteOpenHelper {

    public UserDAO (Context context) {
        super( context, "Usuario", null, 1 );
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "CREATE TABLE User (id INTEGER PRIMARY KEY, nomeR TEXT NOT NULL, email TEXT NOT NULL, senhaM TEXT NOT NULL,nomeP TEXT NOT NULL, tempoEmTempo BOOLEAN, tempoEmTempoB INTEGER, periodo BOOLEAN, periodoB TEXT, horaPorDia BOOLEAN, horaPorDiaB INTEGER);";
        db.execSQL( sql );
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Info";
        db.execSQL( sql );
        onCreate( db );
    }

    public void insere_Main (User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put( "nomeR" , user.getNomeR() );
        dados.put( "email" , user.getEmail() );
        dados.put( "senhaM", user.getSenha() );
        dados.put( "nomeP" , user.getNomeP() );

        db.insert( "User", null, dados);

    }

    public void insere_Main2 (UserConfig userConfig) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados2 = new ContentValues(  );
        dados2.put( "tempoEmTempo", userConfig.isTempoEmTempo());
        dados2.put( "tempoEmTempb", userConfig.getTempoEmTempoB());
        dados2.put( "perido", userConfig.isPerido());
        dados2.put( "peridoB", userConfig.getPeridoB());
        dados2.put( "horasPorDia", userConfig.);
        dados2.put("horasPorDiaB", userConfig.getHorasPorDiaB());

        db.insert( "User", null, dados2);
    }
}
