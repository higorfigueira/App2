package com.test1.a04818078107.app2;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.test1.a04818078107.app2.modelo.User;

import org.w3c.dom.Text;

import java.net.PasswordAuthentication;

/**
 * Created by 04818078107 on 20/12/2017.
 */

public class MainHelper {
    private final EditText campoNomeR;
    private final EditText campoEmail;
    private final EditText campoSenhaM;
    private final EditText campoNomeP;

    public MainHelper(MainActivity activity ){
        campoNomeR  = activity.findViewById( R.id.name_responsavel );
        campoEmail  = activity.findViewById( R.id.email );
        campoSenhaM = activity.findViewById( R.id.senha_mestra );
        campoNomeP  = activity.findViewById( R.id.nome_portador );
    }

    public User pegaUser () {
        User user = new User();
        user.setNomeR( campoNomeR.getText().toString() );
        user.setEmail( campoEmail.getText().toString() );
        user.setSenha( campoSenhaM.getText().toString() );
        user.setNomeP( campoNomeP.getText().toString() );

        return user;
    }
}
