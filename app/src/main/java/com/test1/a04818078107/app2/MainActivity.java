package com.test1.a04818078107.app2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.test1.a04818078107.app2.dao.UserDAO;
import com.test1.a04818078107.app2.modelo.User;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar           = null;
    FloatingActionButton fab  = null;
    private MainHelper helper = null;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        toolbar  = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        helper = new MainHelper( this );


        fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
            //--------------------------------------------------------------- INTENT QUE LEVA A PROXIMA TELA
            Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                    .setAction( "Action", null ).show();
            Intent intentVaiProMain2 = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intentVaiProMain2);
            //--------------------------------------------------------------- RECUPERA OS DADOS DO USUARIO
            User user = helper.pegaUser();
            //--------------------------------------------------------------- MSG QUE PROVA Q GUARDOU AS INFORMAÇÕES
            Toast.makeText( MainActivity.this, "Responsavel " + user.getNomeR(  ) + " Registrado", Toast.LENGTH_SHORT).show();
            finish();
                UserDAO dao = new UserDAO( MainActivity.this );
                dao.insere_Main(user);
                dao.close();
            }
        } );


    }




}
