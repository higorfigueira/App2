package com.test1.a04818078107.app2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import static android.widget.Toast.*;

public class Main2Activity extends AppCompatActivity {
    private Switch switch_por_tempo1   = null;
    private Spinner spinner_por_tempo1 = null;
    private Switch switch_por_tempo2   = null;
    private Spinner spinner_por_tempo2 = null;
    private Switch switch_por_tempo3   = null;
    private Spinner spinner_por_tempo3 = null;
    ArrayAdapter<CharSequence> adapter_hr_block = null;
    ArrayAdapter<CharSequence> adapter_periodo_block2 = null;
    ArrayAdapter<CharSequence> adapter_periodo_block3 = null;
    FloatingActionButton fab2  = null;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        //-------------------------------------------------------------------
        switch_por_tempo1   = findViewById( R.id.switch1 );
        spinner_por_tempo1  = findViewById( R.id.spinner1 );
        switch_por_tempo2  = findViewById( R.id.switch2 );
        spinner_por_tempo2 = findViewById( R.id.spinner2 );
        switch_por_tempo3  = findViewById( R.id.switch3 );
        spinner_por_tempo3 = findViewById( R.id.spinner3 );

        //-------------------------------------------------------------------
        spinner_por_tempo1.setEnabled( false );
        spinner_por_tempo2.setEnabled( false );
        spinner_por_tempo3.setEnabled( false );

        //------------------------------------------------------------------- SPINNER REFERENTE AS HORAS DO BLOQUEIO
        adapter_hr_block = ArrayAdapter.createFromResource(this, R.array.hr_block_array, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter_hr_block.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner

        //------------------------------------------------------------------- SPINNER REFERENTE DO PERIODO DO BLOQUEIO
        adapter_periodo_block2 = ArrayAdapter.createFromResource(this, R.array.periodo_block_array, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter_periodo_block2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner

        //------------------------------------------------------------------- SPINNER REFERENTE DO BLOQUEIO DE HRS POR DIA
        adapter_periodo_block3 = ArrayAdapter.createFromResource(this, R.array.dia_block_array, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter_periodo_block3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner

        //------------------------------------------------------------------- ASSOCIANDO O SPINNER AO SWITCH
        switch_por_tempo1.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if (b){
                    spinner_por_tempo1.setAdapter(adapter_hr_block);
                    //switch_por_tempo2.setChecked( false );
                    switch_por_tempo3.setChecked( false );
                }else{
                    spinner_por_tempo1.setAdapter( null );
                }
                spinner_por_tempo1.setEnabled( switch_por_tempo1.isChecked());
            }
        } );
        switch_por_tempo2.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if (b){
                    spinner_por_tempo2.setAdapter(adapter_periodo_block2);
                    //switch_por_tempo1.setChecked( false );
                    //switch_por_tempo3.setChecked( false );
                }else{
                    spinner_por_tempo2.setAdapter( null );
                }
                spinner_por_tempo2.setEnabled( switch_por_tempo2.isChecked());
            }
        } );
        switch_por_tempo3.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                if (b){
                    spinner_por_tempo3.setAdapter(adapter_periodo_block3);
                    switch_por_tempo1.setChecked( false );
                    //switch_por_tempo2.setChecked( false );
                }else{
                    spinner_por_tempo3.setAdapter( null );
                }
                spinner_por_tempo3.setEnabled( switch_por_tempo3.isChecked());
            }
        } );

        fab2 = findViewById (R.id.fab_2);
        fab2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                makeText( Main2Activity.this, "Encerrado!!!",LENGTH_SHORT).show();
                finish();
            }
        } );

    }

}



